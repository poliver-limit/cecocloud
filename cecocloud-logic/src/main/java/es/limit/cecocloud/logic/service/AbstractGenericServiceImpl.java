/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.service.GenericService;
import es.limit.cecocloud.persist.entity.EmbeddableEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

/**
 * Implementació base del servei de gestió d'entitats que depenen d'un
 * identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractGenericServiceImpl<D extends Identificable<ID>, ID extends Serializable, E extends EmbeddableEntity<D, PK>, PK extends Serializable> extends AbstractServiceImpl<D, ID, E, PK> implements GenericService<D, ID> {

	@Autowired
	protected MapperFacade orikaMapperFacade;

	@Override
	@Transactional
	public D create(D dto) {
		log.debug("Creant entitat (" + "dto=" + dto + ")");
		E entity = buildNewEntity(dto);
		beforeCreate(entity, dto);
		E saved = getRepository().save(entity);
		afterCreate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public D update(ID id, D dto) {
		log.debug("Modificant entitat (" + "id=" + id + ", " + "dto=" + dto + ")");
		E entity = getEntity(id);
		beforeUpdate(entity, dto);
		updateEntity(entity, dto);
		E saved = getRepository().save(entity);
		afterUpdate(entity, dto);
		return toDto(saved);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		log.debug("Esborrant entitat (" + "id=" + id + ")");
		E entity = getEntity(id);
		beforeDelete(entity);
		getRepository().delete(entity);
		afterDelete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public D getOne(ID id) {
		log.debug("Obtenint entitat (" + "id=" + id + ")");
		return toDto(getEntity(id));
	}

	@Override
	@Transactional(readOnly = true)
	public Page<D> findPageByQuickFilterAndRsqlQuery(
			String quickFilter,
			String rsqlQuery,
			Pageable pageable) {
		log.debug("Consulta d'entitats amb filtre i paginació (" +
				"quickFilter=" + quickFilter + ", " +
				"rsqlQuery=" + rsqlQuery + ", " +
				"pageable=" + pageable + ")");
		return super.findPageByQuickFilterAndRsqlQuery(
				quickFilter,
				rsqlQuery,
				pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public D findOneByRsqlQuery(
			String rsqlQuery) {
		log.debug("Consulta d'una única entitat amb filtre (" +
				"rsqlQuery=" + rsqlQuery + ")");
		Page<D> page = findPageByQuickFilterAndRsqlQuery(
				null,
				rsqlQuery,
				PageRequest.of(0, 1));
		if (!page.isEmpty()) {
			if (page.getTotalElements() <= 1) {
				return page.getContent().get(0);
			} else {
				throw new NonUniqueResultException("La consulta \"" + rsqlQuery + "\" ha retornat més d'un resultat");
			}
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected E getEntity(ID id) {
		return getRepository().getOne((PK)getPkFromDtoId(id));
	}

	@SuppressWarnings("unchecked")
	protected List<E> getEntities(ID[] ids) {
		return getRepository().findAllById(
				Arrays.stream(ids).map(id -> (PK)getPkFromDtoId(id)).collect(Collectors.toList()));
	}

}
