/**
 * 
 */
package es.limit.cecocloud;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.ForwardedHeaderFilter;

/**
 * Aplicació Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SpringBootApplication
@ComponentScan({"es.limit.cecocloud", "es.limit.base.boot"})
@EnableJpaRepositories({"es.limit.cecocloud", "es.limit.base.boot"})
@EntityScan({"es.limit.cecocloud", "es.limit.base.boot"})
@EnableScheduling
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class CecocloudApp {

	public static void main(String[] args) {
		SpringApplication.run(
				CecocloudApp.class,
				args);
	}

	// Filtre per a processar les capçaleres HTTP X-Forwarded-* i permetre que Spring
	// Data REST generi correctament els links dels recursos quan l'aplicació està
	// desplegada darrera un proxy HTTP.
	@Bean
	public Filter forwardedHeaderFilter() {
		return new ForwardedHeaderFilter();
	}

}
