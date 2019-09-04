/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.cecocloud.logic.api.dto.SincronitzacioCompanyia;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgesConsulta;
import es.limit.cecocloud.logic.api.dto.SincronitzacioMarcatgesEnviament;
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
	 * @return el resultat de la sincronització.
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
	public List<SincronitzacioMarcatge> marcatgeFind(SincronitzacioMarcatgesConsulta consulta);

	/**
	 * Dona d'alta els marcatges fets a CECOGEST.
	 * 
	 * @param marcatges
	 *            la llista de marcatges fets a CECOGEST.
	 * 
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta marcatgeCreate(SincronitzacioMarcatgesEnviament marcatges);

}
