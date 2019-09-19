/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.Permission;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.exception.PermissionDeniedException;
import es.limit.cecocloud.logic.api.service.GenericServiceWithPermissions;
import es.limit.cecocloud.logic.helper.PermissionHelper;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació base del servei de gestió d'entitats que depenen d'un
 * identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractGenericServiceWithPermissionsImpl<D extends Identificable<ID>, E extends AbstractEntity<D, ID>, ID extends Serializable> extends AbstractGenericServiceImpl<D, E, ID> implements GenericServiceWithPermissions<D, ID> {

	@Autowired
	private PermissionHelper permissionHelper;

	@Override
	@Transactional
	public Permission permissionUpdate(
			ID id,
			Permission permission)
			throws EntityNotFoundException, PermissionDeniedException {
		log.debug("Modificant permisos de l'entitat (" + "id=" + id + ", " + "permission=" + permission + ")");
		getEntity(id);
		permissionHelper.update(
				getDtoClass(),
				id,
				permission);
		return permission;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permission> permissionFind(ID id) {
		log.debug("Consulta de permisos de l'entitat (" + "id=" + id + ")");
		getEntity(id);
		return permissionHelper.find(
				getDtoClass(),
				id);
	}

}
