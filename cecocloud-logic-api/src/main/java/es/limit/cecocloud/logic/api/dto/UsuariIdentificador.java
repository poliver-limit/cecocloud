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
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.cecocloud.logic.api.validation.IdentificadorMaxUsuaris;
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
						resourcePermission = "ADMINISTRATION")
		}
)
@IdentificadorMaxUsuaris
public class UsuariIdentificador extends AbstractIdentificableWithIdentificador<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Usuari, Long> usuari;
	@NotNull
	private IdentificadorRecursOrigen origen = IdentificadorRecursOrigen.CECOCLOUD;
	private boolean actiu = true;

	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String description;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String usuariCodi;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String usuariNom;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String usuariLlinatges;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String usuariEmail;

}
