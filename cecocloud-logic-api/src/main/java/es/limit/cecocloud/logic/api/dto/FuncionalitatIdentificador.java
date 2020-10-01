/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiAuthoritiesWithPermission;
import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
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
						type = RestapiPermissionConstraintType.AUTHORITY,
						authoritiesWithPermissions = {
								@RestapiAuthoritiesWithPermission(permission = "READ", authorities = {Authority.ADMIN}),
								@RestapiAuthoritiesWithPermission(permission = "WRITE", authorities = {Authority.ADMIN}),
								@RestapiAuthoritiesWithPermission(permission = "CREATE", authorities = {Authority.ADMIN}),
								@RestapiAuthoritiesWithPermission(permission = "DELETE", authorities = {Authority.ADMIN})
						},
						mandatory = false),
				@RestapiResourceAccessConstraint(
						type = RestapiPermissionConstraintType.ACL_ID, 
						resourceClass = "es.limit.cecocloud.logic.api.dto.Identificador",
						resourceSessionField = "i",
						resourcePermission = "ADMINISTRATION",
						mandatory = false)
		},
		sortFields = {
				@RestapiSort(field = "funcionalitat.modul"),
				@RestapiSort(field = "funcionalitat.descripcio")
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

	public String getDescripcio() {
		if (funcionalitat != null && identificador != null) {
			return funcionalitat.getDescription() + " - " + identificador.getDescription();
		} else {
			return null;
		}
	}

}

