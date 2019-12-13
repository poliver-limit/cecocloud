/**
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
 * DTO amb informació d'un Regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Regim extends AbstractIdentificableAmbIdentificadorICodi<String> {
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true)
	private String codi;
	
	private boolean presencia;
	
	private boolean contarHores;
	
	private boolean mantenirProximaEntrada;
	
	private boolean mostrarLlistatPlanificacio;
	
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	
	@Digits(integer = 3, fraction = 0)
	private BigDecimal numHoresLaborals;
	
	@Digits(integer = 3, fraction = 0)
	private BigDecimal numMinHoresLaborals;

}
