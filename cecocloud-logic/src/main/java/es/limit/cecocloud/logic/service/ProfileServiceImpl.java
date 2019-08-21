/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.reflections.Reflections;
import org.springframework.hateoas.alps.Alps;
import org.springframework.hateoas.alps.Descriptor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.logic.api.annotations.RestapiField;
import es.limit.cecocloud.logic.api.annotations.RestapiGrid;
import es.limit.cecocloud.logic.api.annotations.RestapiResource;
import es.limit.cecocloud.logic.api.dto.Profile;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.ProfileResourceGrid;
import es.limit.cecocloud.logic.api.dto.ProfileResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.service.ProfileService;

/**
 * Implementació del servei per a obtenir perfil d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	private static final String CONTROLLER_PACKAGE = "com.josepgaya.temprj.back.controller";
	private static final String TRANSLATE_KEY_PREFIX = "resource.";

	@Override
	public Profile getProfile(
			String resourceName,
			String profileHref) {
		try {
			ProfileResource resource = new ProfileResource();
			Class<?> dtoClass = getDtoClassForName(resourceName);
			resource.setName(getResourceNameFromDtoClass(dtoClass));
			Class<?> controllerClass = getControllerClassForDto(dtoClass);
			if (controllerClass != null) {
				resource.setApiUrl(
						getApiUrl(
								dtoClass,
								controllerClass));
			}
			resource.setTranslateKey(
					TRANSLATE_KEY_PREFIX + resource.getName());
			resource.setTranslateKeyPlural(
					TRANSLATE_KEY_PREFIX + resource.getName() + ".plural");
			resource.setFields(getFields(dtoClass));
			resource.setQuickFilterAvailable(isQuickFilterAvailable(dtoClass));
			RestapiResource resourceAnnotation = dtoClass.getAnnotation(RestapiResource.class);
			if (resourceAnnotation != null) {
				if (!resourceAnnotation.descriptionField().isEmpty()) {
					resource.setDescriptionField(resourceAnnotation.descriptionField());
				}
				if (resourceAnnotation.grids().length > 0) {
					List<ProfileResourceGrid> grids = new ArrayList<ProfileResourceGrid>();
					for (RestapiGrid grid: resourceAnnotation.grids()) {
						ProfileResourceGrid gridConfig = new ProfileResourceGrid();
						gridConfig.setResourceName(grid.value());
						if (!grid.name().isEmpty()) {
							gridConfig.setName(grid.name());
						} else {
							gridConfig.setName(grid.value());
						}
						gridConfig.setTranslateKey(
								TRANSLATE_KEY_PREFIX + resource.getName() + ".grid." + grid.value());
						grids.add(gridConfig);
					}
					resource.setGrids(grids);
				}
			}
			Profile profile = new Profile();
			List<Descriptor> fieldDescriptors = new ArrayList<Descriptor>();
			for (ProfileResourceField resourceField: resource.getFields()) {
				fieldDescriptors.add(
						Alps.descriptor().
						name(resourceField.getName()).
						type(org.springframework.hateoas.alps.Type.SEMANTIC).
						build());
			}
			List<Descriptor> descriptors = new ArrayList<Descriptor>();
			descriptors.add(
					Alps.descriptor().
					id(resource.getName() + "-representation").
					href(profileHref).
					descriptors(fieldDescriptors).
					build());
			Alps alps = Alps.alps().descriptors(descriptors).build();
			profile.setAlps(alps);
			profile.setResource(resource);
			return profile;
		} catch (ClassNotFoundException ex) {
			throw new EntityNotFoundException();
		}
	}

	private Class<?> getDtoClassForName(
			String resourceClassName) throws ClassNotFoundException {
		Class<?> dtoClass = null;
		for (String packageToScan: new String [] {Profile.class.getPackage().getName()}) {
			dtoClass = getClassForName(packageToScan + "." + StringUtils.capitalize(resourceClassName));
			if (dtoClass == null) {
				dtoClass = getClassForName(packageToScan + "." + resourceClassName);
			}
			if (dtoClass != null) {
				break;
			}
		}
		if (dtoClass != null) {
			return dtoClass;
		} else {
			throw new ClassNotFoundException("Classe pel recurs " + resourceClassName + " no trobada");
		}
	}

	private Class<?> getClassForName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException ignored) {
			return null;
		}
	}

	private Class<?> getControllerClassForDto(
			Class<?> dtoClass) throws ClassNotFoundException {
		Class<?> controllerClass = null;
		for (String packageToScan:  new String [] {CONTROLLER_PACKAGE}) {
			Reflections reflections = new Reflections(packageToScan);
			Set<Class<?>> candidats = reflections.getTypesAnnotatedWith(RestController.class);
			for (Class<? extends Object> candidat: candidats) {
				Type t = candidat.getGenericSuperclass();
				if (t != null && t instanceof ParameterizedType) {
					ParameterizedType parameterizedType = (ParameterizedType)t;
					Type[] typeArgs = parameterizedType.getActualTypeArguments();
					if (typeArgs.length > 0) {
						if (typeArgs[0].equals(dtoClass)) {
							controllerClass = candidat;
							break;
						}
					}
				}
			}
		}
		return controllerClass;	
	}

	private String getApiUrl(
			Class<?> dtoClass,
			Class<?> controllerClass) throws ClassNotFoundException {
		RequestMapping requestMappingAnnotation = controllerClass.getAnnotation(RequestMapping.class);
		if (requestMappingAnnotation != null) {
			String[] values = requestMappingAnnotation.value();
			if (values.length > 0) {
				return values[0];
			}
		}
		return null;
	}

	public static List<ProfileResourceField> getFields(
			Class<?> dtoClass) {
		String resourceName = getResourceNameFromDtoClass(dtoClass);
		List<ProfileResourceField> fields = new ArrayList<ProfileResourceField>();
		for (Field field: dtoClass.getDeclaredFields()) {
			ProfileResourceField fieldConfig = new ProfileResourceField();
			fieldConfig.setName(field.getName());
			fieldConfig.setType(getFieldType(field));
			fieldConfig.setMultiple(Collection.class.isAssignableFrom(field.getType()));
			fieldConfig.setTranslateKey(
					TRANSLATE_KEY_PREFIX + resourceName + ".field." + field.getName());
			if (field.getAnnotation(NotEmpty.class) != null) {
				fieldConfig.setRequired(true);
			}
			if (field.getAnnotation(NotNull.class) != null) {
				fieldConfig.setRequired(true);
			}
			Size size = field.getAnnotation(Size.class);
			if (size != null) {
				if (size.min() > 0) {
					fieldConfig.setMinLength(size.min());
				}
				if (size.max() < Integer.MAX_VALUE) {
					fieldConfig.setMaxLength(size.max());
				}
			}
			Digits digits = field.getAnnotation(Digits.class);
			if (digits != null) {
				if (digits.integer() > 0) {
					fieldConfig.setMaxLength(digits.integer());
				}
				if (digits.fraction() > 0) {
					fieldConfig.setDecimalMaxLength(digits.fraction());
				}
			}
			RestapiField restapiField = field.getAnnotation(RestapiField.class);
			if (restapiField != null) {
				RestapiFieldType fieldType = restapiField.type();
				if (fieldType == RestapiFieldType.AUTO) {
					fieldType = restapiField.value();
				}
				if (fieldType != RestapiFieldType.AUTO) {
					fieldConfig.setType(fieldType);
				}
				if (restapiField.sizeMin() > 0) {
					fieldConfig.setMinLength(restapiField.sizeMin());
				}
				if (restapiField.sizeMax() < Integer.MAX_VALUE) {
					fieldConfig.setMaxLength(restapiField.sizeMax());
				}
				fieldConfig.setDisabledForCreate(
						restapiField.disabledForCreate());
				fieldConfig.setDisabledForUpdate(
						restapiField.disabledForUpdate());
				fieldConfig.setHiddenInGrid(
						restapiField.hiddenInGrid());
				fieldConfig.setHiddenInForm(
						restapiField.hiddenInForm());
				fieldConfig.setHiddenInLov(
						restapiField.hiddenInLov());
				fieldConfig.setToUpperCase(
						restapiField.toUpperCase());
			}
			if (fieldConfig.getType() == RestapiFieldType.ENUM) {
				Class<?> enumType = field.getType();
				if (Collection.class.isAssignableFrom(field.getType())) {
					ParameterizedType collectionGenericType = (ParameterizedType)field.getGenericType();
					enumType = (Class<?>)collectionGenericType.getActualTypeArguments()[0];
				}
				if (enumType.isEnum()) {
					fieldConfig.setEnumValues(
							enumType.getEnumConstants());
				}
			}
			if (restapiField != null) {
				fieldConfig.setIncludeInQuickFilter(restapiField.includeInQuickFilter());
			}
			if (field.getName().equals("id") || field.getName().startsWith("parentId")) {
				fieldConfig.setHiddenInGrid(true);
				fieldConfig.setHiddenInForm(true);
				fieldConfig.setHiddenInLov(true);
			}
			if (fieldConfig.getType() == RestapiFieldType.LOV) {
				fillLovField(fieldConfig, dtoClass);
			}
			fields.add(fieldConfig);
		}
		if (dtoClass.getSuperclass() != null && !dtoClass.getSuperclass().getSimpleName().contains("Auditable")) {
			fields.addAll(
					getFields(dtoClass.getSuperclass()));
		}
		return fields;
	}

	public static RestapiFieldType getFieldType(Field field) {
		Class<?> type = field.getType();
		if (Collection.class.isAssignableFrom(type)) {
			ParameterizedType collectionGenericType = (ParameterizedType)field.getGenericType();
			type = (Class<?>)collectionGenericType.getActualTypeArguments()[0];
		}
		if (type.isEnum()) {
			return RestapiFieldType.ENUM;
		} else {
			String simpleName = type.getSimpleName();
			if ("String".equals(simpleName)) {
				return RestapiFieldType.STRING;
			} else if ("int".equals(simpleName) || "Integer".equals(simpleName)) {
				return RestapiFieldType.INTEGER;
			} else if ("long".equals(simpleName) || "Long".equals(simpleName)) {
				return RestapiFieldType.INTEGER;
			} else if ("float".equals(simpleName) || "Float".equals(simpleName)) {
				return RestapiFieldType.FLOAT;
			} else if ("double".equals(simpleName) || "Double".equals(simpleName)) {
				return RestapiFieldType.FLOAT;
			} else if ("boolean".equals(simpleName) || "Boolean".equals(simpleName)) {
				return RestapiFieldType.BOOLEAN;
			} else if ("Date".equals(simpleName)) {
				return RestapiFieldType.DATE;
			} else if ("BigDecimal".equals(simpleName)) {
				return RestapiFieldType.BIGDECIMAL;
			} else if (AbstractIdentificable.class.isAssignableFrom(type) || GenericReference.class.isAssignableFrom(type)) {
				return RestapiFieldType.LOV;
			}
			return RestapiFieldType.STRING;
		}
	}

	private static void fillLovField(
			ProfileResourceField lovField,
			Class<?> dtoClass) {
		Field found = null;
		for (Field field: dtoClass.getDeclaredFields()) {
			if (field.getName().equals(lovField.getName())) {
				found = field;
				break;
			}
		}
		if (found != null) {
			Class<?> referencedResourceClass;
			if (GenericReference.class.isAssignableFrom(found.getType())) {
				ParameterizedType collectionType = (ParameterizedType)found.getGenericType();
				referencedResourceClass = (Class<?>)collectionType.getActualTypeArguments()[0];
				lovField.setLovDescriptionField("description");
			} else {
				referencedResourceClass = found.getType();
			}
			RestapiResource resourceAnnotation = referencedResourceClass.getAnnotation(RestapiResource.class);
			if (resourceAnnotation != null && !resourceAnnotation.descriptionField().isEmpty()) {
				lovField.setLovDescriptionField(resourceAnnotation.descriptionField());
			}
			if (GenericReference.class.isAssignableFrom(found.getType())) {
				lovField.setLovDescriptionFieldInFront("description");
			} else {
				lovField.setLovDescriptionFieldInFront(lovField.getLovDescriptionField());
			}
			lovField.setLovResourceName(
					Character.toLowerCase(referencedResourceClass.getSimpleName().charAt(0)) + referencedResourceClass.getSimpleName().substring(1));
			RestapiField restapiField = found.getAnnotation(RestapiField.class);
			if (restapiField != null) {
				lovField.setLovWithDescriptionInput(restapiField.lovWithDescriptionInput());
				if (!restapiField.lovParentField().isEmpty()) {
					lovField.setLovParentField(restapiField.lovParentField());
				}
			}
		}
	}

	private static String getResourceNameFromDtoClass(Class<?> dtoClass) {
		return Character.toLowerCase(dtoClass.getSimpleName().charAt(0)) + dtoClass.getSimpleName().substring(1);
	}

	private boolean isQuickFilterAvailable(Class<?> dtoClass) {
		for (Field field: dtoClass.getDeclaredFields()) {
			RestapiField restapiField = field.getAnnotation(RestapiField.class);
			if (restapiField != null && restapiField.includeInQuickFilter()) {
				return true;
			}
		}
		return false;
	}

}
