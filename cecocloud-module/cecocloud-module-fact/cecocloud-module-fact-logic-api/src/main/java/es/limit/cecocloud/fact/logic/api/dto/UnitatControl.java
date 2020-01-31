/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una unitat control.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class UnitatControl extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@RestapiField(
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInLov=true)
	private int sequencia;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 250)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private Integer numeroOrigen;
	
	private BigDecimal importTotal;
	
	private BigDecimal costTotal;

}
