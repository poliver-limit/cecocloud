/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Identificador extends AbstractIdentificable<String> {

	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	protected String nom;

}
