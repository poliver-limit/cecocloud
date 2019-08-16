/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació sobre un camp que pertany al formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class ProfileResourceField {

	private String name;
	private RestapiFieldType type;
	private String translateKey;
	private boolean required;
	private boolean multiple;
	private Integer minLength;
	private Integer maxLength;
	private Integer decimalMinLength;
	private Integer decimalMaxLength;
	private boolean disabledForCreate;
	private boolean disabledForUpdate;
	private boolean hiddenInGrid;
	private boolean hiddenInForm;
	private boolean hiddenInLov;
	private boolean toUpperCase;
	private Object[] enumValues;
	private String[] enumDescriptions;
	private String lovResourceName;
	private String lovParentField;
	private boolean lovWithDescriptionInput;
	private String lovDescriptionField;
	private boolean includeInQuickFilter;

	public static enum RestapiFieldType {
		AUTO,
		STRING,
		INTEGER,
		FLOAT,
		BOOLEAN,
		DATE,
		DATETIME,
		BIGDECIMAL,
		TEXTAREA,
		PASSWORD,
		ENUM,
		LOV
	}

}
