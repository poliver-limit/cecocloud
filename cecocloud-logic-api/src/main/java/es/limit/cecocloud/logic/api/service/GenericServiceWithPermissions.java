/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import es.limit.cecocloud.logic.api.dto.Permission;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.exception.PermissionDeniedException;

/**
 * Servei genèric per a gestionar una entitat del model de dades amb permisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GenericServiceWithPermissions<D extends Identificable<ID>, ID extends Serializable> extends GenericService<D, ID> {

	/**
	 * Actualitza un permís de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permission
	 *            informació del permís a actualitzar.
	 * @return el permís modificat.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 * @throws PermissionDeniedException
	 *             si l'usuari no te permisos per realitzar aquesta acció.
	 */
	public Permission permissionUpdate(
			ID id,
			Permission permission) throws EntityNotFoundException, PermissionDeniedException;

	/**
	 * Consulta la llista de permisos de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @return la llista de permisos.
	 */
	public List<Permission> permissionFind(ID id);

}
