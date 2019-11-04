/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioEmpresa;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioEmpresaAmbOperaris;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioMarcatge;
import es.limit.cecocloud.marcatges.logic.api.dto.SincronitzacioResposta;

/**
 * Servei encarregat de gestionar la sincronització de la informació provinent de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SincronitzacioService {

	/**
	 * Sincronitza la informació d'una companyia.
	 * 
	 * @param companyiaId
	 *            identificador de la companyia.
	 * @param empreses
	 *            informació de les empreses per a la sincronització.
	 * 
	 * @return el resultat de la sincronització.
	 */
	@PreAuthorize("hasPermission(#companyiaId, 'es.limit.cecocloud.logic.api.dto.Companyia', 'SYNC')")
	public SincronitzacioResposta sincronitzar(
			Long companyiaId,
			List<SincronitzacioEmpresaAmbOperaris> empreses);

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
	@PreAuthorize("hasPermission(#companyiaId, 'es.limit.cecocloud.logic.api.dto.Companyia', 'SYNC')")
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
	@PreAuthorize("hasPermission(#companyiaId, 'es.limit.cecocloud.logic.api.dto.Companyia', 'SYNC')")
	public SincronitzacioResposta marcatgeCreate(
			Long companyiaId,
			List<SincronitzacioMarcatge> marcatges);

}
