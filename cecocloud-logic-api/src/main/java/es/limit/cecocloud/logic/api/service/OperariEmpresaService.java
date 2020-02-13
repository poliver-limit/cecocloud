/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;

/**
 * Servei encarregat de gestionar relacions operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface OperariEmpresaService extends GenericService<OperariEmpresa, Long> {

	/**
	 * Retorna l'operari-empresa per a l'usuari i sessió actuals.
	 * 
	 * @return l'operari-empresa per a l'usuari i sessió actuals.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat cap operari-empresa.
	 */
	public OperariEmpresa findByCurrentUserAndSession() throws NoSuchElementException;

}
