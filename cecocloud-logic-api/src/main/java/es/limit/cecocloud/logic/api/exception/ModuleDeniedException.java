/**
 * 
 */
package es.limit.cecocloud.logic.api.exception;

/**
 * Excepció que es llança quan l'usuari no te permisos per accedir a un mòdul.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
public class ModuleDeniedException extends RuntimeException {

	private String userName;
	private String companyName;
	private String moduleName;
	
	public ModuleDeniedException(String moduleName) {
		super(getExceptionMessage(
				null,
				null,
				moduleName));
		this.moduleName = moduleName;
	}
	
	public ModuleDeniedException(
			String userName,
			String moduleName) {
		super(getExceptionMessage(
				userName,
				null,
				moduleName));
		this.userName = userName;
		this.moduleName = moduleName;
	}
			
	public ModuleDeniedException(
			String userName,
			String companyName,
			String moduleName) {
		super(getExceptionMessage(
				userName,
				companyName,
				moduleName));
		this.userName = userName;
		this.companyName = companyName; 
		this.moduleName = moduleName;
	}

	public String getCompanyName() {
		return companyName;
	}
	public String getUserName() {
		return userName;
	}
	public String getModuleName() {
		return moduleName;
	}

	public static String getExceptionMessage(
			String userName,
			String companyName,
			String moduleName) {
		StringBuilder sb = new StringBuilder();
		if (userName == null) {
			sb.append("Can't accés the module '");
			sb.append(moduleName);
			sb.append("' without authentication'");
		} else if (companyName == null) {
			sb.append("User '");
			sb.append(userName);
			sb.append("' can't accés the module '");
			sb.append(moduleName);
			sb.append("' without a company'");
		} else {
			sb.append("User '");
			sb.append(userName);
			sb.append("' in company '");
			sb.append(companyName);
			sb.append("' can't acces the module '");
			sb.append(moduleName);
			sb.append("'.");
		}
		return sb.toString();
	}

}
