/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.logic.api.dto.SincronitzacioIdentificadorResposta;

/**
 * Servei encarregat de gestionar la sincronització de la informació provinent de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SincronitzacioService {

	/**
	 * Sincronitza la informació (empreses i operaris) d'un identificador.
	 * 
	 * @param peticio
	 *            informació de l'identificador a sincronitzar.
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioIdentificadorResposta sincronitzarIdentificador(
			SincronitzacioIdentificadorPeticio peticio);

}
