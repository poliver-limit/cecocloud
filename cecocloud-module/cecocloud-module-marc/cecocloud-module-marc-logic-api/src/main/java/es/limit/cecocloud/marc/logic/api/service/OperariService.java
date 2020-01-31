/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.marc.logic.api.dto.Operari;

/**
 * Servei encarregat de gestionar operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OperariService extends GenericService<Operari, Long> {

	/**
	 * Verifica que l'operari estigui actiu en la data especificada.
	 * 
	 * @param id
	 *            id de l'operari.
	 * @param data
	 *            data per a la verificació.
	 * @return true si l'operari està actiu o false en cas contrari.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'operari especificat.
	 */
	public boolean isOperariActiu(Long id, Date data) throws EntityNotFoundException;

}
