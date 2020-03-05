/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.Funcionalitat;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;
import es.limit.cecocloud.logic.api.module.Modul;

/**
 * Servei encarregat de gestionar relacions (usuari-identificador)-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariIdentificadorEmpresaService extends GenericService<UsuariIdentificadorEmpresa, Long> {

	/**
	 * Retorna la llista de perfils d'un usuari per empresa.
	 * 
	 * @return els nodes de l'arbre.
	 */
	public List<UsuariIdentificadorEmpresaPerfilTreeItem> buildPerfilTree();
	
	/**
	 * Retorna l'arbre per a la selecció de identificador / empresa.
	 * 
	 * @return els nodes de l'arbre.
	 */
	public List<IdentificadorEmpresaSelectionTreeItem> buildSelectionTree();
	
	/**
	 * Retorna una llista dels codis de les funcionalitats a les que té accés l'{@link UsuariIdentificadorEmpresa} donat un mòdul
	 *  
	 * @param modul Mòdul del que es volen consultar les funcionalitats disponibles
	 * @return els codis de les funcionalitats disponibles
	 */
	public List<String> findAllowedFuncionalitatsByModul(Modul modul);
	
	/**
	 * Retorna una llista de les funcionalitats a les que té accés l'{@link UsuariIdentificadorEmpresa}
	 *  
	 * @return les funcionalitats disponibles
	 */
	public List<Funcionalitat> findAllowedFuncionalitats();

}
