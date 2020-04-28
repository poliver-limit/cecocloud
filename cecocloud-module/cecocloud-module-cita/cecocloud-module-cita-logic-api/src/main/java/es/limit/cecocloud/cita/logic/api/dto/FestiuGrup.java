/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.fact.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un grup de festius. Els grups de festius es poden
 * associar amb un punt de venda per a configurar els dies festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class FestiuGrup extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			sizeMax = 4)
	private String codi;
	@NotNull
	@RestapiField(
		includeInQuickFilter = true)
	@Size(max = 100)
	private String nom;

}
