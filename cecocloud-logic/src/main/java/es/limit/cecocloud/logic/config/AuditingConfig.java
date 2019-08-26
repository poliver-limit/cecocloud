/**
 * 
 */
package es.limit.cecocloud.logic.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Configuració per a les entitats de base de dades auditables.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAware<String>() {
			@Override
			public java.util.Optional<String> getCurrentAuditor() {
				return Optional.ofNullable(SecurityContextHolder.getContext())
						  .map(SecurityContext::getAuthentication)
						  .filter(Authentication::isAuthenticated)
						  .map(Authentication::getName);
			}
		};
	}

}
