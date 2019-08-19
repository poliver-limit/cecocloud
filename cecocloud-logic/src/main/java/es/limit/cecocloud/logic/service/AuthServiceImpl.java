/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.exception.InvalidTokenException;
import es.limit.cecocloud.logic.api.service.AuthService;
import es.limit.cecocloud.logic.helper.TokenHelper;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.UsuariRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació del servei encarregat de gestionar l'autenticació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private UsuariRepository usuariRepository;
	@Autowired
	protected MapperFacade orikaMapperFacade;

	private DtoConverter<Usuari, UsuariEntity, Long> dtoConverter;

	@Override
	@Transactional(readOnly = true)
	public Usuari getUsuariForAuthentication(String usuariCodi) {
		Optional<UsuariEntity> usuariEntity = usuariRepository.findByEmbeddedCodi(usuariCodi);
		try {
			Usuari usuari = usuariEntity.get().getEmbedded();
			if (usuari.isValidat() && usuari.isActiu()) {
				return getDtoConverter().toDto(usuariEntity.get());
			}
		} catch (NoSuchElementException ex) {
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public String tokenCreate(String usuariCodi) {
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariCodi);
		return tokenHelper.buildAuth(
				usuari.get().getEmbedded(),
				usuari.get().getRols());
	}

	@Override
	@Transactional(readOnly = true)
	public String tokenRefresh(String token) throws InvalidTokenException {
		Jws<Claims> parsedToken = tokenHelper.validate(token, true);
		Integer rexp = (Integer)parsedToken.getBody().get("rexp");
		if (rexp == null) {
			throw new InvalidTokenException(
					token,
					"Request to refresh token failed (" +
					"token=" + token + ", " +
					"rexp=" + rexp + "): " +
					"invalid rexp field");
		}
		System.out.println(">>> refreshExpirationDate: " + rexp + ", " + rexp * 1000L + ", " + System.currentTimeMillis());
		if (System.currentTimeMillis() > rexp * 1000L) {
			throw new InvalidTokenException(
					token,
					"Request to refresh token failed (" +
					"token=" + token + ", " +
					"now=" + System.currentTimeMillis() + ", " +
					"rexp=" + rexp + "): " +
					"refresh period expired");
		}
		String usuariCodi = parsedToken.getBody().getSubject();
		Usuari usuari = getUsuariForAuthentication(usuariCodi);
		if (usuari != null) {
			return tokenCreate(usuariCodi);
		} else {
			throw new InvalidTokenException(token, "Request to refresh token failed (token=" + token + ", user=" + usuariCodi + "): user not eligible for authentication");
		}
	}

	@Override
	public boolean tokenCheck(String token) {
		try {
			tokenHelper.validate(token, false);
			return true;
		} catch (InvalidTokenException ex) {
			return false;
		}
	}

	@Override
	public Authentication tokenToAuthentication(String token) {
		Jws<Claims> parsedToken = tokenHelper.validate(token, false);
		String usuariCodi = parsedToken.getBody().getSubject();
		List<GrantedAuthority> authorities = null;
		if (parsedToken.getBody().get("rol") != null) {
			authorities = ((List<?>)parsedToken.getBody().get("rol")).stream().map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
		}
		return new UsernamePasswordAuthenticationToken(usuariCodi, null, authorities);
	}

	protected DtoConverter<Usuari, UsuariEntity, Long> getDtoConverter() {
		if (dtoConverter == null) {
			dtoConverter = new DtoConverter<Usuari, UsuariEntity, Long>(
					Usuari.class,
					UsuariEntity.class,
					orikaMapperFacade);
		}
		return dtoConverter;
	}

}
