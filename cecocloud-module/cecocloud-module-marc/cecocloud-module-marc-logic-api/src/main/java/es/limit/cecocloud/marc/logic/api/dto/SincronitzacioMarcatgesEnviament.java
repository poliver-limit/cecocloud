/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a l'enviament dels marcatges fets a CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatgesEnviament {

	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	private List<SincronitzacioMarcatge> marcatges;

}
