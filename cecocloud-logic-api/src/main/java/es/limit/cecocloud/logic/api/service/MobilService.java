/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.cecocloud.logic.api.dto.RegistreValidate;
import es.limit.cecocloud.logic.api.dto.RegistreUsuari;

/**
 * Servei encarregat de gestionar els registres d'usuaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MobilService {

	/**
	 * Crea un nou registre d'usuari.
	 * 
	 * @param dto
	 *            informació del registre.
	 */
	public void create(RegistreUsuari dto);

	/**
	 * Inicia el procés de recuperació de contrasenya.
	 * 
	 * @param email
	 *            adreça de correu de l'usuari registrat.
	 */
	public void contrasenyaRecover(String email);

	/**
	 * Valida un usuari registrat canviant la seva contrasenya.
	 * 
	 * @param dto
	 *            informació per a validar el registre.
	 */
	public void validate(RegistreValidate dto);

}
