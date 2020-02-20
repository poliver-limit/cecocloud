/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar un usuari de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioUsuari {

	@NotNull
	@Size(max = 100)
	private String usuariCodi;

}
