/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un punt de venda d'una empresa per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppPuntVenda {

	private String codi;
	private String nom;
	private List<MobileAppHorari> horari;

}
