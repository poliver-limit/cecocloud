/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom",
		resourceAccessConstraints = {
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_ID, 
						resourceClass = "es.limit.cecocloud.logic.api.dto.Identificador",
						resourceSessionField = "i",
						resourcePermission = "ADMINISTRATION"),
		}
)
public class Empresa extends AbstractIdentificableWithIdentificador<Long> {

	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 12)
	@RestapiField(includeInQuickFilter = true)
	private String nif;
	@NotNull
	@Size(max = 40)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	@NotNull
	@RestapiField(
			hiddenInLov = true,
			disabledForUpdate = true)
	@Enumerated
	protected EmpresaTipusEnum tipus;
	@RestapiField(hiddenInLov = true)
	private boolean activa;

	public enum EmpresaTipusEnum {
		COMPTABLE,
		GESTIO
	}

}
