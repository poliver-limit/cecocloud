/**
 * 
 */
package es.limit.cecocloud.front.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import es.limit.cecocloud.logic.api.exception.InvalidTokenException;
import es.limit.cecocloud.logic.api.service.TokenService;

/**
 * Filtre Spring Security per a l'autorització emprant tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	@Autowired
	private TokenService tokenService;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Authentication authentication = getAuthentication(request);
		if (authentication == null) {
			filterChain.doFilter(request, response);
			return;
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}

	private Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JwtAuthConstants.TOKEN_HEADER);
		if (StringUtils.isNotEmpty(token) && token.startsWith(JwtAuthConstants.TOKEN_PREFIX)) {
			try {
				return tokenService.getAuthentication(token.replace("Bearer ", ""));
			} catch (InvalidTokenException ex) {
			}
		}
		return null;
	}

}