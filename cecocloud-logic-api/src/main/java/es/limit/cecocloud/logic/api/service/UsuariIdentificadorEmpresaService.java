/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;

/**
 * Servei encarregat de gestionar les relacions (usuari-identificador)-empresa
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariIdentificadorEmpresaService extends GenericCompositePkService<UsuariIdentificadorEmpresa> {

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

}
