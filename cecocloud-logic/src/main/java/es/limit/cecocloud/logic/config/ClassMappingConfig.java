/**
 * 
 */
package es.limit.cecocloud.logic.config;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.Empresa;
import es.limit.cecocloud.logic.api.dto.Marcatge;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.MarcatgeEntity;
import es.limit.cecocloud.persist.entity.OperariEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

/**
 * Configuració del mapeig de classes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ClassMappingConfig implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.getConverterFactory().registerConverter(
				new EntityToDtoConverter<UsuariEntity, Usuari>() {});
		orikaMapperFactory.getConverterFactory().registerConverter(
				new EntityToDtoConverter<CompanyiaEntity, Companyia>() {});
		orikaMapperFactory.getConverterFactory().registerConverter(
				new EntityToDtoConverter<EmpresaEntity, Empresa>() {});
		orikaMapperFactory.getConverterFactory().registerConverter(
				new EntityToDtoConverter<OperariEntity, Operari>() {});
		orikaMapperFactory.getConverterFactory().registerConverter(
				new EntityToDtoConverter<MarcatgeEntity, Marcatge>() {});
	}

	@Slf4j
	public static class EntityToDtoConverter<E extends AbstractEntity<D, ?>, D extends Identificable<?>> extends CustomConverter<E, D> {
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
								AbstractEntity<?, ?> entityFieldValue = null;
								try {
									entityFieldValue = (AbstractEntity<?, ?>)source.getClass().getMethod(getMethodName).invoke(source);
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

}
