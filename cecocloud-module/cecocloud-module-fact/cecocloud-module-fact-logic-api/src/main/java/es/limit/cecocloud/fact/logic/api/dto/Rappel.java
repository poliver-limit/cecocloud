/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
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
		descriptionField = "descripcio")
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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean escalat = false;
	@RestapiField(
			hiddenInGrid = true, 
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean absolut = false;

}
