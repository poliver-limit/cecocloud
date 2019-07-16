/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

/**
 * Informació sobre un camp que pertany al formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProfileField {

	private String name;
	private RestapiFieldType type;
	private String translateKey;
	private boolean required;
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
	private String lovResource;
	private String lovModule;
	private String lovParentField;
	private boolean lovWithDescriptionInput;
	private String lovDescriptionField;
	private boolean includeInQuickFilter;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RestapiFieldType getType() {
		return type;
	}
	public void setType(RestapiFieldType type) {
		this.type = type;
	}
	public String getTranslateKey() {
		return translateKey;
	}
	public void setTranslateKey(String translateKey) {
		this.translateKey = translateKey;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	public Integer getDecimalMinLength() {
		return decimalMinLength;
	}
	public void setDecimalMinLength(Integer decimalMinLength) {
		this.decimalMinLength = decimalMinLength;
	}
	public Integer getDecimalMaxLength() {
		return decimalMaxLength;
	}
	public void setDecimalMaxLength(Integer decimalMaxLength) {
		this.decimalMaxLength = decimalMaxLength;
	}
	public boolean isDisabledForCreate() {
		return disabledForCreate;
	}
	public void setDisabledForCreate(boolean disabledForCreate) {
		this.disabledForCreate = disabledForCreate;
	}
	public boolean isDisabledForUpdate() {
		return disabledForUpdate;
	}
	public void setDisabledForUpdate(boolean disabledForUpdate) {
		this.disabledForUpdate = disabledForUpdate;
	}
	public boolean isHiddenInGrid() {
		return hiddenInGrid;
	}
	public void setHiddenInGrid(boolean hiddenInGrid) {
		this.hiddenInGrid = hiddenInGrid;
	}
	public boolean isHiddenInForm() {
		return hiddenInForm;
	}
	public void setHiddenInForm(boolean hiddenInForm) {
		this.hiddenInForm = hiddenInForm;
	}
	public boolean isHiddenInLov() {
		return hiddenInLov;
	}
	public void setHiddenInLov(boolean hiddenInLov) {
		this.hiddenInLov = hiddenInLov;
	}
	public boolean isToUpperCase() {
		return toUpperCase;
	}
	public void setToUpperCase(boolean toUpperCase) {
		this.toUpperCase = toUpperCase;
	}
	public Object[] getEnumValues() {
		return enumValues;
	}
	public void setEnumValues(Object[] enumValues) {
		this.enumValues = enumValues;
	}
	public String[] getEnumDescriptions() {
		return enumDescriptions;
	}
	public void setEnumDescriptions(String[] enumDescriptions) {
		this.enumDescriptions = enumDescriptions;
	}
	public String getLovResource() {
		return lovResource;
	}
	public void setLovResource(String lovResource) {
		this.lovResource = lovResource;
	}
	public String getLovModule() {
		return lovModule;
	}
	public void setLovModule(String lovModule) {
		this.lovModule = lovModule;
	}
	public String getLovParentField() {
		return lovParentField;
	}
	public void setLovParentField(String lovParentField) {
		this.lovParentField = lovParentField;
	}
	public boolean isLovWithDescriptionInput() {
		return lovWithDescriptionInput;
	}
	public void setLovWithDescriptionInput(boolean lovWithDescriptionInput) {
		this.lovWithDescriptionInput = lovWithDescriptionInput;
	}
	public String getLovDescriptionField() {
		return lovDescriptionField;
	}
	public void setLovDescriptionField(String lovDescriptionField) {
		this.lovDescriptionField = lovDescriptionField;
	}
	public boolean isIncludeInQuickFilter() {
		return includeInQuickFilter;
	}
	public void setIncludeInQuickFilter(boolean includeInQuickFilter) {
		this.includeInQuickFilter = includeInQuickFilter;
	}

	public static enum RestapiFieldType {
		AUTO,
		STRING,
		INTEGER,
		FLOAT,
		BOOLEAN,
		DATE,
		BIGDECIMAL,
		TEXTAREA,
		PASSWORD,
		ENUM,
		LOV
	}

}
