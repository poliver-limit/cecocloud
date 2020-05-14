/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una petició de disponibilitat d'hores per a cites enviada des
 * de l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPeticioDisponibilitat extends MobileAppPeticio {

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate data;

}
