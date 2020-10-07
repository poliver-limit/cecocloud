/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador de categoria traduccio
 * 
 * @author Limit Tecnologies
 */
@Documented
@Constraint(validatedBy = CategoriaTraduccioNotExistsValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaTraduccioNotExists {

	String message() default "{cecocloud.validation.constraints.CategoriaTraduccio}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	String [] fields();

}
