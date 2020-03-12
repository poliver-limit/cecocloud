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
public class UsuariIdentificadorEmpresaPerfilTreeItem extends AbstractIdentificable<Long> {

	private String codi;
	private String nom;
	private List<Long> perfils;

	public UsuariIdentificadorEmpresaPerfilTreeItem(
			Long id,
			String codi,
			String nom,
			List<Long> perfils) {
		super();
		this.id = id;
		this.codi = codi;
		this.nom = nom;
		this.perfils = perfils;
	}
	
}
