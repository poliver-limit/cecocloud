/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
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
	@RestapiField(hiddenInLov = true)
	@Enumerated
	protected EmpresaTipusEnum tipus;
	@RestapiField(hiddenInLov = true)
	private boolean activa = true;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true,
			includeInQuickFilter = false)
	private GenericReference<Empresa, Long> empresaComptable;

	public enum EmpresaTipusEnum {
		COMPTABLE,
		GESTIO
	}

}
