/**
 * 
 */
package es.limit.cecocloud.front.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.logic.api.service.AuthService;

/**
 * Filtre Spring Security per a l'autenticació emprant tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final String AUTH_LOGIN_URL= "/api/auth";

	@Autowired
	private AuthService authService;

	private final AuthenticationManager authenticationManager;
	private ObjectMapper jsonMapper;

	public JwtAuthenticationFilter(
			AuthenticationManager authenticationManager,
			ObjectMapper jsonMapper,
			ApplicationContext ctx) { //añadido
		this.authenticationManager = authenticationManager;
		this.jsonMapper = jsonMapper;
		this.authService= ctx.getBean(AuthService.class); //añadido
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
		String token = authService.create(user.getUsername());
		response.getWriter().write(jsonMapper.writeValueAsString(
				new JwtAuthResponse(
						token,
						"Bearer")));
		response.addHeader(JwtAuthConstants.TOKEN_HEADER, JwtAuthConstants.TOKEN_PREFIX + token);
	}

}