/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.cecocloud.logic.api.dto.Profile;

/**
 * Servei per a obtenir perfil d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ProfileService {

	/**
	 * Obtenir informació del perfil d'un recurs.
	 * 
	 * @param resourceName
	 *            nom del recurs del qual es vol obtenir el perfil.
	 * @param profileHref
	 *            URL d'accés al perfil.
	 * @return la informació del perfil.
	 * @throws ClassNotFoundException
	 *             si no es troba la classe del DTO o del controlador.
	 */
	public Profile getProfile(
			String resourceName,
			String profileHref) throws ClassNotFoundException;

	/**
	 * Obtenir informació del perfil d'un recurs.
	 * 
	 * @param dtoClass
	 *            classe del DTO del qual es vol obtenir el perfil.
	 * @param profileHref
	 *            URL d'accés al perfil.
	 * @return la informació del perfil.
	 * @throws ClassNotFoundException
	 *             si no es troba la classe del controlador.
	 */
	public Profile getProfile(
			Class<?> dtoClass,
			String profileHref) throws ClassNotFoundException;

}
