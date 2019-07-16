/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

/**
 * Informació sobre el formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProfileForm {

	private String name;
	private String translateKey;
	private String translateKeyPlural;
	private String apiUrl;
	private String descriptionField;
	List<ProfileField> fields;
	List<ProfileGrid> grids;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTranslateKey() {
		return translateKey;
	}
	public void setTranslateKey(String translateKey) {
		this.translateKey = translateKey;
	}
	public String getTranslateKeyPlural() {
		return translateKeyPlural;
	}
	public void setTranslateKeyPlural(String translateKeyPlural) {
		this.translateKeyPlural = translateKeyPlural;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getDescriptionField() {
		return descriptionField;
	}
	public void setDescriptionField(String descriptionField) {
		this.descriptionField = descriptionField;
	}
	public List<ProfileField> getFields() {
		return fields;
	}
	public void setFields(List<ProfileField> fields) {
		this.fields = fields;
	}
	public List<ProfileGrid> getGrids() {
		return grids;
	}
	public void setGrids(List<ProfileGrid> grids) {
		this.grids = grids;
	}

}
