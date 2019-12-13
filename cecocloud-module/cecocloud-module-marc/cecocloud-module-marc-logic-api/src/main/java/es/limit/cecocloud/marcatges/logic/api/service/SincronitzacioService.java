/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.service;

import java.util.Date;
import java.util.List;

import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioIdentificadorPeticio;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioIdentificadorResposta;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioResposta;

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

	/**
	 * Consulta els marcatges d'un identificador disponibles a cecocloud.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param dataInici
	 *            data inicial per a la consulta.
	 * @param dataFi
	 *            data final per a la consulta (opcional).
	 * 
	 * @return la llista de marcatges.
	 */
	public List<SincronitzacioMarcatge> marcatgeFind(
			String identificadorCodi,
			Date dataInici,
			Date dataFi);

	/**
	 * Crea els marcatges de cecogest a dins cecocloud.
	 * 
	 * @param identificadorCodi
	 *            codi de l'identificador a sincronitzar.
	 * @param marcatges
	 *            llista de marcatges per a crear.
	 * 
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta marcatgeCreate(
			String identificadorCodi,
			List<SincronitzacioMarcatge> marcatges);

}
