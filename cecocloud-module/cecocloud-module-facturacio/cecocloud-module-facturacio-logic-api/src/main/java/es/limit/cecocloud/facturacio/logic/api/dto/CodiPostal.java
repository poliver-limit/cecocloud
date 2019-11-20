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
import es.limit.cecocloud.facturacio.logic.api.dto.CodiPostal.CodiPostalPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un codi postal
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "poblacio"
//		resourceAccessConstraints = {
//				@RestapiResourceAccessConstraint(
//						type = RestapiPermissionConstraintType.ACL_RESOURCE
//				)
//		}
)
public class CodiPostal extends AbstractIdentificableWithCompositePk<CodiPostalPk> {

	// Definicions DTO
	@Size(max = 8)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;

	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			hiddenInGrid = true,
			includeInQuickFilter = true)
	private Pais pais;
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			lovParentField = "pais",
			hiddenInGrid = true,
			includeInQuickFilter = true)
	private Provincia provincia;
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String poblacio;
	@Size(max = 30)
	@RestapiField(
			hiddenInLov = true)
	private String municipi;
	
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
	public static class CodiPostalPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
