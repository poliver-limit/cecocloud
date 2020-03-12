/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'una branca de l'arbre de selecció d'identificadors / empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@NoArgsConstructor
public class IdentificadorEmpresaSelectionTreeItem extends AbstractIdentificable<Long> {

	private String codi;
	private String descripcio;
	private boolean hasAdminPermission;
	private List<Empresa> empreses;

	public IdentificadorEmpresaSelectionTreeItem(
			Long id,
			String codi,
			String descripcio,
			boolean hasAdminPermission,
			List<Empresa> empreses) {
		super();
		this.id = id;
		this.codi = codi;
		this.descripcio = descripcio;
		this.hasAdminPermission = hasAdminPermission;
		this.empreses = empreses;
	}

}
