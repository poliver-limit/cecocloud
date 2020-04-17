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
 * Anotació pel validador de número Iban bancari
 * 
 * @author Limit Tecnologies
 */
@Documented
@Constraint(validatedBy = IbanValidator.class)
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Iban {

	String message() default "{cecocloud.validation.constraints.Iban}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
//	String paisIban();
//	String dcIban();
//	String banc();
//	String oficina();
//	String dc();
//	String cc();
	
	String [] fields();

}
