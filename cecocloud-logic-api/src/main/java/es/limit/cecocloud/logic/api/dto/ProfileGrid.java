/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

/**
 * Informació sobre un grid del formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ProfileGrid {

	private String name;
	private String translateKey;
	private String resourceName;

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
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
