package es.limit.cecocloud.logic.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotació per a configurar un recurs de cecocloud.
 * 
 * @author Limit Tecnologies
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CecocloudResource {

	public Class<? extends FuncionalitatCodiFont>[] funcionalitatPrincipal() default {};
	public Class<? extends FuncionalitatCodiFont>[] funcionalitatSecundaria() default {};

}
