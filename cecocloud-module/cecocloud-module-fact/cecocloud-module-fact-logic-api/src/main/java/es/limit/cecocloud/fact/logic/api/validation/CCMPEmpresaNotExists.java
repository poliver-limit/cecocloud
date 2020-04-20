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
@Constraint(validatedBy = CCMPEmpresaNotExistsValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CCMPEmpresaNotExists {

	String message() default "{cecocloud.validation.constraints.ccmpEmpresaNotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String field();

}
