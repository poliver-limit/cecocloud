/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.base.boot.logic.api.service.SessionService;
import es.limit.cecocloud.logic.api.dto.UserSession;

/**
 * Implementació del servei encarregat de gestionar les sessions d'usuari del front.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private ObjectMapper jacksonObjectMapper;

	@Override
	public Object parseJsonSession(JsonNode jsonNode) {
		return jacksonObjectMapper.convertValue(jsonNode, UserSession.class);
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
				// TODO retornar les funcionalitats associades a l'usuari com a GrantedAuthority
				/*Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariCodi);
				Optional<EmpresaEntity> empresa = empresaRepository.findById(empresaId);
				IdentificadorEntity identificador = empresa.get().getIdentificador();
				Optional<UsuariIdentificadorEntity> usuariIdentificador = usuariIdentificadorRepository.findByUsuariAndIdentificador(
						usuari.get(),
						identificador);
				Optional<UsuariIdentificadorEmpresaEntity> usuariIdentificadorEmpresa = usuariIdentificadorEmpresaRepository.findByUsuariIdentificadorAndEmpresa(
						usuariIdentificador.get(),
						empresa.get());
				List<PerfilUsuariIdentificadorEmpresaEntity> perfils = perfilUsuariIdentificadorEmpresaRepository.findByUsuariIdentificadorEmpresa(
						usuariIdentificadorEmpresa.get());
				if (perfils != null && !perfils.isEmpty()) {
					//grantedAuthorities = rols.stream().map(rol -> new ExternalGrantedAuthority(rol.getId().toString())).collect(Collectors.toList()); 
				}*/
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
