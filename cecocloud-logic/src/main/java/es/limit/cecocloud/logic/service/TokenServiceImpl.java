/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.service.TokenService;
import es.limit.cecocloud.logic.helper.TokenHelper;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.UsuariRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * Implementació del servei encarregat de generar tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private UsuariRepository usuariRepository;

	@Override
	public String authCreate(String usuariCodi) {
		UsuariEntity usuari = usuariRepository.findByEmbeddedCodi(usuariCodi);
		if (usuari != null) {
			return tokenHelper.buildCreate(usuari.getEmbedded());
		} else {
			throw new EntityNotFoundException("Usuari amb codi " + usuariCodi);
		}
	}

	@Override
	public Authentication getAuthentication(String token) {
		Jws<Claims> parsedToken = tokenHelper.validate(token);
		String username = parsedToken.getBody().getSubject();
		List<GrantedAuthority> authorities = ((List<?>)parsedToken.getBody().get("rol")).stream().map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
		return new UsernamePasswordAuthenticationToken(username, null, authorities);
	}

}
