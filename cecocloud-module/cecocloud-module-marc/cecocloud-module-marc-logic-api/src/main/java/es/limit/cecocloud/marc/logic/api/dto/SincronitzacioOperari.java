/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar un operari de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioOperari {

	@NotNull
	@Size(max = 4)
	private String empresaCodi;
	@NotNull
	@Size(max = 6)
	private String codi;
	@NotNull
	@Size(max = 100)
	private String usuariCodi;

}
