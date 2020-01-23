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
 * DTO amb informació sobre el tipus rappel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(
		descriptionField = "nom")
public class Rappel extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
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
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal limitInferior;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal limitSuperior;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	@Digits(integer = 2, fraction = 2)
	private Float percentatge;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	@Digits(integer = 2, fraction = 2)
	private Float percentatge2;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	private Boolean escalat;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	private Boolean absolut;

}
