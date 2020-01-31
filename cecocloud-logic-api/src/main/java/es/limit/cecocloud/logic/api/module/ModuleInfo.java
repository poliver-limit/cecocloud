/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import es.limit.cecocloud.logic.api.service.EmpresaIdentificadorSyncService;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un mòdul de Cecocloud.
 * 
 * @author Limit Tecnologies
 */
@Getter @Setter
public class ModuleInfo extends es.limit.base.boot.logic.api.module.ModuleInfo {

	private Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass;

	public ModuleInfo(
			String code,
			String dtoPackage) {
		super(code, dtoPackage);
	}

	public ModuleInfo(
			String code,
			String dtoPackage,
			Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass) {
		super(code, dtoPackage);
		this.empresaIdentificadorSyncServiceClass = empresaIdentificadorSyncServiceClass;
	}

}
