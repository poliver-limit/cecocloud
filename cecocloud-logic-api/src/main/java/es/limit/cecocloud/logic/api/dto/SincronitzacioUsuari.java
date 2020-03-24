/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació per a sincronitzar un usuari de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SincronitzacioUsuari {

	@NotNull
	@Size(max = 100)
	private String usuariCodi;

}
