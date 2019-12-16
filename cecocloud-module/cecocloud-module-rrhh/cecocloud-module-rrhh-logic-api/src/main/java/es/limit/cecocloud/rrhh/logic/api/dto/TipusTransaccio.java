/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class TipusTransaccio extends AbstractIdentificableAmbIdentificadorICodi<Integer> {
	
	@Max(Integer.MAX_VALUE)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private Integer codi;
	
	@Size(max = 1000)
	@RestapiField()
	private String descripcio;

}
