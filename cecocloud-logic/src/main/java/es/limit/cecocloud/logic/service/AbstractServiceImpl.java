/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLOperators;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.dto.util.IdentificableWithCompositePk;
import es.limit.cecocloud.logic.rsql.CustomRsqlVisitor;
import es.limit.cecocloud.logic.rsql.RsqlSearchOperation;
import es.limit.cecocloud.persist.entity.AbstractCompositePkEntity;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.entity.EmbeddableEntity;
import es.limit.cecocloud.persist.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

/**
 * Mètodes comuns pels serveis genèrics.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
public abstract class AbstractServiceImpl<D extends Identificable<ID>, ID extends Serializable, E extends EmbeddableEntity<D, PK>, PK extends Serializable> implements InitializingBean {

	@Autowired
    private ObjectMapper objectMapper;
	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private BaseRepository<E, PK> repository;
	@Autowired
	private List<BaseRepository<?, ?>> repositories;

	private Class<E> entityClass;
	private Class<D> dtoClass;
	private Class<? extends Serializable> pkClass;
	private Map<Class<? extends Identificable<?>>, BaseRepository<?, ?>> referencedRepositoriesMap;

	@Override
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		Class<D> dtoClass = getDtoClass();
		Class<E> entityClass = getEntityClass();
		log.info("Configurant service pel recurs " + dtoClass + " amb l'entitat associada " + entityClass);
		for (Field field: getDtoClass().getDeclaredFields()) {
			Class<? extends Identificable<?>> referencedClass = null;
			if (field.getType().isAssignableFrom(GenericReference.class)) {
				ParameterizedType parameterizedType = (ParameterizedType)field.getGenericType();
				referencedClass = (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
			} else if (Identificable.class.isAssignableFrom(field.getType())) {
				referencedClass = (Class<? extends Identificable<?>>)field.getType();
			}
			if (referencedClass != null) {
				log.info("   Configurant repository JPA pel recurs " + referencedClass + ".");
				BaseRepository<?, ?> referencedRepository = getRepositoryForReferencedClass(referencedClass);
				log.debug("Afegint repository per referència " + field.getName() + " al servei " + getClass().getName());
				if (referencedRepository != null) {
					if (referencedRepositoriesMap == null) {
						referencedRepositoriesMap = new HashMap<Class<? extends Identificable<?>>, BaseRepository<?, ?>>();
					}
					referencedRepositoriesMap.put(referencedClass, referencedRepository);
				} else {
					throw new Exception("No s'ha trobat cap repository per a la classe " + referencedClass + " al servei " + getClass().getName());
				}
			}
		}
		Method builderMethod = entityClass.getMethod("builder");
		if (!Modifier.isStatic(builderMethod.getModifiers())) {
			throw new Exception("El mètode builder de la classe " + entityClass + " no te el modificador static");
		}
		Class<?> builderReturnType = builderMethod.getReturnType();
		builderReturnType.getMethod("build");
		builderReturnType.getMethod("embedded", getDtoClass());
	}

	@SuppressWarnings("unchecked")
	protected E buildNewEntity(D dto) {
		try {
			Method builderMethod = getEntityClass().getMethod("builder");
			Class<?> builderReturnType = builderMethod.getReturnType();
			Object builderInstance = builderMethod.invoke(null); // builderInstance = dtoClass.builder();
			// Es crida el mètode "embedded" del builder que guarda la informació del DTO
			Method embeddedMethod = builderReturnType.getMethod("embedded", getDtoClass());
			embeddedMethod.invoke(builderInstance, dto); // builderInstance.embedded(dto);
			// Si el DTO exten de AbstractIdentificableWithCompositePk vol dir que te clau primària composta
			if (IdentificableWithCompositePk.class.isAssignableFrom(dto.getClass())) {
				Class<? extends Serializable> pkClass = getPkClass();
				Method pkMethod = builderReturnType.getMethod("pk", pkClass);
				pkMethod.invoke(builderInstance, getPkFromDto(dto)); // builderInstance.pk(pk);
			}
			if (referencedRepositoriesMap != null) {
				// Es criden els mètodes del builder per a les entitats referenciades en el DTO
				for (Method builderCallableMethod: builderReturnType.getDeclaredMethods()) {
					// Només es criden els mètodes amb un argument
					if (builderCallableMethod.getParameterTypes().length == 1) {
						// Només es criden els métodes que no son "embedded"
						if (!builderCallableMethod.equals(embeddedMethod)) {
							AbstractEntity<?, ?> referencedEntity = getReferencedEntityForDtoField(
									builderCallableMethod.getParameterTypes()[0],
									dto,
									builderCallableMethod.getName());
							if (referencedEntity != null) {
								builderCallableMethod.invoke(builderInstance, referencedEntity); // builderInstance.referencedEntityName(referencedEntity);
							}
						}
					}
				}
			}
			// Es crida el mètode build per a crear la instància de l'entitat
			Method buildMethod = builderReturnType.getMethod("build");
			return (E)buildMethod.invoke(builderInstance); // return builderInstance.build();
		} catch (Exception ex) {
			throw new RuntimeException("No s'ha pogut crear l'entitat de tipus " + getEntityClass(), ex);
		}
	}

	protected void updateEntity(E entity, D dto) {
		// Crida el mètode update per a actualitzar el camp embedded
		entity.update(dto);
		// Es suposa que, per a cada entitat a la que es fa referència, existeix un mètode update*.
		// Crida cada un dels mètodes update* passant com a paràmetre l'entitat corresponent
		for (Field field: getEntityClass().getDeclaredFields()) {
			if (!field.getName().equals("embedded") && AbstractPersistable.class.isAssignableFrom(field.getType())) {
				try {
					AbstractEntity<?, ?> referencedEntity = getReferencedEntityForDtoField(
							field.getType(),
							dto,
							field.getName());
					if (referencedEntity != null) {
						String updateMethodName = "update" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
						try {
							getEntityClass().getMethod(updateMethodName, field.getType()).invoke(entity, referencedEntity); // entity.update*(referencedEntity);
						} catch (NoSuchMethodException ignored) {
							// Si el mètode update no existeix suposarem que aquesta entitat no s'ha d'actualitzar
						}
					}
				} catch (Exception ex) {
					throw new RuntimeException("No s'ha pogut actualitzar el camp " + field.getName() + " de l'entitat " + entity, ex);
				}
			}
		}
	}

	protected Page<D> findPageByQuickFilterAndRsqlQuery(
			String quickFilter,
			String rsqlQuery,
			Pageable pageable) {
		Page<E> resultat;
		StringBuilder rsqlQueryWithQuickFilter = null;
		if (quickFilter != null) {
			rsqlQueryWithQuickFilter = buildRsqlQueryWithQuickFilter(quickFilter);
		}
		if (rsqlQuery != null) {
			if (rsqlQueryWithQuickFilter == null) {
				rsqlQueryWithQuickFilter = new StringBuilder();
			} else if (rsqlQueryWithQuickFilter.length() > 0) {
				rsqlQueryWithQuickFilter.append(";");
			}
			rsqlQueryWithQuickFilter.append(rsqlQuery);
		}
		if (rsqlQueryWithQuickFilter != null && rsqlQueryWithQuickFilter.length() > 0) {
			log.debug("Consulta amb filtre RSQL (" +
					"rsqlQuery=" + rsqlQueryWithQuickFilter + ")");
			Set<ComparisonOperator> operators = RSQLOperators.defaultOperators();
			operators.add(RsqlSearchOperation.EQUAL_IGNORE_CASE.getOperator());
			Node rootNode = new RSQLParser(operators).parse(rsqlQueryWithQuickFilter.toString());
			Specification<E> spec = rootNode.accept(new CustomRsqlVisitor<E>());
			resultat = getRepository().findAll(spec, processPageable(pageable));
		} else {
			log.debug("Consulta sense filtre RSQL");
			resultat = getRepository().findAll(processPageable(pageable));
		}
		return toDto(resultat, processPageable(pageable));
	}

	protected BaseRepository<E, PK> getRepository() {
		return repository;
	}

	protected D toDto(E entity) {
		D dto = orikaMapperFacade.map(
				entity,
				getDtoClass());
		if (AbstractCompositePkEntity.class.isAssignableFrom(getEntityClass())) {
			dto.setId(getDtoIdFromCompositePkEntity(
					(AbstractCompositePkEntity<?, ?>)entity));
		}
		return dto;
	}
	protected List<D> toDto(List<E> entities) {
		List<D> dtos = orikaMapperFacade.mapAsList(
				entities,
				getDtoClass());
		if (AbstractCompositePkEntity.class.isAssignableFrom(getEntityClass())) {
			IntStream.range(0, dtos.size()).forEach(i -> {
				dtos.get(i).setId(getDtoIdFromCompositePkEntity(
						(AbstractCompositePkEntity<?, ?>)entities.get(i)));
			});
		}
		return dtos;
	}
	protected Page<D> toDto(Page<E> entityPage, Pageable pageable) {
		return new PageImpl<D>(
				toDto(entityPage.getContent()),
				pageable,
				entityPage.getTotalElements());
	}

	@SuppressWarnings("unchecked")
	protected Class<D> getDtoClass() {
		if (dtoClass == null) {
			dtoClass = (Class<D>)getArgumentTypeFromGenericSuperclass(getClass(), 0);
		}
		return (Class<D>)dtoClass;
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getEntityClass() {
		if (entityClass == null) {
			if (AbstractGenericCompositePkServiceImpl.class.isAssignableFrom(getClass())) {
				entityClass = (Class<E>)getArgumentTypeFromGenericSuperclass(getClass(), 1);
			} else {
				entityClass = (Class<E>)getArgumentTypeFromGenericSuperclass(getClass(), 2);
			}
		}
		return (Class<E>)entityClass;
	}

	@SuppressWarnings("unchecked")
	protected Class<? extends Serializable> getPkClass() {
		if (pkClass == null) {
			pkClass = (Class<? extends Serializable>)getArgumentTypeFromGenericSuperclass(getDtoClass(), 0);
		}
		return (Class<? extends Serializable>)pkClass;
	}

	@SuppressWarnings("unchecked")
	protected PK getPkFromDto(D dto) {
		return (PK)dto.getId();
	}
	@SuppressWarnings("unchecked")
	protected Serializable getPkFromDtoId(ID id) {
		if (IdentificableWithCompositePk.class.isAssignableFrom(getDtoClass())) {
			byte[] idBase64 = ((String)id).getBytes();
			/*return (PK)SerializationUtils.deserialize(
					Base64.getDecoder().decode(idBase64));*/
			try {
				return objectMapper.readValue(
						new String(Base64.getDecoder().decode(idBase64)),
						getPkClass());
			} catch (IOException ex) {
				throw new RuntimeException("Error al convertir el DTO id " + id, ex);
			}
		} else {
			return (PK)id;
		}
	}
	@SuppressWarnings("unchecked")
	protected ID getDtoIdFromCompositePkEntity(AbstractCompositePkEntity<?, ?> entity) {
		/*byte[] idBase64 = Base64.getEncoder().encode(
				SerializationUtils.serialize(entity.getId()));*/
		try {
			byte[] idBase64 = Base64.getEncoder().encode(objectMapper.writeValueAsString(entity.getId()).getBytes());
			return (ID)new String(idBase64);
		} catch (JsonProcessingException ex) {
			throw new RuntimeException("Error al convertir la clau primària " + entity.getId() + " a DTO id", ex);
		}
		
	}
	
	private Type getArgumentTypeFromGenericSuperclass(Class<?> clazz, int index) {
		Type genericSuperClass = clazz.getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return parameterizedType.getActualTypeArguments()[index];
	}

	private BaseRepository<?, ?> getRepositoryForReferencedClass(Class<? extends Identificable<?>> dtoClass) {
		BaseRepository<?, ?> foundRepository = null;
		for (BaseRepository<?, ?> repository: repositories) {
			Class<?> entityType = getClassFromBaseRepositoryGenericType(repository, 0);
			if (entityType != null) {
				ParameterizedType parameterizedType = (ParameterizedType)((Class<?>)entityType).getGenericSuperclass();
				Type entityDtoClass = parameterizedType.getActualTypeArguments()[0];
				if (dtoClass.equals(entityDtoClass)) {
					foundRepository = repository;
					break;
				}
			}
		}
		return foundRepository;
	}

	private Class<?> getClassFromBaseRepositoryGenericType(BaseRepository<?, ?> repository, int index) {
		for (Class<?> repositoryInterface: repository.getClass().getInterfaces()) {
			for (Type repositorySubinterface: repositoryInterface.getGenericInterfaces()) {
				ParameterizedType parameterizedType = (ParameterizedType)repositorySubinterface;
				if (parameterizedType.getRawType().equals(BaseRepository.class)) {
					return (Class<?>)parameterizedType.getActualTypeArguments()[index];
				}
			}
		}
		return null;
	}

	private AbstractEntity<?, ?> getReferencedEntityForDtoField(
			Class<?> entityClass,
			D dto,
			String fieldName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object id = null;
		for (Field field: getDtoClass().getDeclaredFields()) {
			if (field.getName().equals(fieldName)) {
				field.setAccessible(true);
				if (field.getType().isAssignableFrom(GenericReference.class)) {
					GenericReference<?, ?> fieldValue = (GenericReference<?, ?>)field.get(dto);
					id = fieldValue.getId();
				} else if (Identificable.class.isAssignableFrom(field.getType())) {
					Identificable<?> fieldValue = (Identificable<?>)field.get(dto);
					id = fieldValue.getId();
				}
			}
			
		}
		if (id != null) {
			AbstractEntity<?, ?> referencedEntity = getEntityFromReferencedRepository(
					entityClass,
					id);
			return referencedEntity;
		}
		return null;
	}

	private AbstractEntity<?, ?> getEntityFromReferencedRepository(
			Class<?> entityClass,
			Object id) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ParameterizedType parameterizedType = (ParameterizedType)entityClass.getGenericSuperclass();
		BaseRepository<?, ?> referenceRepository = referencedRepositoriesMap.get(parameterizedType.getActualTypeArguments()[0]);
		Method getOneMethod = referenceRepository.getClass().getDeclaredMethod(
				"getOne",
				Object.class);
		return (AbstractEntity<?, ?>)getOneMethod.invoke(referenceRepository, id);
	}

	private Pageable processPageable(Pageable pageable) {
		List<Order> orders = new ArrayList<Order>();
		Field[] entityFields = getEntityClass().getDeclaredFields();
		Field[] dtoFields = getDtoClass().getDeclaredFields();
		List<ProfileResourceField> fields = ProfileServiceImpl.getFields(getDtoClass());
		for (Order order: pageable.getSort()) {
			boolean isEmbedded = true;
			for (Field field: entityFields) {
				if (field.getName().equals(order.getProperty())) {
					isEmbedded = false;
					break;
				}
			}
			if (isEmbedded) {
				for (Field field: dtoFields) {
					if (field.getName().equals(order.getProperty())) {
						if (field.getType().isAssignableFrom(GenericReference.class) || Identificable.class.isAssignableFrom(field.getType())) {
							isEmbedded = false;
						}
						break;
					}
				}
			}
			String property;
			if (isEmbedded) {
				property = "embedded_" + order.getProperty();
			} else {
				String descriptionField = null;
				for (ProfileResourceField field: fields) {
					if (field.getName().equals(order.getProperty())) {
						if (RestapiFieldType.LOV.equals(field.getType())) {
							descriptionField = field.getLovDescriptionField();
						}
						break;
					}
				}
				if (descriptionField != null) {
					property = order.getProperty() + "_embedded_" + descriptionField;
				} else {
					property = order.getProperty();
				}
			}
			if (order.isAscending()) {
				orders.add(Order.asc(property));
			} else {
				orders.add(Order.desc(property));
			}
		}
		return PageRequest.of(
				pageable.getPageNumber(),
				pageable.getPageSize(),
				Sort.by(orders));
	}

	private StringBuilder buildRsqlQueryWithQuickFilter(String quickFilter) {
		StringBuilder rsqlQuery = new StringBuilder();
		for (ProfileResourceField field: ProfileServiceImpl.getFields(getDtoClass())) {
			boolean includeField = field.isIncludeInQuickFilter();
			if (includeField) {
				if (RestapiFieldType.LOV.equals(field.getType()) && field.getLovDescriptionField() == null) {
					includeField = false;
				}
			}
			if (includeField) {
				if (rsqlQuery.length() == 0) {
					rsqlQuery.append("(");
				} else {
					rsqlQuery.append(",");
				}
				rsqlQuery.append(field.getName());
				if (RestapiFieldType.LOV.equals(field.getType())) {
					rsqlQuery.append(".");
					if (field.getLovDescriptionField() != null) {
						rsqlQuery.append(field.getLovDescriptionField());
					}
				}
				rsqlQuery.append(RsqlSearchOperation.EQUAL_IGNORE_CASE.getOperator().getSymbol());
				rsqlQuery.append("*");
				rsqlQuery.append(quickFilter);
				rsqlQuery.append("*");
			}
		}
		if (rsqlQuery.length() > 0) {
			rsqlQuery.append(")");
		}
		return rsqlQuery;
	}

	protected void beforeCreate(E entity, D dto) {}
	protected void afterCreate(E entity, D dto) {}
	protected void beforeUpdate(E entity, D dto) {}
	protected void afterUpdate(E entity, D dto) {}
	protected void beforeDelete(E entity) {}
	protected void afterDelete(E entity) {}

}
