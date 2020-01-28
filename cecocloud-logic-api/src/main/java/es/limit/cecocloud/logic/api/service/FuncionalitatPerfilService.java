/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import es.limit.cecocloud.logic.api.dto.ModuleFuncionalitatInfo;

/**
 * Servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatPerfilService extends GenericService<FuncionalitatPerfil, Long> {

	List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId);
	List<ModuleFuncionalitatInfo> findAllFuncionalitatsByPerfilOrderByModule(Long perfilId);

}
