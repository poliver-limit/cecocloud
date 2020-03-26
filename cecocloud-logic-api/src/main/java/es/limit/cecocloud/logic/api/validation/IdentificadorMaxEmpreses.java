/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador del màxim d'empreses d'un identificador.
 * 
 * @author Limit Tecnologies
 */
@Documented
@Constraint(validatedBy = IdentificadorMaxEmpresesValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentificadorMaxEmpreses {

	String message() default "{cecocloud.validation.constraints.IdentificadorMaxEmpreses}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}