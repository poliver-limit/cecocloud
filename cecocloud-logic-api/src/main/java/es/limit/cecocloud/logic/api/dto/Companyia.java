/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Authorities;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
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
		authoritiesWithCreatePermission = { Authorities.ADMIN },
		authoritiesWithReadPermission = { Authorities.ADMIN },
		authoritiesWithUpdatePermission = { Authorities.ADMIN },
		authoritiesWithDeletePermission = { Authorities.ADMIN })
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
