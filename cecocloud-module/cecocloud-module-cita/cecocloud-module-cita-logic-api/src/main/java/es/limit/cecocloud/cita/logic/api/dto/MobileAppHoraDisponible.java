/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una hora disponible per a cites.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppHoraDisponible {

	private LocalTime hora;
	private int duradaEnMinuts;
	private int places;

}
