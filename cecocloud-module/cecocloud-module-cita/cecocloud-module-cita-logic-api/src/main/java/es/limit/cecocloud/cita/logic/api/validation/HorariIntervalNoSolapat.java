/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.validation;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotació pel validador del solapament amb altres intervals horaris.
 * 
 * @author Limit Tecnologies
 */
@Documented
@Constraint(validatedBy = HorariIntervalNoSolapatValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HorariIntervalNoSolapat {

	String message() default "{cecocloud.validation.constraints.HorariIntervalNoSolapat}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
