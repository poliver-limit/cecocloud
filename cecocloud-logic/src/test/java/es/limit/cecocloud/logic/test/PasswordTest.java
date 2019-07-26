/**
 * 
 */
package es.limit.cecocloud.logic.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Test per a l'encritació de contrasenyes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PasswordTest {

	private static final String PASSWORD = "test";

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Test
	public void generatePassword() {
		System.out.println("Password \"" + PASSWORD + "\" encoded: " + passwordEncoder.encode(PASSWORD));
	}

}
