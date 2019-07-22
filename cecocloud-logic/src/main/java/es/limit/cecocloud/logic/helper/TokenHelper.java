/**
 * 
 */
package es.limit.cecocloud.logic.helper;

import java.util.Date;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;

/**
 * Helper encarregat de crear i validar tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Service
public class TokenHelper {

	// Signing key for HS512 algorithm
	// You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
	public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

	private static final String TOKEN_TYPE = "JWT";
	private static final String TOKEN_ISSUER = "cecocloud";
	private static final String TOKEN_AUDIENCE_AUTH = "auth";
	private static final long EXPIRATION_AUTH = 24 * 60 * 60 * 1000; // 1 dia
	private static final String TOKEN_AUDIENCE_VALIDATION = "validation";
	private static final long EXPIRATION_VALIDATION = 24 * 60 * 60 * 1000; // 1 dia
	private static final String TOKEN_AUDIENCE_RECOVERY = "recovery";
	private static final long EXPIRATION_RECOVERY = 24 * 60 * 60 * 1000; // 1 dia

	public String buildCreate(Usuari usuari) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_AUTH,
				EXPIRATION_AUTH);
	}

	public String buildValidate(Usuari usuari) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_VALIDATION,
				EXPIRATION_VALIDATION);
	}

	public String buildRecover(Usuari usuari) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_RECOVERY,
				EXPIRATION_RECOVERY);
	}

	public Jws<Claims> validate(String token) {
		try {
			return Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(token);
		} catch (ExpiredJwtException exception) {
			log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
		} catch (UnsupportedJwtException exception) {
			log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
		} catch (MalformedJwtException exception) {
			log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
		} catch (SignatureException exception) {
			log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
		} catch (IllegalArgumentException exception) {
			log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
		}
		throw new InvalidTokenException();
	}

	private String createNewToken(
			Usuari usuari,
			String type,
			String issuer,
			String audience,
			long expiration) {
		return Jwts.builder().signWith(
				Keys.hmacShaKeyFor(JWT_SECRET.getBytes()),
				SignatureAlgorithm.HS512).
				setHeaderParam("typ", type).
				setIssuer(issuer).
				setAudience(audience).
				setSubject(usuari.getCodi()).
				setExpiration(new Date(System.currentTimeMillis() + expiration)).
				claim("rol", usuari.getRols()).
				claim("name", usuari.getNom()).
				compact();
	}

}
