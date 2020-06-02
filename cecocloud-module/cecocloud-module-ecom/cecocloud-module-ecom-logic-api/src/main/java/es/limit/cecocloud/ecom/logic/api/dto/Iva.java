/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class Iva extends AbstractIdentificableWithIdentificadorAndCodi<String> {

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
	private String descripcio;
	
	@NotNull
	@Digits(integer=2, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentatgeIva;
	
	@NotNull
	@Digits(integer=2, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentatgeRecarrecEquivalencia;
	
	@NotNull
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiComptabilitat;
	
	@NotNull
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiRecarrecComptabilitat;
	
	@Size(max = 6)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String text;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String descripcioPercentatgeCodiTxt;

}
