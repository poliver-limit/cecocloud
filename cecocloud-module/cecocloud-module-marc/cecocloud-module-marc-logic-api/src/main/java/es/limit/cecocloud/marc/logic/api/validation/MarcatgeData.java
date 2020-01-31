/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador de la data del marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Documented
@Constraint(validatedBy = MarcatgeDataValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MarcatgeData {

	String message() default "{cecocloud.validation.constraints.MarcatgeData}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
