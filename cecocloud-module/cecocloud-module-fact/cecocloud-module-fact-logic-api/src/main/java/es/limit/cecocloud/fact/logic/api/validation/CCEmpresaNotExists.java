/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador EmpresaNotExists
 * 
 * @author Limit Tecnologies
 */
@Documented
@Constraint(validatedBy = CCEmpresaNotExistsValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CCEmpresaNotExists {

	String message() default "{cecocloud.validation.constraints.ccEmpresaNotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String field();

}
