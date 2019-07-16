/**
 * 
 */
package es.limit.cecocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Aplicació Cecocloud.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class CecocloudApp {

	public static void main(String[] args) {
		SpringApplication.run(
				CecocloudApp.class,
				args);
	}

}
