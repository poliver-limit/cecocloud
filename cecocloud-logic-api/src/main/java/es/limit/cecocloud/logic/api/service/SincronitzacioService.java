/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgeConsulta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioResposta;

/**
 * Servei encarregat de gestionar la sincronització de la informació provinent de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SincronitzacioService {

	/**
	 * Sincronitza la informació d'una companyia.
	 * 
	 * @param sincronitzacioCompanyia
	 *            informació de sincronització.
	 * 
	 * @return el marcatge creat.
	 */
	public SincronitzacioResposta sincronitzar(SincronitzacioCompanyia sincronitzacioCompanyia);

	/**
	 * Consulta de marcatges.
	 * 
	 * @param consulta
	 *            paràmetres de la consulta.
	 * 
	 * @return la llista de marcatges.
	 */
	public List<SincronitzacioMarcatge> marcatgeFind(SincronitzacioMarcatgeConsulta consulta);

}
