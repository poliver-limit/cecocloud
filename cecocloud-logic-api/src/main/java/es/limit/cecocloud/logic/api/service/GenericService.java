/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.base.boot.logic.api.exception.PermissionDeniedException;

/**
 * Servei genèric per a gestionar una entitat del model de dades.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface GenericService<D extends Identificable<ID>, ID extends Serializable> {

	public final static String DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * Crea una nova entitat.
	 * 
	 * @param dto
	 *            informació de l'entitat.
	 * @return l'entitat creada.
	 */
	public D create(
			D dto) throws PermissionDeniedException;

	/**
	 * Actualitza la informació d'una entitat.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @param dto
	 *            informació de l'entitat.
	 * @return l'entitat modificada.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public D update(
			ID id,
			D dto) throws EntityNotFoundException;

	/**
	 * Esborra una entitat donat el seu identificador.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public void delete(
			ID id) throws EntityNotFoundException;

	/**
	 * Consulta una entitat donada la seva identificació.
	 * 
	 * @param id
	 *            identificació de l'entitat.
	 * @return l'entitat amb la identificació especificada.
	 * @throws EntityNotFoundException
	 *             si no s'ha trobat l'entitat especificada.
	 */
	public D getOne(
			ID id) throws EntityNotFoundException;

	/**
	 * Consulta paginada d'entitats amb filtre i consulta en format RSQL.
	 * 
	 * @param quickFilter
	 *            Filtre ràpid en format text.
	 * @param rsqlQuery
	 *            consulta en format RSQL.
	 * @param pageable
	 *            paràmetres per a paginar i ordenar el llistat.
	 * @return la llista d'entitats.
	 */
	public Page<D> findPageByQuickFilterAndRsqlQuery(
			String quickFilter,
			String rsqlQuery,
			Pageable pageable);
	
	/**
	 * Consulta sense paginar d'entitats amb filtre i consulta en format RSQL.
	 * 
	 * @param quickFilter
	 *            Filtre ràpid en format text.
	 * @param rsqlQuery
	 *            consulta en format RSQL.
	 * @return la llista d'entitats.
	 */
	public List<D> findListByQuickFilterAndRsqlQuery(
			String quickFilter,
			String rsqlQuery);


	/**
	 * Consulta d'una única entitat amb consulta en format RSQL.
	 * 
	 * @param rsqlQuery
	 *            consulta en format RSQL.
	 * @return l'entitat trobada o null.
	 */
	public D findOneByRsqlQuery(
			String rsqlQuery);

}
