/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.service;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.cita.logic.api.dto.Cita;

/**
 * Servei per a la gestió de cites.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CitaService extends GenericCompositePkService<Cita> {

	/**
	 * Consulta si una hora està disponible.
	 * 
	 * @param puntVendaId
	 *            identificació del punt de venda.
	 * @param data
	 *            L'hora que es vol comprovar.
	 * @return true si està disponible o false en cas contrari.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat el punt de venda.
	 */
	public boolean isHoraDisponible(
			String puntVendaId,
			LocalDateTime data) throws EntityNotFoundException;

}
