/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.util.IdentificableChild;
import es.limit.cecocloud.logic.api.exception.WrongParentException;
import es.limit.cecocloud.logic.api.service.GenericChildService;
import es.limit.cecocloud.persist.entity.AbstractChildEntity;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.repository.BaseRepository;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació base del servei de gestió d'entitats que depenen
 * d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractGenericChildServiceImpl<D extends IdentificableChild<PID, ID>, P extends AbstractEntity<?, PID>, E extends AbstractChildEntity<P, D, ID>, PID extends Serializable, ID extends Serializable> extends AbstractServiceImpl<D, P, AbstractEntity<?, ?>, E, ID> implements GenericChildService<D, PID, ID> {

	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private BaseRepository<P, PID> parentRepository;

	@Override
	@Transactional
	public D create(
			PID parentId,
			D dto) {
		logger.debug("Creant entitat (" +
				"parentId=" + parentId + ", " +
				"dto=" + dto + ")");
		E entity = buildNewEntity(
				getParentRepository().getOne(parentId),
				null, 
				dto);
		beforeCreate(entity, dto);
		E saved = getRepository().save(entity);
		afterCreate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public D update(
			PID parentId,
			ID id,
			D dto) {
		logger.debug("Modificant entitat (" +
				"parentId=" + parentId + ", " +
				"id=" + id + ", " +
				"dto=" + dto + ")");
		E entity = getEntity(parentId, id);
		beforeUpdate(entity, dto);
		entity.update(dto);
		E saved = getRepository().save(entity);
		afterUpdate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public void delete(
			PID parentId,
			ID id) {
		logger.debug("Esborrant entitat (" +
				"parentId=" + parentId + ", " +
				"id=" + id + ")");
		E entity = getEntity(parentId, id);
		beforeDelete(entity);
		getRepository().delete(entity);
		afterDelete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public D getOne(
			PID parentId,
			ID id) {
		logger.debug("Obtenint entitat (" +
				"parentId=" + parentId + ", " +
				"id=" + id + ")");
		return toDto(getEntity(parentId, id));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<D> findPageByRsqlQuery(
			PID parentId,
			String rsqlQuery,
			Pageable pageable) {
		logger.debug("Consulta d'entitats amb filtre i paginació (" +
				"parentId=" + parentId + ", " +
				"rsqlQuery=" + rsqlQuery + ", " +
				"pageable=" + pageable + ")");
		return findPageByQuickFilterAndRsqlQuery(
				getParentRepository().getOne(parentId),
				null,
				rsqlQuery,
				pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public D findOneByRsqlQuery(
			PID parentId,
			String rsqlQuery) {
		logger.debug("Consulta d'una única entitat amb filtre (" +
				"parentId=" + parentId + ", " +
				"rsqlQuery=" + rsqlQuery + ")");
		Page<D> page = findPageByQuickFilterAndRsqlQuery(
				getParentRepository().getOne(parentId),
				null,
				rsqlQuery,
				PageRequest.of(0, 1));
		if (!page.isEmpty()) {
			if (page.getTotalElements() <= 1) {
				return page.getContent().get(0);
			} else {
				// TODO retornar error per haver trobat + d'un resultat
				return page.getContent().get(0);
			}
		} else {
			return null;
		}
	}

	protected E getEntity(
			PID parentId,
			ID id) {
		E entity = getRepository().getOne(id);
		if (!parentId.equals(entity.getParent().getId())) {
			throw new WrongParentException(
					parentId,
					id,
					getDtoClass());
		}
		return entity;
	}

	protected BaseRepository<P, PID> getParentRepository() {
		return parentRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(AbstractGenericChildServiceImpl.class);

}
