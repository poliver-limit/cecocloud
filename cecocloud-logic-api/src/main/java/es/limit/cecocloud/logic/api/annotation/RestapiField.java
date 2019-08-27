package es.limit.cecocloud.logic.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;

/**
 * Anotació per a configurar el comportament del camp al grid i al formulari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RestapiField {

	public RestapiFieldType value() default RestapiFieldType.AUTO;
	public RestapiFieldType type() default RestapiFieldType.AUTO;
	public boolean disabledForCreate() default false;
	public boolean disabledForUpdate() default false;
	public boolean hiddenInGrid() default false;
	public boolean hiddenInForm() default false;
	public boolean hiddenInLov() default false;
	public int sizeMin() default 0;
	public int sizeMax() default Integer.MAX_VALUE;
	public boolean toUpperCase() default false;
	public boolean lovWithDescriptionInput() default false;
	public String lovParentField() default "";
	public String lovModule() default "";
	public boolean includeInQuickFilter() default false;

}
