/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un vehicle
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Vehicle extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private String matricula;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private String matriculaRemolc;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private String DNI;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private String conductorHabitual;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=4,
			hiddenInLov = true)
	private String observacions;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 2)
	private BigDecimal tara;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 12, fraction = 2)
	private BigDecimal pesMaxim;

}
