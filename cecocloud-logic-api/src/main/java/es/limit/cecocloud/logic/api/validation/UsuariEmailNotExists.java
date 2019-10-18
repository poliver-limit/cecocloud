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
 * Anotació pel validador del correu-e de l'usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Documented
@Constraint(validatedBy = { UsuariEmailNotExistsValidator.class, RegistreUsuariEmailNotExistsValidator.class})
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UsuariEmailNotExists {

	String message() default "{cecocloud.validation.constraints.UsuariEmailNotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
