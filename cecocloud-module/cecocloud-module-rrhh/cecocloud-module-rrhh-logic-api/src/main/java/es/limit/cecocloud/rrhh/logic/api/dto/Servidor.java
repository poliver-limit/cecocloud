/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class Servidor extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@NotNull
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@NotNull
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String descripcio;

}
