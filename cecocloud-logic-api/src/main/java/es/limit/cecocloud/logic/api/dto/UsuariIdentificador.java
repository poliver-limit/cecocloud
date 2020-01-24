/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació usuari-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_ID, 
						resourceClass = "es.limit.cecocloud.logic.api.dto.Identificador",
						resourceSessionField = "i",
						resourcePermission = "ADMINISTRATION"),
		}
)
public class UsuariIdentificador extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Usuari, Long> usuari;
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
		if (usuari != null || identificador != null) {
			return ((usuari != null) ? usuari.getDescription() : "") + " - " + ((identificador != null) ? identificador.getDescription() : "");
		} else {
			return null;
		}
	}

}

