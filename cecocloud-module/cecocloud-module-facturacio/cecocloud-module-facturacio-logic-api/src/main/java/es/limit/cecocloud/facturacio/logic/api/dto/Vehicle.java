/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un vehicle
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
//		resourceAccessConstraints = {
//				@RestapiResourceAccessConstraint(
//						type = RestapiPermissionConstraintType.ACL_RESOURCE
//				)
//		}
)
public class Vehicle extends AbstractIdentificableWithCompositePk<VehiclePk> {

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
	private String matricula_remolc;
	
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
	
	// Camps transient (no persistència)
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			//hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	// Definició de la PK
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@SuppressWarnings("serial")
	public static class VehiclePk implements Serializable {
		private String identificadorCodi;
		private String codi;		
	}

}
