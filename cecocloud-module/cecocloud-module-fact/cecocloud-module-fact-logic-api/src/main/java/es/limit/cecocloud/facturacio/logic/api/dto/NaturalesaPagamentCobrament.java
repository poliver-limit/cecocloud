/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una naturalesa de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class NaturalesaPagamentCobrament extends AbstractIdentificableWithIdentificadorAndCodi<String> {

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
	
	@NotNull
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;

}
