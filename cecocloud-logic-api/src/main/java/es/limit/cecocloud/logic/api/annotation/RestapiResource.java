package es.limit.cecocloud.logic.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import es.limit.cecocloud.logic.api.dto.Rol;

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
	public boolean restrictedToAuthorities() default true;
	public Rol[] authoritiesWithCreatePermission() default {};
	public Rol[] authoritiesWithReadPermission() default {};
	public Rol[] authoritiesWithUpdatePermission() default {};
	public Rol[] authoritiesWithDeletePermission() default {};
	public Rol[] authoritiesWithAdminPermission() default {};
	//public boolean restrictedToRoles() default false;

}
