/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

/**
 * Informació d'un mòdul.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class ModuleInfo {

	private String code;
	private String dtoPackage;

	public ModuleInfo(
			String code,
			String dtoPackage) {
		super();
		this.code = code;
		this.dtoPackage = dtoPackage;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDtoPackage() {
		return dtoPackage;
	}
	public void setDtoPackage(String dtoPackage) {
		this.dtoPackage = dtoPackage;
	}

}
