/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.RegimIva.RegimIvaPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusRegimEnumDto;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un regim d'Iva
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
//		resourceAccessConstraints = {
//				@RestapiResourceAccessConstraint(
//						type = RestapiPermissionConstraintType.ACL_RESOURCE
//				)
//		}
)
public class RegimIva extends AbstractIdentificableWithCompositePk<RegimIvaPk> {

	// Definicions DTO
	@Size(max = 2)
	@RestapiField(disabledForUpdate = true,
			toUpperCase=true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiComptabilitat;
	@NotNull
	@RestapiField(
			type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			hiddenInLov=true)
	private TipusRegimEnumDto tip;
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiFacturaElectronica;
	
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
	public static class RegimIvaPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
