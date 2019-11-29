/**
 * 
 */
package es.limit.cecocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Aplicació de test.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SpringBootApplication
@ComponentScan({"es.limit.cecocloud", "es.limit.base.boot"})
@EnableJpaRepositories({"es.limit.cecocloud", "es.limit.base.boot"})
@EntityScan({"es.limit.cecocloud", "es.limit.base.boot"})
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class TestApp {

	public static void main(String[] args) {
		SpringApplication.run(
				TestApp.class,
				args);
	}

}
