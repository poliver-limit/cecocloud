/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
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
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class NaturalesaPagamentCobrament extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(disabledForUpdate = true,
			toUpperCase=true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;

}
