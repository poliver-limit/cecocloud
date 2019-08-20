/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import es.limit.cecocloud.logic.api.annotations.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

/**
 * Conversor de entitats a DTOs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public class DtoConverter<D extends Identificable<ID>, E extends AbstractEntity<D, ID>, ID extends Serializable> {

	private Class<D> dtoClass;
	private Class<E> entityClass;
	private MapperFacade orikaMapperFacade;

	public DtoConverter(
			Class<D> dtoClass,
			Class<E> entityClass,
			MapperFacade orikaMapperFacade) {
		super();
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
		this.orikaMapperFacade = orikaMapperFacade;
	}

	protected D toDto(E entity) {
		removeGenericReferences(entity.getEmbedded());
		D dto = orikaMapperFacade.map(
				entity.getEmbedded(),
				getDtoClass());
		orikaMapperFacade.map(
				entity,
				dto);
		addGenericReferences(entity, dto);
		addGenericReferences(entity, entity.getEmbedded());
		return dto;
	}

	protected List<D> toDto(List<E> entities) {
		if (entities != null) {
			List<D> embeddedEntities = entities.stream().map(entity -> entity.getEmbedded()).collect(Collectors.toList());
			embeddedEntities.stream().forEach(this::removeGenericReferences);
			List<D> dtos = orikaMapperFacade.mapAsList(
					embeddedEntities,
					getDtoClass());
			for (int i = 0; i < entities.size(); i++) {
				orikaMapperFacade.map(
						entities.get(i),
						dtos.get(i));
			}
			for (int i = 0; i < dtos.size(); i++) {
				addGenericReferences(entities.get(i), dtos.get(i));
				addGenericReferences(entities.get(i), entities.get(i).getEmbedded());
			}
			return dtos;
		} else {
			return null;
		}
	}

	protected Page<D> toDto(Page<E> entityPage, Pageable pageable) {
		Page<D> page = new PageImpl<D>(
				toDto(entityPage.getContent()),
				pageable,
				entityPage.getTotalElements());
		return page;
	}

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
		Class<D> dtoClass = getDtoClass();
		Class<E> entityClass = getEntityClass();
		for (Field dtoField: dtoClass.getDeclaredFields()) {
			boolean isGenericField = dtoField.getType().isAssignableFrom(GenericReference.class) || Identificable.class.isAssignableFrom(dtoField.getType());
			if (isGenericField) {
				for (Field entityField: entityClass.getDeclaredFields()) {
					if (entityField.getName().equals(dtoField.getName())) {
						String getMethodName = "get" + entityField.getName().substring(0, 1).toUpperCase() + entityField.getName().substring(1);
						AbstractEntity<?, ?> referencedEntity = null;
						try {
							referencedEntity = (AbstractEntity<?, ?>)(entityClass.getMethod(getMethodName).invoke(entity));
						} catch (Exception ex) {
							log.error("Error al obtenir la referencia " + entityField.getName() + " de l'entitat " + entity, ex);
						}
						if (referencedEntity != null) {
							String setMethodName = "set" + entityField.getName().substring(0, 1).toUpperCase() + entityField.getName().substring(1);
							if (dtoField.getType().isAssignableFrom(GenericReference.class)) {
								@SuppressWarnings("rawtypes")
								GenericReference reference = GenericReference.toGenericReference(referencedEntity.getId());
								ParameterizedType parameterizedType = (ParameterizedType)dtoField.getGenericType();
								Class<? extends Identificable<?>> referencedResourceClass = (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
								RestapiResource resourceAnnotation = referencedResourceClass.getAnnotation(RestapiResource.class);
								String descriptionField = null;
								if (resourceAnnotation != null && !resourceAnnotation.descriptionField().isEmpty()) {
									descriptionField = resourceAnnotation.descriptionField();
								}
								if (descriptionField != null) {
									try {
										String referenceGetMethodName = "get" + descriptionField.substring(0, 1).toUpperCase() + descriptionField.substring(1);
										String description = (String)referencedEntity.getEmbedded().getClass().getMethod(referenceGetMethodName).invoke(
												referencedEntity.getEmbedded());
										reference.setDescription(description);
									} catch (Exception ex) {
										log.error("Error al obtenir la descripció del camp " + descriptionField + " de la referència " + referencedEntity, ex);
									}
								}
								try {
									dtoClass.getMethod(setMethodName, GenericReference.class).invoke(dto, reference);
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
									dtoClass.getMethod(setMethodName, dtoField.getType()).invoke(dto, reference);
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

	private Class<D> getDtoClass() {
		return dtoClass;
	}
	private Class<E> getEntityClass() {
		return entityClass;
	}

}
