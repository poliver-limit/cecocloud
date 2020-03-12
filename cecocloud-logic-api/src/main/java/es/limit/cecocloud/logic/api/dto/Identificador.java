/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiAuthoritiesWithPermission;
import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint;
import es.limit.base.boot.logic.api.annotation.RestapiResourceAccessConstraint.RestapiPermissionConstraintType;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.Authority;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.Usuari;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un identificador.
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
								resourceActionsAllowed = {"READ", "UPDATE"},
								mandatory = false)
				}
)
public class Identificador extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			toUpperCase = true,
			includeInQuickFilter = true,
			disabledForUpdate = true)
	private String codi;
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numUsuaris;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numEmpreses;
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private int numOperaris;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataInici;
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFi;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReference<Usuari, Long> propietari;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReference<Perfil, Long> perfilDefecte;

	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int usuarisCount;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int empresesCount;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private int operarisCount;

}
