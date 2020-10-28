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
 * Informació per a consultar els marcatges des de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatgesUpdateTraspassat {

	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	@NotNull
	@Size(max = 4)
	private String empresaCodi;
	private List<Long> ids;

}
