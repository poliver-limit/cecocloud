/**
 * 
 */
package es.limit.cecocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Aplicació back del mòdul comú.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SpringBootApplication
public class TestApp {

	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
