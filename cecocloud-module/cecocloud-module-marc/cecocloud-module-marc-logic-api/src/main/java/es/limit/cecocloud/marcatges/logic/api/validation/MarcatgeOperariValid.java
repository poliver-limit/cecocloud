/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador dels operaris dels marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Documented
@Constraint(validatedBy = MarcatgeOperariValidValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MarcatgeOperariValid {

	String message() default "{cecocloud.validation.constraints.MarcatgeOperariValid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
