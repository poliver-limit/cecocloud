/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una branca de l'arbre de selecció d'identificadors / empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class IdentificadorEmpresaSelectionTreeItem extends GenericReference<AbstractIdentificable<Long>, Long> {

	private boolean hasAdminPermission;
	private List<Empresa> empreses;

}
