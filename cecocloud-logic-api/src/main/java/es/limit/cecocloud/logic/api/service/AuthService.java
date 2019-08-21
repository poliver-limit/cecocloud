/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import org.springframework.security.core.Authentication;

import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.exception.InvalidTokenException;

/**
 * Servei encarregat de gestionar els tokens JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface AuthService {

	/**
	 * Obté un usuari per a realitzar l'autenticació.
	 * 
	 * @param usuariCodi
	 *            codi d'usuari.
	 * @return l'usuari o null si l'usuari no existeix o no és autenticable.
	 */
	public Usuari getUsuariForAuthentication(String usuariCodi);

	/**
	 * Crea un nou token per autenticació.
	 * 
	 * @param usuariCodi
	 *            codi d'usuari.
	 * @return el token d'autenticació generat.
	 */
	public String tokenCreate(String usuariCodi);

	/**
	 * Retorna un nou token a partir d'un token JWT vàlid o expirat. El
	 * nou token tendrà una nova data d'expiració basada en la data
	 * actual. Si el token no és pot refrescar es llença una excepció.
	 * 
	 * @param token
	 *            el token a refrescar.
	 * @param session
	 *            la sessió d'usuari per a ficar a dins el token.
	 * @return el token d'autenticació generat.
	 * @throws InvalidTokenException
	 *             si el token no és vàlid per a ser refrescat.
	 */
	public String tokenRefresh(
			String token,
			UserSession session) throws InvalidTokenException;

	/**
	 * Valida un token JWT.
	 * 
	 * @param token
	 *            el token a validar.
	 * @return true si el token és vàlid o false en cas contrari.
	 */
	public boolean tokenCheck(String token);

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
	public Authentication tokenToAuthentication(String token) throws InvalidTokenException;

	/**
	 * Retorna la informació de sessió continguda a dins el token JWT.
	 * 
	 * @param token
	 *            el token a comprovar.
	 * @return la informació de sessió.
	 * @throws InvalidTokenException
	 *             si el token no és vàlid.
	 */
	public UserSession getUserSession(String token) throws InvalidTokenException;

}
