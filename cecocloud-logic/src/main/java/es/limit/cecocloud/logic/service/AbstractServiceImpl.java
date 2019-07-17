/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.Specification;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLOperators;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.rsql.CustomRsqlVisitor;
import es.limit.cecocloud.logic.rsql.RsqlSearchOperation;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import es.limit.cecocloud.persist.repository.BaseRepository;
import ma.glasnost.orika.MapperFacade;

/**
 * Mètodes comuns pels serveis genèrics.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractServiceImpl<D extends Identificable<ID>, P1 extends AbstractEntity<?, ?>, P2 extends AbstractEntity<?, ?>, E extends AbstractEntity<D, ID>, ID extends Serializable> implements InitializingBean {

	@Autowired
	protected MapperFacade orikaMapperFacade;
	@Autowired
	private BaseRepository<E, ID> repository;
	@Autowired
	private List<BaseRepository<?, ?>> repositories;

	private Class<P1> parent1Class;
	private Class<P2> parent2Class;
	private Class<E> entityClass;
	private Class<D> dtoClass;
	private Map<Class<? extends Identificable<?>>, BaseRepository<?, ?>> referencedRepositoriesMap;

	@Override
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		for (Field field: getDtoClass().getDeclaredFields()) {
			Class<? extends Identificable<?>> referencedClass = null;
			if (field.getType().isAssignableFrom(GenericReference.class)) {
				ParameterizedType parameterizedType = (ParameterizedType)field.getGenericType();
				referencedClass = (Class<? extends Identificable<?>>)parameterizedType.getActualTypeArguments()[0];
			} else if (Identificable.class.isAssignableFrom(field.getType())) {
				referencedClass = (Class<? extends Identificable<?>>)field.getType();
			}
			if (referencedClass != null) {
				BaseRepository<?, ?> referencedRepository = getRepositoryForReferencedClass(referencedClass);
				logger.debug("Afegint repository per referència " + field.getName() + " al servei " + getClass().getName());
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
		Method builderMethod = getEntityClass().getMethod("builder");
		if (!Modifier.isStatic(builderMethod.getModifiers())) {
			throw new Exception("El mètode builder de la classe " + getEntityClass() + " no te el modificador static");
		}
		Class<?> builderReturnType = builderMethod.getReturnType();
		builderReturnType.getMethod("build");
		builderReturnType.getMethod("embedded", getDtoClass());
		if (isChildService()) {
			builderReturnType.getMethod("parent", getParent1Class());
		}
		if (isChildChildService()) {
			builderReturnType.getMethod("parent1", getParent1Class());
			builderReturnType.getMethod("parent2", getParent2Class());
		}
	}

	@SuppressWarnings("unchecked")
	protected E buildNewEntity(P1 parent1, P2 parent2, D dto) {
		try {
			Method builderMethod = getEntityClass().getMethod("builder");
			Class<?> builderReturnType = builderMethod.getReturnType();
			Method embeddedMethod = builderReturnType.getMethod("embedded", getDtoClass());
			Object builderInstance = builderMethod.invoke(null);
			// Es crida el mètode que guarda els valors del DTO a dins embedded
			embeddedMethod.invoke(builderInstance, dto);
			Method parent1Method = null;
			Method parent2Method = null;
			if (isChildService()) {
				parent1Method = builderReturnType.getMethod("parent", getParent1Class());
				// Es crida el mètode que configura el pare
				parent1Method.invoke(builderInstance, parent1);
			}
			if (isChildChildService()) {
				parent2Method = builderReturnType.getMethod("parent1", getParent1Class());
				// Es crida el mètode que configura el primer pare
				parent2Method.invoke(builderInstance, parent1);
				parent2Method = builderReturnType.getMethod("parent2", getParent1Class());
				// Es crida el mètode que configura el segon pare
				parent2Method.invoke(builderInstance, parent2);
			}
			if (referencedRepositoriesMap != null) {
				// Es criden els mètodes del builder per a les entitats referenciades en el DTO
				for (Method builderCallableMethod: builderReturnType.getDeclaredMethods()) {
					// Només es criden els mètodes amb un argument
					if (builderCallableMethod.getParameterTypes().length == 1) {
						// Només es criden els métodes que no son "embedded" i que no corresponen a un parent 
						boolean forbiddenMethod =
								embeddedMethod.equals(builderCallableMethod) ||
								(parent1Method != null && parent1Method.equals(builderCallableMethod)) ||
								(parent2Method != null && parent2Method.equals(builderCallableMethod));
						if (!forbiddenMethod) {
							Object id = null;
							for (Field field: getDtoClass().getDeclaredFields()) {
								if (field.getName().equals(builderCallableMethod.getName())) {
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
										builderCallableMethod.getParameterTypes()[0],
										id);
								builderCallableMethod.invoke(builderInstance, referencedEntity);
							}
						}
					}
				}
			}
			// Es crida el mètode build per a crear la instància de l'entitat
			Method buildMethod = builderReturnType.getMethod("build");
			return (E)buildMethod.invoke(builderInstance);
		} catch (Exception ex) {
			throw new RuntimeException("No s'ha pogut crear l'entitat de tipus " + getEntityClass(), ex);
		}
	}

	protected Page<D> findPageByRsqlQuery(
			Persistable<?> parent,
			String rsqlQuery,
			Pageable pageable) {
		Page<E> resultat;
		if (rsqlQuery != null) {
			Set<ComparisonOperator> operators = RSQLOperators.defaultOperators();
			operators.add(RsqlSearchOperation.EQUAL_IGNORE_CASE.getOperator());
			Node rootNode = new RSQLParser(operators).parse(rsqlQuery);
			Specification<E> spec = rootNode.accept(new CustomRsqlVisitor<E>());
			if (parent == null) {
				resultat = getRepository().findAll(spec, pageable);
			} else {
				@SuppressWarnings("serial")
				Specification<E> parentSpec = new Specification<E>() {
					public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						return cb.equal(root.get("parent"), parent);
					}
				};
				resultat = getRepository().findAll(spec.and(parentSpec), pageable);
			}
		} else {
			if (parent == null) {
				resultat = getRepository().findAll(pageable);
			} else {
				@SuppressWarnings("serial")
				Specification<E> parentSpec = new Specification<E>() {
					public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						return cb.equal(root.get("parent"), parent);
					}
				};
				resultat = getRepository().findAll(parentSpec, pageable);
			}
		}
		return toPaginaDto(resultat, pageable);
	}

	protected BaseRepository<E, ID> getRepository() {
		return repository;
	}

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

	@SuppressWarnings("unchecked")
	protected Class<P1> getParent1Class() {
		if (parent1Class == null && (isChildService() || isChildChildService())) {
			parent1Class = (Class<P1>)getClassFromGenericType(1);
		}
		return (Class<P1>)parent1Class;
	}
	@SuppressWarnings("unchecked")
	protected Class<P2> getParent2Class() {
		if (parent2Class == null && isChildChildService()) {
			parent2Class = (Class<P2>)getClassFromGenericType(2);
		}
		return (Class<P2>)parent2Class;
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getEntityClass() {
		if (entityClass == null) {
			if (isChildChildService()) {
				entityClass = (Class<E>)getClassFromGenericType(3);
			} else if (isChildService()) {
				entityClass = (Class<E>)getClassFromGenericType(2);
			} else {
				entityClass = (Class<E>)getClassFromGenericType(1);
			}
		}
		return (Class<E>)entityClass;
	}

	@SuppressWarnings("unchecked")
	protected Class<D> getDtoClass() {
		if (dtoClass == null) {
			dtoClass = (Class<D>)getClassFromGenericType(0);
		}
		return (Class<D>)dtoClass;
	}

	protected boolean isChildService() {
		return AbstractGenericChildServiceImpl.class.isAssignableFrom(getClass());
	}
	protected boolean isChildChildService() {
		return AbstractGenericChildChildServiceImpl.class.isAssignableFrom(getClass());
	}

	private Class<?> getClassFromGenericType(int index) {
		Type genericSuperClass = getClass().getGenericSuperclass();
		while (genericSuperClass != null && !(genericSuperClass instanceof ParameterizedType)) {
			genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
		}
		ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
		return (Class<?>)parameterizedType.getActualTypeArguments()[index];
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
							logger.error("Error al obtenir la referencia " + entityField.getName() + " de l'entitat " + entity, ex);
						}
						if (referencedEntity != null) {
							String setMethodName = "set" + entityField.getName().substring(0, 1).toUpperCase() + entityField.getName().substring(1);
							if (dtoField.getType().isAssignableFrom(GenericReference.class)) {
								@SuppressWarnings("rawtypes")
								GenericReference reference = new GenericReference(referencedEntity.getId(), null);
								try {
									getDtoClass().getMethod(setMethodName, GenericReference.class).invoke(dto, reference);
								} catch (Exception ex) {
									logger.error("Error al modificar el camp al dto (" +
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
									logger.error("Error al modificar el camp al dto (" +
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
	/*@SuppressWarnings("unchecked")
	protected void saveAndRefresh(E entity, JpaRepository<E, ?> repository) {
		repository.saveAndFlush(entity);
		if (repository instanceof RefreshableRepository) {
			((RefreshableRepository<E>)repository).refresh(entity);
		}
	}*/

	protected void beforeCreate(E entity, D dto) {}
	protected void afterCreate(E entity, D dto) {}
	protected void beforeUpdate(E entity, D dto) {}
	protected void afterUpdate(E entity, D dto) {}
	protected void beforeDelete(E entity) {}
	protected void afterDelete(E entity) {}

	private static final Logger logger = LoggerFactory.getLogger(AbstractServiceImpl.class);

}
