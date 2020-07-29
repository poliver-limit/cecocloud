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
 * Anotació pel validador de l'adreça IP des de la qual es fa el marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Documented
@Constraint(validatedBy = MarcatgeAdressaIpAutoritzadaValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MarcatgeAdressaIpAutoritzada {

	String message() default "{cecocloud.validation.constraints.MarcatgeAdressaIpAutoritzada}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
