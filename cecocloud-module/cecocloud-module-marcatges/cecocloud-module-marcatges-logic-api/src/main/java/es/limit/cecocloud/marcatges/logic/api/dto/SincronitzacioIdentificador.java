/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar un identificador de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioIdentificador {

	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 40)
	private String nom;

}
