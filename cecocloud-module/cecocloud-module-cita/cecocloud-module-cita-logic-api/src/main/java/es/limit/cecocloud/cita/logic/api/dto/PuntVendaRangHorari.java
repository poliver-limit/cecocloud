/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació sobre el rang horari d'un punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class PuntVendaRangHorari {

	private LocalTime horaInici;
	private LocalTime horaFi;

}
