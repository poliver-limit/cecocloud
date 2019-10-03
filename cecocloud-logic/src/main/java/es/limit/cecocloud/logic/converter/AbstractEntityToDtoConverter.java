/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.persist.entity.EmbeddableEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

/**
 * Classe abstracta per a la conversió de tipus entre entitats i DTOs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractEntityToDtoConverter<E extends EmbeddableEntity<D, ?>, D extends Identificable<?>> extends CustomConverter<E, D> {

	@Override
	public D convert(E source, Type<? extends D> destinationType, MappingContext mappingContext) {
		D dto = mapperFacade.map(
				source.getEmbedded(),
				destinationType.getRawType());
		mapperFacade.map(
				source,
				dto);
		for (Field dtoField: destinationType.getRawType().getDeclaredFields()) {
			boolean isReference = dtoField.getType().isAssignableFrom(GenericReference.class);
			if (isReference) {
				String getMethodName = "get" + dtoField.getName().substring(0, 1).toUpperCase() + dtoField.getName().substring(1);
				GenericReference<?, ?> genericReference = null;
				try {
					genericReference = (GenericReference<?, ?>)(destinationType.getRawType().getMethod(getMethodName).invoke(dto));
				} catch (Exception ex) {
					log.error("Error al obtenir la referencia " + dtoField.getName() + " del DTO " + dto, ex);
				}
				if (genericReference != null) {
					Class<?> fieldResourceType = (Class<?>)((ParameterizedType)dtoField.getGenericType()).getActualTypeArguments()[0];
					RestapiResource resourceAnnotation = fieldResourceType.getAnnotation(RestapiResource.class);
					if (resourceAnnotation != null && !resourceAnnotation.descriptionField().isEmpty()) {
						String descriptionField = resourceAnnotation.descriptionField();
						try {
							EmbeddableEntity<?, ?> entityFieldValue = null;
							try {
								entityFieldValue = (EmbeddableEntity<?, ?>)source.getClass().getMethod(getMethodName).invoke(source);
								String descriptionGetMethodName = "get" + descriptionField.substring(0, 1).toUpperCase() + descriptionField.substring(1);
								try {
									genericReference.setDescription(
											(String)fieldResourceType.getMethod(descriptionGetMethodName).invoke(entityFieldValue.getEmbedded()));
								} catch (Exception ex) {
									log.error("Error al obtenir el camp " + descriptionGetMethodName + " del l'entitat " + entityFieldValue, ex);
								}
							} catch (Exception ex) {
								log.error("Error al obtenir el camp " + getMethodName + " del l'entitat " + source, ex);
							}
						} catch (Exception ex) {
							log.error("Error al obtenir la descripció del camp " + descriptionField + " de la referència " + source, ex);
						}
					} else {
						String resourceName = dtoField.getType().getSimpleName().substring(0, 1).toLowerCase() + dtoField.getType().getSimpleName().substring(1);
						genericReference.setDescription(resourceName + "_" + genericReference.getId());
					}
				}
			}
		}
		return dto;
	}

}