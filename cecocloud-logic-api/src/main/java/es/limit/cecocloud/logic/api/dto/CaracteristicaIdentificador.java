/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.CaracteristicaIdentificador.CaracteristicaIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'una relació caracteristica-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "usuari",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_ID, 
						resourceClass = "es.limit.cecocloud.logic.api.dto.Companyia",
						resourcePermission = "ADMINISTRATION"),
		}
)
public class CaracteristicaIdentificador extends AbstractIdentificableWithCompositePk<CaracteristicaIdentificadorPk> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Caracteristica, Long> caracteristica;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Identificador, Long> identificador;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String description;

	public String getDescription() {
		if (caracteristica != null || identificador != null) {
			return ((caracteristica != null) ? caracteristica.getDescription() : "") + " - " + ((identificador != null) ? identificador.getDescription() : "");
		} else {
			return null;
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class CaracteristicaIdentificadorPk implements Serializable {
		private Long caracteristicaId;
		private Long identificadorId;
	}

}

