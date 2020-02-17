/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.service;

import java.util.Date;
import java.util.List;

import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;
import es.limit.cecocloud.marc.logic.api.dto.SincronitzacioMarcatge;

/**
 * Servei encarregat de gestionar la sincronització d'informació entre
 * CECOCLOUD i CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SincronitzacioService {

	/**
	 * Consulta els marcatges d'un identificador disponibles a CECOCLOUD.
	 * 
	 * @param identificadorCodi
	 *            codi de l'identificador.
	 * @param empresaCodi
	 *            codi de l'empresa (opcional).
	 * @param dataInici
	 *            data inicial per a la consulta.
	 * @param dataFi
	 *            data final per a la consulta (opcional).
	 * 
	 * @return la llista de marcatges.
	 */
	public List<SincronitzacioMarcatge> marcatgeFind(
			String identificadorCodi,
			String empresaCodi,
			Date dataInici,
			Date dataFi);

	/**
	 * Crea els marcatges de cecogest a dins CECOCLOUD.
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
