/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import es.limit.cecocloud.logic.api.dto.Permission;
import es.limit.cecocloud.logic.api.dto.util.Identificable;

/**
 * Servei genèric per a gestionar una entitat del model de dades amb permisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GenericServiceWithPermissions<D extends Identificable<ID>, ID extends Serializable> extends GenericService<D, ID> {

	/**
	 * Crea un permís de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permission
	 *            informació del permís a crear.
	 * @return el permís creat.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public Permission permissionCreate(
			ID id,
			Permission permission) throws EntityNotFoundException;

	/**
	 * Modifica un permís de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permissionId
	 *            identificació del permís.
	 * @param permission
	 *            informació del permís a modificar.
	 * @return el permís modificat.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat o el permís especificat.
	 */
	public Permission permissionUpdate(
			ID id,
			String permissionId,
			Permission permission) throws EntityNotFoundException;

	/**
	 * Esborra un permís de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permissionId
	 *            identificació del permís.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat o el permís especificat.
	 */
	public void permissionDelete(
			ID id,
			String permissionId) throws EntityNotFoundException;

	/**
	 * Consulta un permís de l'entitat donada la seva identificació.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permissionId
	 *            identificació del permís.
	 * @return el permís de l'entitat amb la identificació especificada.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat o el permís especificat.
	 */
	public Permission permissionGetOne(
			ID id,
			String permissionId) throws EntityNotFoundException;

	/**
	 * Consulta la llista de permisos de l'entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @return la llista de permisos.
	 */
	public List<Permission> permissionFind(ID id);

	/**
	 * Verifica l'usuari actual te permís a damunt l'entitat especificada.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param permission
	 *            permís a verificar.
	 * @return true si l'usuari te permís o false en cas contrari.
	 */
	public boolean permissionCheck(
			ID id,
			org.springframework.security.acls.model.Permission permission);

}
