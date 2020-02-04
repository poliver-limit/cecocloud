/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class EmpresaMobil {

	private Long id;
	private String codi;
	private String nif;
	private String nom;

}
