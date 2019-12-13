/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

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
public class Parametre extends AbstractIdentificableAmbIdentificadorICodi<String> {	

}
