/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.service;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;

/**
 * Servei encarregat de gestionar marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MarcatgeService extends GenericService<Marcatge, Long> {

	/**
	 * Retorna el darrer marcatge de l'operari.
	 * 
	 * @param operariId
	 *            id de l'operari.
	 * @return el darrer marcatge o null si l'operari no ha fet cap marcatge.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'operari especificat.
	 */
	public Marcatge findDarrerMarcatgePerOperariEmpresa(Long operariEmpresaId) throws EntityNotFoundException;

}
