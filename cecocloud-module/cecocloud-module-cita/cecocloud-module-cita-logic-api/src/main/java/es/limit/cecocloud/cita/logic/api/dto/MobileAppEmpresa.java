/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MobileAppEmpresa {

	private String identificadorCodi;
	private String codi;
	private String nom;
	private String nif;
	private List<MobileAppPuntVenda> puntsVenda;

}
