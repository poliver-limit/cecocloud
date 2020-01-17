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
 * DTO amb informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Zona extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@RestapiField(hiddenInGrid = true)
	@NotNull
	private Boolean zonaTreball;
	
	@Size(max = 30)
	@NotNull
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true)
	private String observacio;

}
