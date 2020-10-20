/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class MantenimentDeTipus extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 22)
	@Digits(integer = 10, fraction = 0)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 22)
	@Digits(integer = 2, fraction = 0)
	@RestapiField(
			includeInQuickFilter = true)
	private BigDecimal tip;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@Size(max = 1)
	@RestapiField(
			includeInQuickFilter = true)
	private String def;
	
	@Size(max = 22)
	@Digits(integer = 2, fraction = 0)
	@RestapiField(
			includeInQuickFilter = true)
	private BigDecimal ordre;

}
