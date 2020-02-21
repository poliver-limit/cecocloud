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
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació funcionalitat-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_ID, 
						resourceClass = "es.limit.cecocloud.logic.api.dto.Identificador",
						resourceSessionField = "i",
						resourcePermission = "ADMINISTRATION")
		}
)
public class FuncionalitatIdentificador extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Funcionalitat, Long> funcionalitat;
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
	private String descripcio;

	public String getDescricio() {
		if (funcionalitat != null && identificador != null) {
			return funcionalitat.getDescription() + " - " + identificador.getDescription();
		} else {
			return null;
		}
	}

}

