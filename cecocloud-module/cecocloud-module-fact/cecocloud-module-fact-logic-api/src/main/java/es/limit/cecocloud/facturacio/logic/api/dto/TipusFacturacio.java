/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una tipus de facturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class TipusFacturacio extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean concedimCredit;

}
