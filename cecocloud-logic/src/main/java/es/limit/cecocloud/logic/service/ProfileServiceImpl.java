/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
import es.limit.cecocloud.logic.api.dto.ProfileField;
import es.limit.cecocloud.logic.api.dto.ProfileField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.ProfileForm;
import es.limit.cecocloud.logic.api.dto.ProfileGrid;
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
			ProfileForm resourceForm = new ProfileForm();
			Class<?> dtoClass = getDtoClassForName(resourceName);
			resourceForm.setName(
					Character.toLowerCase(dtoClass.getSimpleName().charAt(0)) + dtoClass.getSimpleName().substring(1));
			Class<?> controllerClass = getControllerClassForDto(dtoClass);
			if (controllerClass != null) {
				resourceForm.setApiUrl(
						getApiUrl(
								dtoClass,
								controllerClass));
			}
			resourceForm.setTranslateKey(
					TRANSLATE_KEY_PREFIX + resourceForm.getName());
			resourceForm.setTranslateKeyPlural(
					TRANSLATE_KEY_PREFIX + resourceForm.getName() + ".plural");
			resourceForm.setFields(getFields(dtoClass, resourceForm));
			fillLovFields(
					resourceForm.getFields(),
					dtoClass);
			RestapiResource resourceAnnotation = dtoClass.getAnnotation(RestapiResource.class);
			if (resourceAnnotation != null) {
				if (!resourceAnnotation.descriptionField().isEmpty()) {
					resourceForm.setDescriptionField(resourceAnnotation.descriptionField());
				}
				if (resourceAnnotation.grids().length > 0) {
					List<ProfileGrid> grids = new ArrayList<ProfileGrid>();
					for (RestapiGrid grid: resourceAnnotation.grids()) {
						ProfileGrid gridConfig = new ProfileGrid();
						gridConfig.setResourceName(grid.value());
						if (!grid.name().isEmpty()) {
							gridConfig.setName(grid.name());
						} else {
							gridConfig.setName(grid.value());
						}
						gridConfig.setTranslateKey(
								TRANSLATE_KEY_PREFIX + resourceForm.getName() + ".grid." + grid.value());
						grids.add(gridConfig);
					}
					resourceForm.setGrids(grids);
				}
			}
			Profile profile = new Profile();
			List<Descriptor> fieldDescriptors = new ArrayList<Descriptor>();
			for (ProfileField resourceField: resourceForm.getFields()) {
				fieldDescriptors.add(
						Alps.descriptor().
						name(resourceField.getName()).
						type(org.springframework.hateoas.alps.Type.SEMANTIC).
						build());
			}
			List<Descriptor> descriptors = new ArrayList<Descriptor>();
			descriptors.add(
					Alps.descriptor().
					id(resourceForm.getName() + "-representation").
					href(profileHref).
					descriptors(fieldDescriptors).
					build());
			Alps alps = Alps.alps().descriptors(descriptors).build();
			profile.setAlps(alps);
			profile.setForm(resourceForm);
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

	public static List<ProfileField> getFields(
			Class<?> dtoClass,
			ProfileForm resource) {
		List<ProfileField> fields = new ArrayList<ProfileField>();
		for (Field field: dtoClass.getDeclaredFields()) {
			ProfileField fieldConfig = new ProfileField();
			fieldConfig.setName(field.getName());
			fieldConfig.setType(getFieldType(field));
			if (resource != null) {
				fieldConfig.setTranslateKey(
						TRANSLATE_KEY_PREFIX + resource.getName() + ".field." + field.getName());
			}
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
				if (restapiField == null) {
					if (field.getType().isEnum()) {
						fieldConfig.setEnumValues(
								field.getType().getEnumConstants());
					}
				}
			}
			if (restapiField != null) {
				fieldConfig.setIncludeInQuickFilter(restapiField.includeInQuickFilter());
			}
			fields.add(fieldConfig);
		}
		if (dtoClass.getSuperclass() != null && !dtoClass.getSuperclass().getSimpleName().contains("Auditable")) {
			fields.addAll(
					getFields(dtoClass.getSuperclass(), resource));
		}
		return fields;
	}

	public static RestapiFieldType getFieldType(Field field) {
		Class<?> resourceType = field.getType();
		String simpleName = resourceType.getSimpleName();
		if (resourceType.isEnum()) {
			return RestapiFieldType.ENUM;
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
		} else {
			return RestapiFieldType.STRING;
		}
	}

	private void fillLovFields(
			List<ProfileField> fields,
			Class<?> dtoClass) {
		for (ProfileField fieldConfig: fields) {
			if (fieldConfig.getType() == RestapiFieldType.LOV) {
				Field found = null;
				for (Field field: dtoClass.getDeclaredFields()) {
					if (field.getName().equals(fieldConfig.getName())) {
						found = field;
						break;
					}
				}
				if (found != null) {
					Class<?> lovResourceClass = found.getType();
					RestapiField restapiField = found.getAnnotation(RestapiField.class);
					fieldConfig.setLovResource(
							Character.toLowerCase(lovResourceClass.getSimpleName().charAt(0)) + lovResourceClass.getSimpleName().substring(1));
					fieldConfig.setLovWithDescriptionInput(restapiField.lovWithDescriptionInput());
					if (!restapiField.lovModule().isEmpty()) {
						fieldConfig.setLovModule(restapiField.lovModule());
					}
					if (!restapiField.lovParentField().isEmpty()) {
						fieldConfig.setLovParentField(restapiField.lovParentField());
					}
					RestapiResource resourceAnnotation = lovResourceClass.getAnnotation(RestapiResource.class);
					if (resourceAnnotation != null && !resourceAnnotation.descriptionField().isEmpty()) {
						fieldConfig.setLovDescriptionField(resourceAnnotation.descriptionField());
					}
				}
			}
		}
	}

}
