/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Perfil extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String codi;
	@Size(max = 255)
	@RestapiField(includeInQuickFilter = true)
	private String descripcio;
	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private GenericReference<Companyia, Long> companyia;
	
}
