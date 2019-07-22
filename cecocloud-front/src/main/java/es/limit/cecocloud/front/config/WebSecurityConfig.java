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
import es.limit.cecocloud.logic.api.service.UsuariService;

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
	private UsuariService usuariService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		cors().and().csrf().disable().
		authorizeRequests().
		antMatchers("/api/auth").permitAll().
		antMatchers("/api/registres/**/*").permitAll().
		antMatchers("/api/mobile/marcatge/**/*").hasAuthority("MARCA").
		antMatchers("/api/sync/**/*").hasAuthority("SYNC").
		antMatchers("/api/**").hasAuthority("ADMIN").
		anyRequest().permitAll().
		and().
		addFilter(new JwtAuthenticationFilter(authenticationManager(), mapper)).
		addFilter(new JwtAuthorizationFilter(authenticationManager())).
		sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().
		withUser("user").
		password(passwordEncoder().encode("password")).
		authorities("ROLE_USER");*/
		auth.userDetailsService(
				new UserDetailsService() {
					@Override
				    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
				    	Usuari usuari = usuariService.findOneByRsqlQuery("codi==" + username);
				    	if (usuari != null) {
				    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				    		for (Rol rol: usuari.getRols()) {
				    			authorities.add(new SimpleGrantedAuthority(rol.toString()));
				    		}
				    		return new User(
					    			usuari.getCodi(),
					    			usuari.getContrasenya(),
					    			authorities);
				    		/*UserWithName user = new UserWithName(
					    			usuari.getCodi(),
					    			usuari.getContrasenya(),
					    			authorities);
				    		user.setName(usuari.getNom());
				    		return user;*/
				    	} else {
				    		throw new UsernameNotFoundException("Usuari " + username + " no trobat");
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

	/*@Getter
	@Setter
	public static class UserWithName extends User {
		protected String name;
		public UserWithName(
				String username,
				String password,
				Collection<? extends GrantedAuthority> authorities) {
			super(username, password, authorities);
		}
		public UserWithName(
				String username,
				String password,
				boolean enabled,
				boolean accountNonExpired,
				boolean credentialsNonExpired,
				boolean accountNonLocked,
				Collection<? extends GrantedAuthority> authorities) {
			super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		}
		private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	}*/

}
