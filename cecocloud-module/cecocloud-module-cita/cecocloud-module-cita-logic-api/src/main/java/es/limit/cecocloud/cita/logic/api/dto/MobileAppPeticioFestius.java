/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició de festius enviada des de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticioFestius extends MobileAppPeticio {

	@NotNull
	private Integer any;

}
