/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació per a sincronitzar una empresa de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@NoArgsConstructor
public class SincronitzacioEmpresa {

	public SincronitzacioEmpresa(
			@NotNull @Size(max = 4) String codi,
			@NotNull @Size(max = 12) String nif,
			@NotNull @Size(max = 30) String nom) {
		super();
		this.codi = codi;
		this.nif = nif;
		this.nom = nom;
	}

	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 12)
	private String nif;
	@NotNull
	@Size(max = 30)
	private String nom;
	private List<SincronitzacioEmpresaUsuari> usuaris;
	private List<SincronitzacioEmpresaOperari> operaris;

}
