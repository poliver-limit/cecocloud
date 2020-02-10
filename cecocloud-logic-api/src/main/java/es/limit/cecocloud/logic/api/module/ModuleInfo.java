/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.List;

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

	private Modul modul;
	private List<FuncionalitatCodiFont> funcionalitats;
	private Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass;

	public ModuleInfo(
			Modul modul,
			String dtoPackage) {
		super(modul.name(), dtoPackage);
	}

	public ModuleInfo(
			Modul modul,
			String dtoPackage,
			Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass,
			List<FuncionalitatCodiFont> funcionalitats) {
		super(modul.name(), dtoPackage);
		this.empresaIdentificadorSyncServiceClass = empresaIdentificadorSyncServiceClass;
		this.funcionalitats = funcionalitats;
	}

}
