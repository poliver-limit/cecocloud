/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.annotation.RestapiField;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
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
		authoritiesWithCreatePermission = { Rol.ADMIN },
		authoritiesWithReadPermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithUpdatePermission = { Rol.ADMIN },
		authoritiesWithDeletePermission = { Rol.ADMIN })
public class Empresa extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private GenericReference<Companyia, Long> companyia;
	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String identificadorCodi;
	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 40)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	@NotNull
	@Size(max = 12)
	@RestapiField(includeInQuickFilter = true)
	private String nif;
	@RestapiField(hiddenInLov = true)
	private boolean activa;

}
