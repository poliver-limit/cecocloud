/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

/**
 * Mètodes comuns pels serveis genèrics.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractDtoConverter<D extends Identificable<ID>, E extends AbstractEntity<D, ID>, ID extends Serializable> {

	@Autowired
	protected MapperFacade orikaMapperFacade;

	protected D toDto(E entity) {
		removeGenericReferences(entity.getEmbedded());
		mapEntityPropertiesToEmbeddedProperties(entity);
		D dto = orikaMapperFacade.map(
				entity.getEmbedded(),
				getDtoClass());
		dto.setId(entity.getId());
		addGenericReferences(entity, dto);
		addGenericReferences(entity, entity.getEmbedded());
		return dto;
	}

	protected List<D> toDto(List<E> entities) {
		if (entities != null) {
			List<D> embeddedEntities = entities.stream().map(entity -> entity.getEmbedded()).collect(Collectors.toList());
			embeddedEntities.stream().forEach(this::removeGenericReferences);
			entities.stream().forEach(this::mapEntityPropertiesToEmbeddedProperties);
			List<D> dtos = orikaMapperFacade.mapAsList(
					embeddedEntities,
					getDtoClass());
			for (int i = 0; i < dtos.size(); i++) {
				addGenericReferences(entities.get(i), dtos.get(i));
				addGenericReferences(entities.get(i), entities.get(i).getEmbedded());
				dtos.get(i).setId(entities.get(i).getId());
			}
			return dtos;
		} else {
			return null;
		}
	}

	protected Page<D> toPaginaDto(Page<E> entityPage, Pageable pageable) {
		Page<D> page = new PageImpl<D>(
				toDto(entityPage.getContent()),
				pageable,
				entityPage.getTotalElements());
		return page;
	}

	protected abstract Class<D> getDtoClass();
	protected abstract Class<E> getEntityClass();

	private void removeGenericReferences(D dto) {
		for (Field field: getDtoClass().getDeclaredFields()) {
			if (field.getType().isAssignableFrom(GenericReference.class)) {
				try {
					field.setAccessible(true);
					field.set(dto, null);
				} catch (IllegalAccessException ignored) {
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void addGenericReferences(E entity, D dto) {
		for (Field dtoField: getDtoClass().getDeclaredFields()) {
			boolean isGenericField = dtoField.getType().isAssignableFrom(GenericReference.class) || Identificable.class.isAssignableFrom(dtoField.getType());
			if (isGenericField) {
				for (Field entityField: getEntityClass().getDeclaredFields()) {
					if (entityField.getName().equals(dtoField.getName())) {
						String getMethodName = "get" + entityField.getName().substring(0, 1).toUpperCase() + entityField.getName().substring(1);
						AbstractEntity<?, ?> referencedEntity = null;
						try {
							referencedEntity = (AbstractEntity<?, ?>)(getEntityClass().getMethod(getMethodName).invoke(entity));
						} catch (Exception ex) {
							log.error("Error al obtenir la referencia " + entityField.getName() + " de l'entitat " + entity, ex);
						}
						if (referencedEntity != null) {
							String setMethodName = "set" + entityField.getName().substring(0, 1).toUpperCase() + entityField.getName().substring(1);
							if (dtoField.getType().isAssignableFrom(GenericReference.class)) {
								@SuppressWarnings("rawtypes")
								GenericReference reference = new GenericReference(referencedEntity.getId(), null);
								try {
									getDtoClass().getMethod(setMethodName, GenericReference.class).invoke(dto, reference);
								} catch (Exception ex) {
									log.error("Error al modificar el camp al dto (" +
											"fieldName=" + entityField.getName() + ", " +
											"value=" + reference + ", " +
											"dto=" + dto + ")", ex);
								}
							} else if (Identificable.class.isAssignableFrom(dtoField.getType())) {
								@SuppressWarnings("rawtypes")
								Identificable reference = (Identificable)orikaMapperFacade.map(
										entity.getEmbedded(),
										dtoField.getType());
								reference.setId(referencedEntity.getId());
								try {
									getDtoClass().getMethod(setMethodName, dtoField.getType()).invoke(dto, reference);
								} catch (Exception ex) {
									log.error("Error al modificar el camp al dto (" +
											"fieldName=" + entityField.getName() + ", " +
											"value=" + reference + ", " +
											"dto=" + dto + ")", ex);
								}
							}
						}
					}
				}
			}
		}
	}

	private void mapEntityPropertiesToEmbeddedProperties(E entity) {
		orikaMapperFacade.map(
				entity,
				entity.getEmbedded());
	}

}
