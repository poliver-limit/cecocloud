/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a sincronitzar una empresa de CECOGEST del mòdul marcatges.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioEmpresa extends es.limit.cecocloud.logic.api.dto.SincronitzacioEmpresa {

	@NotNull
	private String identificadorCodi;

}
