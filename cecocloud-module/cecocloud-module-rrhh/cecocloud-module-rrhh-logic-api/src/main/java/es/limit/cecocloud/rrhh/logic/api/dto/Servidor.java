/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un Servidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Servidor extends AbstractIdentificableAmbIdentificadorICodi<String> {
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String descripcio;

}
