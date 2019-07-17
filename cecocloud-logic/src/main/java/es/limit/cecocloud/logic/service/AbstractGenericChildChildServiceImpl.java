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

import es.limit.cecocloud.logic.api.dto.util.IdentificableChildChild;
import es.limit.cecocloud.logic.api.exception.WrongParentException;
import es.limit.cecocloud.logic.api.service.GenericChildChildService;
import es.limit.cecocloud.persist.entity.AbstractChildChildEntity;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.repository.BaseRepository;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació base del servei de gestió d'entitats que depenen
 * d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractGenericChildChildServiceImpl<D extends IdentificableChildChild<PID1, PID2, ID>, P1 extends AbstractEntity<?, PID1>, P2 extends AbstractEntity<?, PID2>, E extends AbstractChildChildEntity<P1, P2, D, ID>, PID1 extends Serializable, PID2 extends Serializable, ID extends Serializable> extends AbstractServiceImpl<D, P1, P2, E, ID> implements GenericChildChildService<D, PID1, PID2, ID> {

	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private BaseRepository<P1, PID1> parent1Repository;
	@Autowired
	private BaseRepository<P2, PID2> parent2Repository;

	@Override
	@Transactional
	public D create(
			PID1 parentId1,
			PID2 parentId2,
			D dto) {
		logger.debug("Creant entitat (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"dto=" + dto + ")");
		E entity = buildNewEntity(
				getParent1Repository().getOne(parentId1),
				getParent2Repository().getOne(parentId2),
				dto);
		beforeCreate(entity, dto);
		E saved = getRepository().save(entity);
		afterCreate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public D update(
			PID1 parentId1,
			PID2 parentId2,
			ID id,
			D dto) {
		logger.debug("Modificant entitat (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"id=" + id + ", " +
				"dto=" + dto + ")");
		E entity = getEntity(parentId1, parentId2, id);
		beforeUpdate(entity, dto);
		entity.update(dto);
		E saved = getRepository().save(entity);
		afterUpdate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public void delete(
			PID1 parentId1,
			PID2 parentId2,
			ID id) {
		logger.debug("Esborrant entitat (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"id=" + id + ")");
		E entity = getEntity(parentId1, parentId2, id);
		beforeDelete(entity);
		getRepository().delete(entity);
		afterDelete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public D getOne(
			PID1 parentId1,
			PID2 parentId2,
			ID id) {
		logger.debug("Obtenint entitat (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"id=" + id + ")");
		return toDto(getEntity(parentId1, parentId2, id));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<D> findPageByRsqlQuery(
			PID1 parentId1,
			PID2 parentId2,
			String rsqlQuery,
			Pageable pageable) {
		logger.debug("Consulta d'entitats amb filtre i paginació (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"rsqlQuery=" + rsqlQuery + ", " +
				"pageable=" + pageable + ")");
		return findPageByRsqlQuery(
				getParent1Repository().getOne(parentId1),
				rsqlQuery,
				pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public D findOneByRsqlQuery(
			PID1 parentId1,
			PID2 parentId2,
			String rsqlQuery) {
		logger.debug("Consulta d'una única entitat amb filtre (" +
				"parentId1=" + parentId1 + ", " +
				"parentId2=" + parentId2 + ", " +
				"rsqlQuery=" + rsqlQuery + ")");
		Page<D> page = findPageByRsqlQuery(
				getParent1Repository().getOne(parentId1),
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
			PID1 parentId1,
			PID2 parentId2,
			ID id) {
		E entity = getRepository().getOne(id);
		if (!parentId1.equals(entity.getParent1().getId()) || !parentId2.equals(entity.getParent2().getId())) {
			throw new WrongParentException(
					parentId1 + "," + parentId2,
					id,
					getDtoClass());
		}
		return entity;
	}

	protected BaseRepository<P1, PID1> getParent1Repository() {
		return parent1Repository;
	}

	protected BaseRepository<P2, PID2> getParent2Repository() {
		return parent2Repository;
	}

	private static final Logger logger = LoggerFactory.getLogger(AbstractGenericChildChildServiceImpl.class);

}
