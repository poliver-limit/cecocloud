/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una branca de l'arbre de companyies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class CompanyiaSelectionTreeItem extends Companyia {

	private boolean hasAdminPermission;
	private List<Empresa> empreses;

}
