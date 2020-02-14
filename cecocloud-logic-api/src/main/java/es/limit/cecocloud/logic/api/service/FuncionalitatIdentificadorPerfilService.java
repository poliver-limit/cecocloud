/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import es.limit.cecocloud.logic.api.dto.FuncionalitatInfo;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;
import es.limit.cecocloud.logic.api.module.Modul;

/**
 * Servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorPerfilService extends GenericService<FuncionalitatIdentificadorPerfil, Long> {

	List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilOrderByModule(Long perfilId);
	List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId);
	void savePermisos(Long perfilId, FuncionalitatInfo funcionalitat) throws Exception;
	void refreshPermisos(Long perfilId) throws Exception;
	List<String> findAllowedFuncionalitatsByModul(Modul modul);

}
