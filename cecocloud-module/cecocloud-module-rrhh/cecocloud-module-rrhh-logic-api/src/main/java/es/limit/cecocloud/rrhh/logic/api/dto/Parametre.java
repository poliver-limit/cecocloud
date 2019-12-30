/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Parametre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Parametre extends AbstractIdentificableWithIdentificadorAndCodi<String> {	

	@NotNull(groups = { OnCreate.class })
	@Size(max = 15)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	@NotNull
	@Size(max = 100)
	private String valor;
	@NotNull
	@Size(max = 1000)
	private String descripcio;

}
