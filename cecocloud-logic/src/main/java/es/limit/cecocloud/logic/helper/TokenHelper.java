/**
 * 
 */
package es.limit.cecocloud.logic.helper;

import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
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
	private static final long EXPIRATION_AUTH = 60 * 1000; // 1 hora
	private static final long EXPIRATION_REFRESH = 30 * 24 * 60 * 60 * 1000L; // 30 dies
	private static final String TOKEN_AUDIENCE_VALIDATION = "validation";
	private static final long EXPIRATION_VALIDATION = 24 * 60 * 60 * 1000; // 1 dia
	private static final String TOKEN_AUDIENCE_RECOVERY = "recovery";
	private static final long EXPIRATION_RECOVERY = 24 * 60 * 60 * 1000; // 1 dia

	public String buildAuth(
			Usuari usuari,
			Collection<Rol> rols) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_AUTH,
				EXPIRATION_AUTH,
				EXPIRATION_REFRESH,
				rols);
	}

	public String buildValidate(Usuari usuari) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_VALIDATION,
				EXPIRATION_VALIDATION,
				null,
				null);
	}

	public String buildRecover(Usuari usuari) {
		return createNewToken(
				usuari,
				TOKEN_TYPE,
				TOKEN_ISSUER,
				TOKEN_AUDIENCE_RECOVERY,
				EXPIRATION_RECOVERY,
				null,
				null);
	}

	public Jws<Claims> validate(
			String token, 
			boolean retryWithoutCheckingValidity) {
		String exceptionMessage;
		Throwable t;
		try {
			return validateWithoutCatchingException(token, null);
		} catch (ExpiredJwtException ex) {
			if (retryWithoutCheckingValidity) {
				try {
					return validateWithoutCatchingException(token, new Clock() {
						@Override
						public Date now() {
							return new Date(0);
						}
					});
				} catch (Exception ex2) {
				}
			}
			exceptionMessage = "Request to parse expired JWT";
			t = ex;
		} catch (UnsupportedJwtException ex) {
			exceptionMessage = "Request to parse unsupported JWT";
			t = ex;
		} catch (MalformedJwtException ex) {
			exceptionMessage = "Request to parse invalid JWT";
			t = ex;
		} catch (SignatureException ex) {
			exceptionMessage = "Request to parse JWT with invalid signature";
			t = ex;
		} catch (IllegalArgumentException ex) {
			exceptionMessage = "Request to parse empty or null JWT";
			t = ex;
		}
		log.warn(exceptionMessage + ": {} failed: {}", token, t.getMessage());
		throw new InvalidTokenException(token, exceptionMessage, t);
	}

	private Jws<Claims> validateWithoutCatchingException(String token, Clock clock) {
		JwtParser jwtParser = Jwts.parser().
				setSigningKey(JWT_SECRET.getBytes()).
				requireIssuer(TOKEN_ISSUER);
		if (clock != null) {
			jwtParser.setClock(clock);
		}
		return jwtParser.parseClaimsJws(token);
	}

	private String createNewToken(
			Usuari usuari,
			String type,
			String issuer,
			String audience,
			long expiration,
			Long refreshExpiration,
			Collection<Rol> rols) {
		Date expirationDate = new Date(System.currentTimeMillis() + expiration);
		log.debug("Generant token JWT (" +
				"usuariCodi=" + usuari.getCodi() + ", " +
				"usuariNom=" + usuari.getNom() + ", " +
				"rols=" + rols + ", " +
				"expiration=" + expirationDate + ")");
		JwtBuilder builder = Jwts.builder().signWith(
				Keys.hmacShaKeyFor(JWT_SECRET.getBytes()),
				SignatureAlgorithm.HS512).
				setHeaderParam("typ", type).
				setIssuer(issuer).
				setAudience(audience).
				setSubject(usuari.getCodi()).
				setExpiration(expirationDate).
				claim("name", usuari.getNom()).
				claim("email", usuari.getEmail());
		if (refreshExpiration != null) {
			builder.claim("rexp", (System.currentTimeMillis() + refreshExpiration) / 1000);
		}
		if (rols != null) {
			builder.claim("rol", rols);
		}
		return builder.compact();
	}

}
