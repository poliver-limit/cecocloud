/**
 * 
 */
package es.limit.cecocloud.logic.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotació per a configurar un grid associat a un formulari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestapiGrid {

	public String name() default "";
	public String value();

}
