/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.io.Serializable;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.limit.cecocloud.logic.api.dto.util.IdentificableChildChild;
import es.limit.cecocloud.logic.api.exception.PermissionDeniedException;

/**
 * Servei genèric per a gestionar una entitat del model de dades amb pare.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GenericChildChildService<D extends IdentificableChildChild<PID1, PID2, ID>, PID1 extends Serializable, PID2 extends Serializable, ID extends Serializable> {

	/**
	 * Crea una nova entitat.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param dto
	 *            informació de l'entitat.
	 * @return l'entitat creada.
	 * @throws PermissionDeniedException
	 *             si l'usuari no te permisos per realitzar aquesta acció.
	 */
	public D create(
			PID1 parentId1,
			PID2 parentId2,
			D dto) throws PermissionDeniedException;

	/**
	 * Actualitza la informació d'una entitat.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param id
	 *            identificació de l'entitat.
	 * @param dto
	 *            informació de l'entitat.
	 * @return l'entitat modificada.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 * @throws PermissionDeniedException
	 *             si l'usuari no te permisos per realitzar aquesta acció.
	 */
	public D update(
			PID1 parentId1,
			PID2 parentId2,
			ID id,
			D dto) throws EntityNotFoundException, PermissionDeniedException;

	/**
	 * Esborra l'entitat donada la seva identificació.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param id
	 *            identificació de l'entitat.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 * @throws PermissionDeniedException
	 *             si l'usuari no te permisos per realitzar aquesta acció.
	 */
	public void delete(
			PID1 parentId1,
			PID2 parentId2,
			ID id) throws EntityNotFoundException, PermissionDeniedException;

	/**
	 * Consulta una entitat donada la seva identificació.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param id
	 *            identificació de l'entitat.
	 * @return l'entitat amb la identificació especificada.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public D getOne(
			PID1 parentId1,
			PID2 parentId2,
			ID id) throws EntityNotFoundException;

	/**
	 * Consulta paginada d'entitats amb consulta en format RSQL.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param rsqlQuery
	 *            consulta en format RSQL.
	 * @param pageable
	 *            paràmetres per a paginar i ordenar el llistat.
	 * @return la llista d'entitats.
	 */
	public Page<D> findPageByRsqlQuery(
			PID1 parentId1,
			PID2 parentId2,
			String rsqlQuery,
			Pageable pageable);

	/**
	 * Consulta d'una única entitat amb consulta en format RSQL.
	 * 
	 * @param parentId1
	 *            identificació de l'entitat pare 1.
	 * @param parentId2
	 *            identificació de l'entitat pare 2.
	 * @param rsqlQuery
	 *            consulta en format RSQL.
	 * @return l'entitat trobada o null.
	 */
	public D findOneByRsqlQuery(
			PID1 parentId1,
			PID2 parentId2,
			String rsqlQuery);

}
