/**
 * 
 */
package es.limit.cecocloud.logic.rsql;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.Specification;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import es.limit.cecocloud.persist.entity.AbstractEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@SuppressWarnings("serial")
public class GenericRsqlSpecification<T> implements Specification<T> {

	private String property;
	private ComparisonOperator operator;
	private List<String> arguments;

	public GenericRsqlSpecification(final String property, final ComparisonOperator operator, final List<String> arguments) {
		super();
		this.property = property;
		this.operator = operator;
		this.arguments = arguments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Predicate toPredicate(final Root<T> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
		log.debug("Creant predicate (" +
				"property=" + property + ", " +
				"operator=" + operator + ", " +
				"arguments=" + arguments + ")");
		Path<?> path;
		if ("id".equals(property)) {
			path = root.get(property);
		} else if (property.contains(".")) {
			String[] pathElements = property.split("\\.");
			path = root;
			for (int i = 0; i < pathElements.length; i++) {
				String pathElement = pathElements[i];
				if (i == pathElements.length - 1 && !"id".equals(pathElement)) {
					path = path.get("embedded");
				}
				if (!pathElement.trim().isEmpty()) {
					path = path.get(pathElement);
				}
			}
		} else {
			path = root.get("embedded").get(property);
		}
		final List<Object> args = castArguments(path);
		final Object argument = args.get(0);
		switch (RsqlSearchOperation.getSimpleOperator(operator)) {
		case EQUAL:
			if (argument instanceof String) {
				if (argument.toString().contains("*")) {
					return builder.like((Path<String>)path, argument.toString().replace('*', '%'));
				} else {
					return builder.equal((Path<String>)path, argument.toString());
				}
			} else if (argument == null) {
				return builder.isNull(path);
			} else {
				return builder.equal(path, argument);
			}
		case NOT_EQUAL:
			if (argument instanceof String) {
				if (argument.toString().contains("*")) {
					return builder.notLike((Path<String>)path, argument.toString().replace('*', '%'));
				} else {
					return builder.notEqual((Path<String>)path, argument.toString());
				}
			} else if (argument == null) {
				return builder.isNotNull(path);
			} else {
				return builder.notEqual(path, argument);
			}
		case GREATER_THAN:
			return builder.greaterThan((Path<String>)path, argument.toString());
		case GREATER_THAN_OR_EQUAL:
			return builder.greaterThanOrEqualTo((Path<String>)path, argument.toString());
		case LESS_THAN:
			return builder.lessThan((Path<String>)path, argument.toString());
		case LESS_THAN_OR_EQUAL:
			return builder.lessThanOrEqualTo((Path<String>)path, argument.toString());
		case IN:
			return path.in(args);
		case NOT_IN:
			return builder.not(path.in(args));
		case EQUAL_IGNORE_CASE:
			if (argument instanceof String) {
				if (argument.toString().contains("*")) {
					return builder.like(builder.lower((Path<String>)path), argument.toString().toLowerCase().replace('*', '%'));
				} else {
					return builder.equal(builder.lower((Path<String>)path), argument.toString().toLowerCase());
				}
			} else if (argument == null) {
				return builder.isNull(path);
			} else {
				return builder.equal(path, argument);
			}
		}
		return null;
	}

	private List<Object> castArguments(Path<?> path) {
		final Class<?> attributeType;
		final String attributeName = ((javax.persistence.metamodel.SingularAttribute<?, ?>)path.getModel()).getName();
		if ("id".equals(attributeName)) {
			@SuppressWarnings("unchecked")
			Class<? extends AbstractPersistable<?>> parentType = ((Path<? extends AbstractPersistable<?>>)path.getParentPath()).getJavaType();
			ParameterizedType parameterizedType = (ParameterizedType)parentType.getGenericSuperclass();
			if (parameterizedType != null) {
				if (parameterizedType.getRawType().equals(AbstractEntity.class)) {
					attributeType = (Class<?>)parameterizedType.getActualTypeArguments()[1];
				} else if (parameterizedType.getRawType().equals(AbstractPersistable.class)) {
					attributeType = (Class<?>)parameterizedType.getActualTypeArguments()[0];
				} else {
					attributeType = path.getJavaType();
				}
			} else {
				attributeType = path.getJavaType();
			}
		} else {
			attributeType = path.getJavaType();
		}
		final List<Object> args = arguments.stream().map(arg -> {
			if (attributeType.equals(Integer.class)) {
				return Integer.parseInt(arg);
			} else if (attributeType.equals(Long.class)) {
				return Long.parseLong(arg);
			} else {
				return arg;
			}
		}).collect(Collectors.toList());
		return args;
	}

}
