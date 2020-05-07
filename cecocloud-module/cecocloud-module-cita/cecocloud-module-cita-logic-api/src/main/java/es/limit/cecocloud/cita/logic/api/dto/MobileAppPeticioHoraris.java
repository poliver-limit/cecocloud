/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició d'horari enviada des de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticioHoraris extends MobileAppPeticio {

	@NotNull
	private LocalDate data;

}
