/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.exception.PermissionDeniedException;

/**
 * Servei encarregat de gestionar operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OperariService extends GenericService<Operari, Long> {

	/**
	 * Verifica que l'usuari estigui actiu en la data especificada.
	 * 
	 * @param id
	 *            id de l'operari.
	 * @param data
	 *            data per a la verificació.
	 * @return true si l'operari està actiu o false en cas contrari.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'operari especificat.
	 * @throws PermissionDeniedException
	 *             si l'usuari no te permisos per accedir a l'operari.
	 */
	public boolean isOperariActiu(Long id, Date data);

}
