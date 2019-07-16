/**
 * 
 */
package es.limit.cecocloud.front.auth;

/**
 * Constants per a l'autenticació amb token JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public final class JwtAuthConstants {

	// Signing key for HS512 algorithm
	// You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
	public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";

	private JwtAuthConstants() {
		throw new IllegalStateException("Cannot create instance of static util class");
	}

}
