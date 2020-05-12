/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició d'anul·lació de cita enviada des de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticioAnulacio extends MobileAppPeticio {

	@NotNull
	private String codi;

}
