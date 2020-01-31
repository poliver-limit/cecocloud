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
 * DTO amb informació d'una divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Divisa extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	
	@Size(max = 5)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String abreviatura;
	
	@NotNull
	@Digits(integer = 7, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal valorEuros;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 1)
	private int decimalsPreus;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 1)
	private int decimalsImports;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiComptabilitat;

}
