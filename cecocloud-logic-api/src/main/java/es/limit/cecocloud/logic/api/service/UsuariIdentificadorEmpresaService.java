/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericService;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresaPerfilTreeItem;

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

}
