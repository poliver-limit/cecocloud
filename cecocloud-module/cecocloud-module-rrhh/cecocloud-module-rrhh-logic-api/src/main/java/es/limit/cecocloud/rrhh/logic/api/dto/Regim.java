/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

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
 * DTO amb informació d'un Regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Regim extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true)
	private String codi;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean presencia = false;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean contarHores = false;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean mantenirProximaEntrada = false;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean mostrarLlistatPlanificacio = false;
	
	@Size(max = 30)
	@NotNull
	@RestapiField(
			includeInQuickFilter = true, hiddenInGrid = false)
	private String nom;
	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(hiddenInGrid = true)
	private BigDecimal numHoresLaborals;
	
	@Digits(integer = 3, fraction = 0)
	@RestapiField(hiddenInGrid = true)
	private BigDecimal numMinHoresLaborals;

}
