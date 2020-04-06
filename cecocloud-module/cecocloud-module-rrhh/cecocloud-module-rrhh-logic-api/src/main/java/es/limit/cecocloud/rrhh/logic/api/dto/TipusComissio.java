/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un tipus de comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(descriptionField = "nom")
public class TipusComissio extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;

	@NotNull
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String nom;

	@NotNull
	@Size(max = 1000)
	@RestapiField(hiddenInLov = true)
	private String descripcio;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Digits(integer = 5, fraction = 3)
	private BigDecimal percentatge;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Digits(integer = 15, fraction = 3)
	private BigDecimal minim;

}
