/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.service.AuthService;
import es.limit.cecocloud.logic.helper.TokenHelper;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import es.limit.cecocloud.persist.repository.UsuariRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

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

	@Override
	public String create(String usuariCodi) {
		Optional<UsuariEntity> usuari = usuariRepository.findByEmbeddedCodi(usuariCodi);
		return tokenHelper.buildCreate(usuari.get().getEmbedded());
	}

	@Override
	public Authentication get(String token) {
		Jws<Claims> parsedToken = tokenHelper.validate(token);
		String username = parsedToken.getBody().getSubject();
		List<GrantedAuthority> authorities = ((List<?>)parsedToken.getBody().get("rol")).stream().map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
		return new UsernamePasswordAuthenticationToken(username, null, authorities);
	}

}
