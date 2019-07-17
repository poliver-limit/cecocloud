/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificableChild;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Empresa extends AbstractIdentificableChild<Long, Long> {

	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 12)
	private String nif;
	@NotNull
	@Size(max = 40)
	private String nom;

}
