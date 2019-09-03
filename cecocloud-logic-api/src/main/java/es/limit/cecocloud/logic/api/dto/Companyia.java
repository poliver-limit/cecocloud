/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.annotation.RestapiField;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom",
		authoritiesWithCreatePermission = { Rol.ADMIN },
		authoritiesWithReadPermission = { Rol.ADMIN },
		authoritiesWithUpdatePermission = { Rol.ADMIN },
		authoritiesWithDeletePermission = { Rol.ADMIN })
public class Companyia extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String nom;

}
