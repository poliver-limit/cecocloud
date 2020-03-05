/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;

/**
 * Servei encarregat de gestionar relacions funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorPerfilService extends GenericService<FuncionalitatIdentificadorPerfil, Long> {

	/*List<FuncionalitatPermisModule> findAllFuncionalitatsByPerfilOrderByModule(Long perfilId);
	List<FuncionalitatPermisModule> findAllFuncionalitatsByPerfilsOrderByModule(List<Long> perfilsId);
	void savePermisos(Long perfilId, FuncionalitatPermis funcionalitat, String modulCodi) throws Exception;
	void refreshPermisos(Long perfilId) throws Exception;
	List<String> findAllowedFuncionalitatsByModul(Modul modul);*/

}
