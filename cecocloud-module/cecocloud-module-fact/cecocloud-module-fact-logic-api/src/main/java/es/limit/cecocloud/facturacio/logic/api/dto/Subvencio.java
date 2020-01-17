/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una subvencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Subvencio extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 20)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	
	@NotNull
	@Size(max = 20)
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private String origen;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	private BigDecimal preuPerKilo;

}
