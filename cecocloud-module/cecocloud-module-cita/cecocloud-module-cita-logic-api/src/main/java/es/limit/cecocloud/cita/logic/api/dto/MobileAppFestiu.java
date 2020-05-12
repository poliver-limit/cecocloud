/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.Date;
import java.util.List;

import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.DiaSetmana;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un festiu per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppFestiu {

	private List<DiaSetmana> diesSetmana;
	private Date horaInici;
	private Date horaFi;

}
