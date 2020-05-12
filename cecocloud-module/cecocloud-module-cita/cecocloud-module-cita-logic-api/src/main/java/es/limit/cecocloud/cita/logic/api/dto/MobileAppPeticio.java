/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició a l'API de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticio {

	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	@NotNull
	@Size(max = 4)
	private String empresaCodi;
	@NotNull
	@Size(max = 4)
	private String puntVendaCodi;

}
