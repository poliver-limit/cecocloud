/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.Date;

import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.DiaSetmana;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un interval horari per a un punt de venda per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppHorari {

	private DiaSetmana diaSetmana;
	private Date horaInici;
	private Date horaFi;

}
