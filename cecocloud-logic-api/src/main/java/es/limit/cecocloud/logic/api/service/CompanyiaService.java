/**
 * 
 */
package es.limit.cecocloud.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericServiceWithPermissions;
import es.limit.cecocloud.logic.api.dto.Companyia;
import es.limit.cecocloud.logic.api.dto.CompanyiaSelectionTreeItem;

/**
 * Servei encarregat de gestionar companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CompanyiaService extends GenericServiceWithPermissions<Companyia, Long> {

	/**
	 * Retorna l'arbre per a la selecció de companyia / empresa.
	 * 
	 * @return els nodes de l'arbre.
	 */
	public List<CompanyiaSelectionTreeItem> buildSelectionTree();

}
