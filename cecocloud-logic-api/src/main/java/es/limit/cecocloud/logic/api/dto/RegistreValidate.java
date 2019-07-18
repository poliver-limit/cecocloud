/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a validar un usuari registrat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class RegistreValidate {

	@NotNull
	private String token;
	@NotNull
	private String contrasenya;
	@NotNull
	private String repeticio;

}
