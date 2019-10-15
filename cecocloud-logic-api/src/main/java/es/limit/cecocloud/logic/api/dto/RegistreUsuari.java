/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.validation.UsuariEmailNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a registrar un usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@UsuariEmailNotExists
public class RegistreUsuari {

	@NotEmpty
	@Size(max = 100)
	private String nom;
	@NotEmpty
	@Size(max = 100)
	private String email;

}
