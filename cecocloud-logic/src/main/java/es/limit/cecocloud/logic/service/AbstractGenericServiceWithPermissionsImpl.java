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
import es.limit.cecocloud.logic.api.service.GenericServiceWithPermissions;
import es.limit.cecocloud.logic.helper.PermissionHelper;
import es.limit.cecocloud.persist.entity.EmbeddableEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementació base del servei de gestió d'entitats que depenen d'un
 * identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractGenericServiceWithPermissionsImpl<D extends Identificable<ID>, ID extends Serializable, E extends EmbeddableEntity<D, PK>, PK extends Serializable> extends AbstractGenericServiceImpl<D, ID, E, PK> implements GenericServiceWithPermissions<D, ID> {

	@Autowired
	private PermissionHelper permissionHelper;

	@Override
	@Transactional
	public Permission permissionCreate(
			ID id,
			Permission permission) throws EntityNotFoundException {
		log.debug("Creant permís de l'entitat (" +
			"id=" + id + ", " +
			"permission=" + permission + ")");
		getEntity(id);
		return permissionHelper.update(
				getDtoClass(),
				id,
				null,
				permission);
	}

	@Override
	@Transactional
	public Permission permissionUpdate(
			ID id,
			String permissionId,
			Permission permission)
			throws EntityNotFoundException {
		log.debug("Modificant permís de l'entitat (" +
				"id=" + id + ", " +
				"permissionId=" + permissionId + ", " +
				"permission=" + permission + ")");
		getEntity(id);
		return permissionHelper.update(
				getDtoClass(),
				id,
				permissionId,
				permission);
	}

	@Override
	@Transactional
	public void permissionDelete(
			ID id,
			String permissionId) throws EntityNotFoundException {
		log.debug("Esborrant permís de l'entitat (" +
				"id=" + id + ", " +
				"permissionId=" + permissionId + ")");
		getEntity(id);
		permissionHelper.delete(
				getDtoClass(),
				id,
				permissionId);
	}

	@Override
	@Transactional(readOnly = true)
	public Permission permissionGetOne(
			ID id,
			String permissionId) throws EntityNotFoundException {
		log.debug("Obtenint permís de l'entitat (" +
				"id=" + id + ", " +
				"permissionId=" + permissionId + ")");
		getEntity(id);
		return permissionHelper.getOne(
				getDtoClass(),
				id,
				permissionId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permission> permissionFind(ID id) {
		log.debug("Consulta de permisos de l'entitat (id=" + id + ")");
		getEntity(id);
		return permissionHelper.find(
				getDtoClass(),
				id);
	}

	@Override
	public boolean permissionCheck(
			ID id,
			org.springframework.security.acls.model.Permission permission) {
		log.debug("Verificació de permís (" +
				"id=" + id + ", " +
				"permission=" + permission + ")");
		return permissionHelper.checkPermissionForCurrentUser(
				getDtoClass(),
				id,
				permission);
	}

}
