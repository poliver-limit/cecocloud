/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericServiceWithPermissions;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.IdentificadorEmpresaSelectionTreeItem;

/**
 * Servei encarregat de gestionar identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificadorService extends GenericServiceWithPermissions<Identificador, Long> {

	/**
	 * Retorna l'arbre per a la selecció de companyia / empresa.
	 * 
	 * @return els nodes de l'arbre.
	 */
	public List<IdentificadorEmpresaSelectionTreeItem> buildSelectionTree();

}
