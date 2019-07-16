/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.GenericService;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació base del servei de gestió d'entitats que depenen d'un
 * identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractGenericServiceImpl<D extends Identificable<ID>, E extends AbstractEntity<D, ID>, ID extends Serializable> extends AbstractServiceImpl<D, AbstractEntity<?, ?>, E, ID> implements GenericService<D, ID> {

	@Autowired
	protected MapperFacade orikaMapperFacade;

	@Override
	@Transactional
	public D create(D dto) {
		logger.debug("Creant entitat (" + "dto=" + dto + ")");
		E entity = buildNewEntity(null, dto);
		beforeCreate(entity, dto);
		E saved = getRepository().save(entity);
		afterCreate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public D update(ID id, D dto) {
		logger.debug("Modificant entitat (" + "id=" + id + ", " + "dto=" + dto + ")");
		E entity = getEntity(id);
		beforeUpdate(entity, dto);
		entity.update(dto);
		E saved = getRepository().save(entity);
		afterUpdate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		logger.debug("Esborrant entitat (" + "id=" + id + ")");
		E entity = getEntity(id);
		beforeDelete(entity);
		getRepository().delete(entity);
		afterDelete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public D getOne(ID id) {
		logger.debug("Obtenint entitat (" + "id=" + id + ")");
		return toDto(getEntity(id));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<D> findPageByRsqlQuery(
			String rsqlQuery,
			Pageable pageable) {
		logger.debug("Consulta d'entitats amb filtre i paginació (" +
				"rsqlQuery=" + rsqlQuery + ", " +
				"pageable=" + pageable + ")");
		return findPageByRsqlQuery(
				null,
				rsqlQuery,
				pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public D findOneByRsqlQuery(
			String rsqlQuery) {
		logger.debug("Consulta d'una única entitat amb filtre (" +
				"rsqlQuery=" + rsqlQuery + ")");
		Page<D> page = findPageByRsqlQuery(
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

	protected E getEntity(ID id) {
		return getRepository().getOne(id);
	}

	protected List<E> getEntities(ID[] ids) {
		return getRepository().findAllById(Arrays.asList(ids));
	}

	private static final Logger logger = LoggerFactory.getLogger(AbstractGenericServiceImpl.class);

}
