/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Banc extends AbstractIdentificableWithIdentificadorAndCodi<Integer> {

	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			sizeMax = 4)
	private Integer codi;
	@NotNull   
	@RestapiField(
		includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;

}
