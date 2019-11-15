/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.service;

import java.util.Date;
import java.util.List;

import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioIdentificador;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioOperari;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioResposta;

/**
 * Servei encarregat de gestionar la sincronització de la informació provinent de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SincronitzacioService {

	/**
	 * Sincronitza els identificadors d'una companyia.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param identificadors
	 *            informació dels identificadors a sincronitzar.
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta sincronitzarIdentificadors(
			Long companyiaId,
			List<SincronitzacioIdentificador> identificadors);

	/**
	 * Sincronitza les empreses d'una companyia.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param empreses
	 *            informació de les empreses a sincronitzar.
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta sincronitzarEmpreses(
			Long companyiaId,
			List<SincronitzacioEmpresa> empreses);

	/**
	 * Sincronitza els operaris d'una companyia.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param operaris
	 *            informació dels operaris a sincronitzar.
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta sincronitzarOperaris(
			Long companyiaId,
			List<SincronitzacioOperari> operaris);

	/**
	 * Consulta de marcatges.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param empreses
	 *            llista d'empreses per a la consulta.
	 * @param dataInici
	 *            data inicial per a la consulta.
	 * @param dataFi
	 *            data final per a la consulta (opcional).
	 * 
	 * @return la llista de marcatges.
	 */
	public List<SincronitzacioMarcatge> marcatgeFind(
			Long companyiaId,
			List<SincronitzacioEmpresa> empreses,
			Date dataInici,
			Date dataFi);

	/**
	 * Dona d'alta els marcatges fets a CECOGEST.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param marcatges
	 *            llista de marcatges per a crear.
	 * 
	 * @return el resultat de la sincronització.
	 */
	public SincronitzacioResposta marcatgeCreate(
			Long companyiaId,
			List<SincronitzacioMarcatge> marcatges);

}
