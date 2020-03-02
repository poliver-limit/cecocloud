/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.logic.api.permission.ExternalGrantedAuthority;
import es.limit.base.boot.logic.api.service.SessionService;
import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.base.boot.persist.repository.UsuariRepository;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.exception.InvalidSessionDataException;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.entity.PerfilUsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.repository.PerfilUsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorEmpresaRepository;
import es.limit.cecocloud.persist.repository.UsuariIdentificadorRepository;

/**
 * Implementació del servei encarregat de gestionar les sessions d'usuari del front.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private ObjectMapper jacksonObjectMapper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private PerfilUsuariIdentificadorEmpresaRepository perfilUsuariIdentificadorEmpresaRepository;
	@Autowired
	private UsuariIdentificadorEmpresaRepository usuariIdentificadorEmpresaRepository;
	@Autowired
	private UsuariIdentificadorRepository usuariIdentificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Override
	public Object parseJsonSession(
			JsonNode jsonNode,
			boolean validate) {
		UserSession session = jacksonObjectMapper.convertValue(jsonNode, UserSession.class);
		if (validate) {
			try {
				// Verificar que es te accés a l'identificador
				IdentificadorEntity identificador = identificadorRepository.findById(session.getI()).get();
				UsuariIdentificadorEntity usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
						usuariRepository.findByEmbeddedCodi(authenticationHelper.getPrincipalName()).get(),
						identificador).get();
				if (usuariIdentificador.getEmbedded().isActiu()) {
					// Verificar que l'empresa pertany a l'identificador
					EmpresaEntity empresa = empresaRepository.findByIdentificadorAndId(
							identificador,
							session.getE()).get();
					if (empresa.getEmbedded().isActiva()) {
						// Verificar que es te accés a l'empresa
						usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
								usuariIdentificador,
								empresa).get();
					} else {
						// No es te accés a l'empresa perquè no està activa
						throw new InvalidSessionDataException("L'empresa està desactivada");
					}
				} else {
					// No es te accés a l'identificador perquè no està actiu
					throw new InvalidSessionDataException("L'identificador està desactivat");
				}
			} catch (NoSuchElementException ex) {
				// No es te accés
				throw new InvalidSessionDataException("Informació de sessió no vàlida");
			}
		}
		return session;
	}

	@Override
	public Object parseJwtSession(Map<String, Object> jwtSession) {
		if (jwtSession == null) {
			return null;
		} else {
			UserSession session = new UserSession();
			session.setI(
					objectToLong(jwtSession.get("i")));
			session.setE(
					objectToLong(jwtSession.get("e")));
			return session;
		}
	}

	@Override
	public List<GrantedAuthority> getAuthoritiesFromSession(String usuariCodi, Object session) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (usuariCodi != null) {
			Long empresaId = null;
			UserSession userSession = (UserSession)session;
			if (userSession != null) {
				empresaId = userSession.getE();
			}
			if (empresaId != null) { // && identificadorCodi != null) {
				// Retorna els perfils associats a l'usuari com a GrantedAuthority
				Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariCodi);
				Optional<EmpresaEntity> empresa = empresaRepository.findById(empresaId);
				if (empresa.isPresent()) {
					IdentificadorEntity identificador = empresa.get().getIdentificador();
					Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
							usuari.get(),
							identificador);
					Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
							usuariIdentificador.get(),
							empresa.get());
					List<PerfilUsuariIdentificadorEmpresaEntity> perfilsUsuariIdentificadorEmpresa = null;
					if (usuariIdentificadorEmpresa.isPresent())
						perfilsUsuariIdentificadorEmpresa = perfilUsuariIdentificadorEmpresaRepository.findByUsuariIdentificadorEmpresa(usuariIdentificadorEmpresa.get());
					if (perfilsUsuariIdentificadorEmpresa != null && !perfilsUsuariIdentificadorEmpresa.isEmpty()) {
						grantedAuthorities = perfilsUsuariIdentificadorEmpresa.stream().map(
								perfilUsuariIdentificadorEmpresa -> new ExternalGrantedAuthority("Perfil_" + perfilUsuariIdentificadorEmpresa.getPerfil().getId().toString())).collect(Collectors.toList()); 
					}
				}
			}
		}
		return grantedAuthorities;
	}

	private Long objectToLong(Object o) {
		if (o == null) {
			return null;
		} else {
			if (o instanceof Number) {
				return ((Number)o).longValue();
			} else if (o instanceof String) {
				return Long.parseLong((String)o);
			} else {
				return null;
			}
		}
	}

}
