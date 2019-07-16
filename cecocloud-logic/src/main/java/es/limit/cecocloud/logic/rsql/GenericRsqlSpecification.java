/**
 * 
 */
package es.limit.cecocloud.logic.rsql;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;

/**
 * 
 * 
 * @author josepg
 */
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
		final List<Object> args = castArguments(root);
		final Object argument = args.get(0);
		Path<?> path = ("id".equals(property)) ? root.get(property) : root.get("embedded").get(property);
		//Path<String> path = root.<String>get(property);
		switch (RsqlSearchOperation.getSimpleOperator(operator)) {
		case EQUAL:
			if (argument instanceof String) {
				return builder.like((Path<String>)path, argument.toString().replace('*', '%'));
			} else if (argument == null) {
				return builder.isNull(path);
			} else {
				return builder.equal(path, argument);
			}
		case NOT_EQUAL:
			if (argument instanceof String) {
				return builder.notLike((Path<String>)path, argument.toString().replace('*', '%'));
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
				return builder.like(builder.lower((Path<String>)path), argument.toString().replace('*', '%'));
			} else if (argument == null) {
				return builder.isNull(path);
			} else {
				return builder.equal(path, argument);
			}
		}
		return null;
	}

	private List<Object> castArguments(final Root<T> root) {
		Path<?> path = ("id".equals(property)) ? root.get(property) : root.get("embedded").get(property);
		final Class<? extends Object> type = path.getJavaType();
		final List<Object> args = arguments.stream().map(arg -> {
			if (type.equals(Integer.class)) {
				return Integer.parseInt(arg);
			} else if (type.equals(Long.class)) {
				return Long.parseLong(arg);
			} else {
				return arg;
			}
		}).collect(Collectors.toList());
		return args;
	}

}
