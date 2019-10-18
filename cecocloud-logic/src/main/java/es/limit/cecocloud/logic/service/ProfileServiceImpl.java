/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.alps.Alps;
import org.springframework.hateoas.alps.Descriptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import es.limit.cecocloud.logic.api.annotation.RestapiField;
import es.limit.cecocloud.logic.api.annotation.RestapiGrid;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.GeoPosition;
import es.limit.cecocloud.logic.api.dto.Permission;
import es.limit.cecocloud.logic.api.dto.Profile;
import es.limit.cecocloud.logic.api.dto.ProfileResource;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.ProfileResourceGrid;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.dto.util.AuthenticationFacade;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.service.ProfileService;

/**
 * Implementació del servei per a obtenir perfil d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	private static final String TRANSLATE_KEY_PREFIX = "resource.";

	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	public Profile getProfile(
			String resourceName,
			String profileHref,
			String permissionResourceId) throws ClassNotFoundException {
		Class<?> dtoClass = getDtoClassForName(resourceName);
		if (dtoClass != null) {
			return getProfile(dtoClass, profileHref, permissionResourceId);
		} else {
			throw new ClassNotFoundException("Classe pel recurs " + resourceName + " no trobada");
		}
	}

	@Override
	public Profile getProfile(
			Class<?> dtoClass,
			String profileHref,
			String permissionResourceId) throws ClassNotFoundException {
		ProfileResource resource = new ProfileResource();
		resource.setName(getResourceNameFromDtoClass(dtoClass));
		/*Class<?> controllerClass = getControllerClassForDto(dtoClass);
		if (controllerClass != null) {
			resource.setApiUrl(getApiUrl(controllerClass));
		}*/
		Class<?> permissionDtoClass;
		if (permissionResourceId != null) {
			permissionDtoClass = Permission.class;
			resource.setName(getResourceNameFromDtoClass(Permission.class));
			//resource.setApiUrl(resource.getApiUrl() + "/" + permissionResourceId + "/permissions");
		} else {
			permissionDtoClass = dtoClass;
		}
		resource.setTranslateKey(
				TRANSLATE_KEY_PREFIX + resource.getName());
		resource.setTranslateKeyPlural(
				TRANSLATE_KEY_PREFIX + resource.getName() + ".plural");
		List<ProfileResourceField> fields = getFields(permissionDtoClass);
		resource.setFields(fields);
		calculateGridPercentWidths(fields);
		resource.setQuickFilterAvailable(isQuickFilterAvailable(permissionDtoClass));
		resource.setHasCreatePermission(true);
		resource.setHasReadPermission(true);
		resource.setHasUpdatePermission(true);
		resource.setHasDeletePermission(true);
		resource.setHasAdminPermission(true);
		RestapiResource resourceAnnotation = permissionDtoClass.getAnnotation(RestapiResource.class);
		if (resourceAnnotation != null) {
			// Configura el camp de descripció
			if (!resourceAnnotation.descriptionField().isEmpty()) {
				resource.setDescriptionField(resourceAnnotation.descriptionField());
			}
			// Configura els grids
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
			// Configura els permisos
			resource.setHasCreatePermission(
					checkPermission(resourceAnnotation.authoritiesWithCreatePermission()));
			resource.setHasReadPermission(
					checkPermission(resourceAnnotation.authoritiesWithReadPermission()));
			resource.setHasUpdatePermission(
					checkPermission(resourceAnnotation.authoritiesWithUpdatePermission()));
			resource.setHasDeletePermission(
					checkPermission(resourceAnnotation.authoritiesWithDeletePermission()));
			resource.setHasAdminPermission(
					checkPermission(resourceAnnotation.authoritiesWithAdminPermission()));
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
	}

	public static Class<?> getDtoClassForName(
			String resourceName) {
		Class<?> dtoClass = null;
		for (String packageToScan: new String [] {Profile.class.getPackage().getName()}) {
			dtoClass = getClassForName(packageToScan + "." + StringUtils.capitalize(resourceName));
			if (dtoClass == null) {
				dtoClass = getClassForName(packageToScan + "." + resourceName);
			}
			if (dtoClass != null) {
				break;
			}
		}
		return dtoClass;
	}

	private static Class<?> getClassForName(String className) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException ignored) {
			return null;
		}
	}

	public static List<ProfileResourceField> getFields(
			Class<?> dtoClass) {
		String resourceName = getResourceNameFromDtoClass(dtoClass);
		List<ProfileResourceField> resourceFields = new ArrayList<ProfileResourceField>();
		// Afegim els camps de la classe
		for (Field field: dtoClass.getDeclaredFields()) {
			resourceFields.add(
					createResourceField(
							field.getName(),
							field.getType(),
							field.getGenericType(),
							field,
							resourceName,
							dtoClass));
		}
		// Afegim els mètodes get de la classe que no estan afegits com a camps
		for (Method method: dtoClass.getMethods()) {
			if (method.getName().startsWith("get") && !method.getName().equals("getId") && !method.getName().equals("getClass")) {
				String fieldName = firstLetterInLowerCase(method.getName().substring("get".length()));
				boolean alreadyExists = false;
				for (ProfileResourceField resourceField: resourceFields) {
					if (resourceField.getName().equals(fieldName)) {
						alreadyExists = true;
						break;
					}
				}
				if (!alreadyExists) {
					resourceFields.add(
							createResourceField(
									fieldName,
									method.getReturnType(),
									method.getGenericReturnType(),
									method,
									resourceName,
									dtoClass));
				}
			}
		}
		// Afegim els camps i mètodes get de la superclasse (si en te)
		if (dtoClass.getSuperclass() != null && !dtoClass.getSuperclass().getSimpleName().contains("Auditable")) {
			resourceFields.addAll(
					getFields(dtoClass.getSuperclass()));
		}
		return resourceFields;
	}
	
	private static ProfileResourceField createResourceField(
			String fieldName,
			Class<?> fieldType,
			Type fieldGenericType,
			AnnotatedElement annotatedElement,
			String resourceName,
			Class<?> dtoClass) {
		RestapiFieldType restapiFieldType = getFieldType(fieldType, fieldGenericType);
		ProfileResourceField fieldConfig = new ProfileResourceField();
		fieldConfig.setName(fieldName);
		fieldConfig.setType(restapiFieldType);
		fieldConfig.setMultiple(Collection.class.isAssignableFrom(fieldType));
		fieldConfig.setTranslateKey(
				TRANSLATE_KEY_PREFIX + resourceName + ".field." + fieldName);
		if (annotatedElement.getAnnotation(NotEmpty.class) != null) {
			fieldConfig.setRequired(true);
		}
		if (annotatedElement.getAnnotation(NotNull.class) != null) {
			fieldConfig.setRequired(true);
		}
		Size size = annotatedElement.getAnnotation(Size.class);
		if (size != null) {
			if (size.min() > 0) {
				fieldConfig.setMinLength(size.min());
			}
			if (size.max() < Integer.MAX_VALUE) {
				fieldConfig.setMaxLength(size.max());
			}
		}
		Digits digits = annotatedElement.getAnnotation(Digits.class);
		if (digits != null) {
			if (digits.integer() > 0) {
				fieldConfig.setMaxLength(digits.integer());
			}
			if (digits.fraction() > 0) {
				fieldConfig.setDecimalMaxLength(digits.fraction());
			}
		}
		RestapiField restapiField = annotatedElement.getAnnotation(RestapiField.class);
		if (restapiField != null) {
			RestapiFieldType annotationFieldType = restapiField.type();
			if (annotationFieldType == RestapiFieldType.AUTO) {
				annotationFieldType = restapiField.value();
			}
			if (annotationFieldType != RestapiFieldType.AUTO) {
				fieldConfig.setType(annotationFieldType);
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
			fieldConfig.setGridPercentWidth(
					restapiField.gridPercentWidth());
		}
		if (fieldConfig.getType() == RestapiFieldType.ENUM) {
			Class<?> enumType = getRealFieldType(fieldType, fieldGenericType);
			if (enumType.isEnum()) {
				fieldConfig.setEnumValues(
						enumType.getEnumConstants());
			}
		}
		if (restapiField != null) {
			fieldConfig.setIncludeInQuickFilter(restapiField.includeInQuickFilter());
		}
		if (fieldName.equals("id") || fieldName.startsWith("parentId")) {
			fieldConfig.setHiddenInGrid(true);
			fieldConfig.setHiddenInForm(true);
			fieldConfig.setHiddenInLov(true);
		}
		if (fieldConfig.getType() == RestapiFieldType.LOV) {
			fillLovField(fieldConfig, dtoClass);
		}
		return fieldConfig;
	}

	private static RestapiFieldType getFieldType(
			Class<?> fieldType,
			Type fieldGenericType) {
		Class<?> realType = getRealFieldType(fieldType, fieldGenericType);
		if (realType.isEnum()) {
			return RestapiFieldType.ENUM;
		} else {
			String simpleName = realType.getSimpleName();
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
			} else if (AbstractIdentificable.class.isAssignableFrom(realType) || GenericReference.class.isAssignableFrom(realType)) {
				return RestapiFieldType.LOV;
			} else if (GeoPosition.class.isAssignableFrom(realType)) {
				return RestapiFieldType.GEOPOS;
			}
			return RestapiFieldType.STRING;
		}
	}

	private static Class<?> getRealFieldType(
			Class<?> fieldType,
			Type fieldGenericType) {
		if (Collection.class.isAssignableFrom(fieldType)) {
			ParameterizedType collectionGenericType = (ParameterizedType)fieldGenericType;
			return (Class<?>)collectionGenericType.getActualTypeArguments()[0];
		} else {
			return fieldType;
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
			lovField.setLovGenericResource(GenericReference.class.isAssignableFrom(found.getType()));
			lovField.setLovResourceName(
					Character.toLowerCase(referencedResourceClass.getSimpleName().charAt(0)) + referencedResourceClass.getSimpleName().substring(1));
			/*RestapiField restapiField = found.getAnnotation(RestapiField.class);
			if (restapiField != null) {
				lovField.setLovWithDescriptionInput(restapiField.lovWithDescriptionInput());
				if (!restapiField.lovParentField().isEmpty()) {
					lovField.setLovParentField(restapiField.lovParentField());
				}
			}*/
		}
	}

	private static void calculateGridPercentWidths(
			List<ProfileResourceField> resourceFields) {
		float percentToDistribute = 100;
		float totalMaxLengthWidth = 0;
		float numFieldsMaxLength = 0;
		float numFieldsNoWidth = 0;
		for (ProfileResourceField resourceField: resourceFields) {
			if (!resourceField.isHiddenInGrid()) {
				int fieldMaxLength = getFieldMaxLength(resourceField);
				totalMaxLengthWidth += fieldMaxLength;
				if (resourceField.getGridPercentWidth() > 0) {
					percentToDistribute -= resourceField.getGridPercentWidth();
				} else {
					if (fieldMaxLength > 0) {
						numFieldsMaxLength++;
					} else {
						numFieldsNoWidth++;
					}
				}
			}
		}
		float percentForMaxLength = percentToDistribute * (numFieldsMaxLength / (numFieldsMaxLength + numFieldsNoWidth));
		float percentForNoWidth = percentToDistribute * (numFieldsNoWidth / (numFieldsMaxLength + numFieldsNoWidth));
		for (ProfileResourceField resourceField: resourceFields) {
			if (!resourceField.isHiddenInGrid()) {
				if (resourceField.getGridPercentWidth() <= 0) {
					int fieldMaxLength = getFieldMaxLength(resourceField);
					if (fieldMaxLength > 0) {
						resourceField.setGridPercentWidth(fieldMaxLength * percentForMaxLength / totalMaxLengthWidth);
					} else {
						resourceField.setGridPercentWidth(percentForNoWidth / numFieldsNoWidth);
					}
				}
			}
		}
	}

	private static int getFieldMaxLength(ProfileResourceField resourceField) {
		if (RestapiFieldType.DATE.equals(resourceField.getType())) {
			return 10;
		} else if (RestapiFieldType.DATETIME.equals(resourceField.getType())) {
			return 19;
		} else if (RestapiFieldType.BOOLEAN.equals(resourceField.getType())) {
			return 5;
		} else {
			int maxLength = 0;
			if (resourceField.getMaxLength() != null && resourceField.getMaxLength() > 0) {
				maxLength += resourceField.getMaxLength();
			}
			if (resourceField.getDecimalMaxLength() != null && resourceField.getDecimalMaxLength() > 0) {
				maxLength += resourceField.getDecimalMaxLength() + 1; // +1 per tenir en compte el separador de decimals
			}
			return maxLength;
		}
	}

	private static String getResourceNameFromDtoClass(Class<?> dtoClass) {
		return firstLetterInLowerCase(dtoClass.getSimpleName());
	}
	private static String firstLetterInLowerCase(String str) {
		if (str.isEmpty()) {
			return str;
		} else {
			return Character.toLowerCase(str.charAt(0)) + str.substring(1);
		}
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

	private boolean checkPermission(Rol[] restrictedToAuthorities) {
		if (restrictedToAuthorities == null || restrictedToAuthorities.length == 0) {
			return true;
		} else {
			return hasAnyAuthority(
					authenticationFacade.getAuthentication(),
					restrictedToAuthorities);
		}
	}

	private boolean hasAnyAuthority(
			Authentication authentication,
			Rol... roles) {
		if (roles == null || roles.length == 0) {
			return false;
		} else {
			for (GrantedAuthority authority: authentication.getAuthorities()) {
				for (Rol role: roles) {
					if (role.name().equals(authority.getAuthority())) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
