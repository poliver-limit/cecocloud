/**
 * 
 */
package es.limit.cecocloud.back.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.dto.util.Identificable;

/**
 * Mètodes bàsics per als controladors REST de l'API que retornen
 * informació del profile.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
public abstract class AbstractProfileController {

	@SuppressWarnings("unchecked")
	protected Class<? extends Identificable<?>> getDtoClassFromApiController(Class<?> apiControllerClass) {
		Type genericSuperClass = apiControllerClass.getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
	}

	protected String getResourceNameFromClass(Class<?> clazz) {
		String simpleName = clazz.getSimpleName();
		return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
	}

}
