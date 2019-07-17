/**
 * 
 */
package es.limit.cecocloud.front.auth;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.front.config.WebSecurityConfig.UserWithName;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * Filtre Spring Security per a l'autenticació emprant tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final String AUTH_LOGIN_URL= "/api/auth";
	private static final String TOKEN_TYPE = "JWT";
	private static final String TOKEN_ISSUER = "secure-api";
	private static final String TOKEN_AUDIENCE = "secure-app";
	private static final long EXPIRATION = 60 * 60 * 1000; // 1 hora

	private final AuthenticationManager authenticationManager;
	private ObjectMapper jsonMapper;

	public JwtAuthenticationFilter(
			AuthenticationManager authenticationManager,
			ObjectMapper jsonMapper) {
		this.authenticationManager = authenticationManager;
		this.jsonMapper = jsonMapper;
		setFilterProcessesUrl(AUTH_LOGIN_URL);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain,
			Authentication authentication) throws JsonProcessingException, IOException {
		User user = ((User)authentication.getPrincipal());
		List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		byte[] signingKey = JwtAuthConstants.JWT_SECRET.getBytes();
		long expiration = System.currentTimeMillis() + EXPIRATION;
		String token;
		if (user instanceof UserWithName) {
			token = Jwts.builder().signWith(
					Keys.hmacShaKeyFor(signingKey),
					SignatureAlgorithm.HS512).
					setHeaderParam("typ", TOKEN_TYPE).
					setIssuer(TOKEN_ISSUER).
					setAudience(TOKEN_AUDIENCE).
					setSubject(user.getUsername()).
					setExpiration(new Date(expiration)).
					claim("rol", roles).
					claim("name", ((UserWithName)user).getName()).
					compact();
		} else {
			token = Jwts.builder().signWith(
					Keys.hmacShaKeyFor(signingKey),
					SignatureAlgorithm.HS512).
					setHeaderParam("typ", TOKEN_TYPE).
					setIssuer(TOKEN_ISSUER).
					setAudience(TOKEN_AUDIENCE).
					setSubject(user.getUsername()).
					setExpiration(new Date(expiration)).
					claim("rol", roles).
					compact();
		}
		response.getWriter().write(jsonMapper.writeValueAsString(
				new JwtAuthResponse(
						token,
						JwtAuthConstants.TOKEN_PREFIX.trim(),
						expiration)));
		response.addHeader(JwtAuthConstants.TOKEN_HEADER, JwtAuthConstants.TOKEN_PREFIX + token);
	}

}