/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar una empresa de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioEmpresa {

	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 12)
	private String nif;
	@NotNull
	@Size(max = 30)
	private String nom;
	private List<SincronitzacioEmpresaOperari> operaris;

}
