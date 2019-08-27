/**
 * 
 */
package es.limit.cecocloud.logic.api.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

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
@Target({ METHOD, FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MarcatgeOperariValidConstraint {
	String message() default "Invalid operari";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
