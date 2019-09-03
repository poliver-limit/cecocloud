/**
 * 
 */
package es.limit.cecocloud.front.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.limit.cecocloud.back.controller.AbstractIdentificableReadOnlyApiController;
import es.limit.cecocloud.back.controller.ApiControllerHelper;
import es.limit.cecocloud.front.auth.JwtAuthenticationFilter;
import es.limit.cecocloud.front.auth.JwtAuthorizationFilter;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.AuthService;

/**
 * Configuració per a l'autenticació dels usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private AuthService authService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizationRegistry = http.
				cors().and().csrf().disable().
				authorizeRequests().
				antMatchers("/api/auth", "/api/auth/**/*").permitAll().
				antMatchers("/api/registres/**/*").permitAll();
		addAntMatchersFromApiControllers(authorizationRegistry);
//		authorizationRegistry.
//		antMatchers("/api/usuaris", "/api/usuaris/**/*").hasAuthority("ADMIN").
//		antMatchers("/api/companyies", "/api/companyies/**/*").hasAuthority("ADMIN").
//		antMatchers("/api/empreses", "/api/empreses/**/*").hasAuthority("ADMIN").
//		antMatchers("/api/operaris", "/api/operaris/**/*").hasAnyAuthority("ADMIN", "MARCA").
//		antMatchers("/api/marcatges", "/api/marcatges/**/*").hasAnyAuthority("ADMIN", "MARCA").
		authorizationRegistry.antMatchers("/api/sync/**/*").hasAuthority("SYNC").
		antMatchers("/api/mobile/marcatges", "/api/mobile/marcatges/**/*").hasAuthority("MARCA").
		antMatchers("/api/**/*").authenticated().
		anyRequest().permitAll().
		and().
		addFilter(new JwtAuthenticationFilter(authenticationManager(), authService, mapper)).
		addFilter(new JwtAuthorizationFilter(authenticationManager(), authService)).
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(
				new UserDetailsService() {
					@Override
				    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
				    	Usuari usuari = authService.getUsuariForAuthentication(username);
				    	if (usuari != null) {
				    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				    		if (usuari.getRols() != null) {
					    		for (Rol rol: usuari.getRols()) {
					    			authorities.add(new SimpleGrantedAuthority(rol.toString()));
					    		}
				    		}
				    		return new User(
					    			usuari.getCodi(),
					    			usuari.getContrasenya(),
					    			authorities);
				    	} else {
				    		throw new UsernameNotFoundException("User " + username + " not found or not eligible for authentication");
				    	}
				    }
				}).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	private void addAntMatchersFromApiControllers(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizationRegistry) throws ClassNotFoundException {
		for (@SuppressWarnings("rawtypes") Class<? extends AbstractIdentificableReadOnlyApiController> apiControllerClass: ApiControllerHelper.getApiControllerClasses()) {
			String[] apiUrls = ApiControllerHelper.getApiUrlsFromApiController(apiControllerClass);
			Class<? extends Identificable<?>> dtoClass = ApiControllerHelper.getDtoClassFromApiController(apiControllerClass);
			RestapiResource restapiResource = dtoClass.getAnnotation(RestapiResource.class);
			if (restapiResource != null) {
				addAntMatcher(
						authorizationRegistry,
						HttpMethod.POST,
						apiUrls,
						restapiResource.authoritiesWithCreatePermission());
				addAntMatcher(
						authorizationRegistry,
						HttpMethod.GET,
						apiUrls,
						restapiResource.authoritiesWithReadPermission());
				addAntMatcher(
						authorizationRegistry,
						HttpMethod.PUT,
						apiUrls,
						restapiResource.authoritiesWithUpdatePermission());
				addAntMatcher(
						authorizationRegistry,
						HttpMethod.PATCH,
						apiUrls,
						restapiResource.authoritiesWithUpdatePermission());
				addAntMatcher(
						authorizationRegistry,
						HttpMethod.DELETE,
						apiUrls,
						restapiResource.authoritiesWithDeletePermission());
			}
		}
	}

	private void addAntMatcher(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizationRegistry,
			HttpMethod httpMethod,
			String apiUrls[],
			Rol[] authorities) {
		for (String apiUrl: apiUrls) {
			if (authorities != null && authorities.length > 0) {
				authorizationRegistry.antMatchers(httpMethod, apiUrl, apiUrl + "/**/*").hasAnyAuthority(
						Arrays.stream(authorities).map(authority -> authority.name()).toArray(String[]::new));
				//System.out.println(">>>    antMatchers(HttpMethod." + httpMethod + ", \"" + apiUrl + "\", \"" + apiUrl + "/**/*\").hasAnyAuthority(" + authorities + ").");
			} else {
				authorizationRegistry.antMatchers(httpMethod, apiUrl, apiUrl + "/**/*").authenticated();
				//System.out.println(">>>    antMatchers(HttpMethod." + httpMethod + ", \"" + apiUrl + "\", \"" + apiUrl + "/**/*\").authenticated().");
			}
		}
	}

}
