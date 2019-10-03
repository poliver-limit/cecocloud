/**
 * 
 */
package es.limit.cecocloud.logic.config;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import es.limit.cecocloud.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.persist.entity.EmbeddableEntity;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

/**
 * Configuració del mapeig de classes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@Component
public class ClassMappingConfig implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		Reflections reflections = new Reflections(EmbeddableEntity.class.getPackage().getName());
		@SuppressWarnings("rawtypes")
		Set<Class<? extends EmbeddableEntity>> entityClasses = reflections.getSubTypesOf(EmbeddableEntity.class);
		entityClasses.removeIf(apiControllerClass -> (apiControllerClass.isInterface() || Modifier.isAbstract(apiControllerClass.getModifiers())));
		for (@SuppressWarnings("rawtypes") Class<? extends EmbeddableEntity> entityClass: entityClasses) {
			ParameterizedType parameterizedType = (ParameterizedType)entityClass.getGenericSuperclass();
			orikaMapperFactory.getConverterFactory().registerConverter(
					getEntityToDtoConverter(entityClass, (Class<?>)parameterizedType.getActualTypeArguments()[0]));
		}
	}

	private CustomConverter<?, ?> getEntityToDtoConverter(
			Class<?> entityClass,
			Class<?> dtoClass) {
		Reflections reflections = new Reflections(AbstractEntityToDtoConverter.class.getPackage().getName());
		@SuppressWarnings("rawtypes")
		Set<Class<? extends CustomConverter>> converterClasses = reflections.getSubTypesOf(CustomConverter.class);
		converterClasses.removeIf(apiControllerClass -> (apiControllerClass.isInterface() || Modifier.isAbstract(apiControllerClass.getModifiers())));
		for (@SuppressWarnings("rawtypes") Class<? extends CustomConverter> converterClass: converterClasses) {
			ParameterizedType parameterizedType = (ParameterizedType)converterClass.getGenericSuperclass();
			Class<?> converterEntityClass = (Class<?>)(parameterizedType.getActualTypeArguments()[0]);
			Class<?> converterDtoClass = (Class<?>)(parameterizedType.getActualTypeArguments()[1]);
			if (converterEntityClass.equals(entityClass) && converterDtoClass.equals(dtoClass)) {
				try {
					log.info("Configurant converter entre les entitats de tipus " + entityClass + " i els DTOs de tipus " + dtoClass);
					return converterClass.newInstance();
				} catch (InstantiationException | IllegalAccessException ex) {
					throw new RuntimeException("No s'ha pogut crear la instància del conversor " + converterClass, ex);
				}
			}
		}
		throw new RuntimeException("No s'ha trobat cap EntityToDtoConverter per a les entitats de tipus " + entityClass + " i el DTOs de tipus " + dtoClass);
	}

}
