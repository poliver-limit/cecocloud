/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import org.springframework.security.core.Authentication;

import es.limit.cecocloud.logic.api.exception.InvalidTokenException;

/**
 * Servei encarregat de gestionar els tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TokenService {

	/**
	 * Crea un nou token per autenticació.
	 * 
	 * @param usuariCodi
	 *            codi d'usuari.
	 * @return el token d'autenticació generat.
	 */
	public String authCreate(String usuariCodi);

	/**
	 * Retorna l'objecte d'autenticació pel token. Si el token no és
	 * vàlid es llença una excepció.
	 * 
	 * @param token
	 *            el token a comprovar.
	 * @return l'objecte d'autenticació.
	 * @throws InvalidTokenException
	 *             si el token no és vàlid.
	 */
	public Authentication getAuthentication(String token) throws InvalidTokenException;

}
