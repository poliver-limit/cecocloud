/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.service;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaRangHorari;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaRangHorariRequest;

/**
 * Servei per a la gestió de punts de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PuntVendaService extends GenericCompositePkService<PuntVenda> {

	/**
	 * Consulta de rang horari entre dues dates.
	 * 
	 * @param id
	 *            identificació del punt de venda.
	 * @param request
	 *            paràmetres de la consulta.
	 * @return el rang horari.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public PuntVendaRangHorari getRangHorari(
			String id,
			PuntVendaRangHorariRequest request) throws EntityNotFoundException;

}
