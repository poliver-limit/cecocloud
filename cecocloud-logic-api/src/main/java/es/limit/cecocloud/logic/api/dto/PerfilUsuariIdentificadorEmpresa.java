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
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació perfil-(usuari-identificador-empresa).
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
						resourcePermission = "ADMINISTRATION")
		}
)
public class PerfilUsuariIdentificadorEmpresa extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Perfil, Long> perfil;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<UsuariIdentificadorEmpresa, Long> usuariIdentificadorEmpresa;
//	@Transient
//	@RestapiField(
//			hiddenInGrid = true,
//			hiddenInForm = true,
//			hiddenInLov = true)
//	private String description;

	public String getDescription() {
		if (perfil != null || usuariIdentificadorEmpresa != null) {
			return ((perfil != null) ? perfil.getDescription() : "") + " - " + ((usuariIdentificadorEmpresa != null) ? usuariIdentificadorEmpresa.getDescription() : "");
		} else {
			return null;
		}
	}

}
