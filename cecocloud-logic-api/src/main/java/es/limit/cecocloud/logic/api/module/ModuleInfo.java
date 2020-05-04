/**
 * 
 */
package es.limit.cecocloud.logic.api.module;

import java.util.Map;

import es.limit.cecocloud.logic.api.service.DatabaseSyncService;
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
	private Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass;
	private Class<? extends DatabaseSyncService> databaseSyncServiceClass;
	private Map<String, FuncionalitatCodiFont> funcionalitats;

	public ModuleInfo(
			Modul modul,
			String dtoPackage) {
		super(modul.name(), dtoPackage);
		this.modul = modul;
	}

	public ModuleInfo(
			Modul modul,
			String dtoPackage,
			Class<? extends EmpresaIdentificadorSyncService> empresaIdentificadorSyncServiceClass,
			Class<? extends DatabaseSyncService> databaseSyncServiceClass,
			Map<String, FuncionalitatCodiFont> funcionalitats) {
		super(modul.name(), dtoPackage);
		this.modul = modul;
		this.empresaIdentificadorSyncServiceClass = empresaIdentificadorSyncServiceClass;
		this.databaseSyncServiceClass = databaseSyncServiceClass;
		this.funcionalitats = funcionalitats;
	}

}
