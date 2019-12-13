/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.generic.dto.AbstractIdentificableAmbIdentificador;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Perfil extends AbstractIdentificableAmbIdentificador<Long> {

	@NotNull
	@Size(max = 10)
	@RestapiField(includeInQuickFilter = true)
	private String codi;
	@Size(max = 100)
	@RestapiField(includeInQuickFilter = true)
	private String descripcio;

}
