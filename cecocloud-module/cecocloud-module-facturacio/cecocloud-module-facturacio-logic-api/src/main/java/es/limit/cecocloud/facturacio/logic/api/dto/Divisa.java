/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.Divisa.DivisaPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una divisa.
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
public class Divisa extends AbstractIdentificableWithCompositePk<DivisaPk> {

	// Definicions DTO
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
	public static class DivisaPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
