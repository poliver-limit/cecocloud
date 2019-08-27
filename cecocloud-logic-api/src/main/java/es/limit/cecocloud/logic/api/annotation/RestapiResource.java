package es.limit.cecocloud.logic.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotació per a configurar el comportament del camp al grid i al formulari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestapiResource {

	public String descriptionField() default "";
	public RestapiGrid[] grids() default {};

}
