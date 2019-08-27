/**
 * 
 */
package es.limit.cecocloud.front.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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

import es.limit.cecocloud.front.auth.JwtAuthenticationFilter;
import es.limit.cecocloud.front.auth.JwtAuthorizationFilter;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
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
		http.
		cors().and().csrf().disable().
		authorizeRequests().
		antMatchers("/api/auth", "/api/auth/**/*").permitAll().
		antMatchers("/api/registres/**/*").permitAll().
		antMatchers("/api/usuaris", "/api/usuaris/**/*").hasAuthority("ADMIN").
		antMatchers("/api/companyies", "/api/companyies/**/*").hasAuthority("ADMIN").
		antMatchers("/api/empreses", "/api/empreses/**/*").hasAuthority("ADMIN").
		antMatchers("/api/operaris", "/api/operaris/**/*").hasAuthority("ADMIN").
		antMatchers("/api/marcatges", "/api/marcatges/**/*").hasAnyAuthority("ADMIN", "MARCA").
		antMatchers("/api/sync/**/*").hasAuthority("SYNC").
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

}
