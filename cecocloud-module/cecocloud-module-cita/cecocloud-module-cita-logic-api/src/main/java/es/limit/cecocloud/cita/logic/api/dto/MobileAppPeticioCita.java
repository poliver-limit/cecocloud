/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició de creació de cita enviada des de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticioCita extends MobileAppPeticio {

	@NotNull
	@Valid
	private MobileAppCita cita;

}
