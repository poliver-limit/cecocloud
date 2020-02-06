/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class Operari extends AbstractIdentificableWithIdentificador<Long> {

	@NotNull
	@Size(max = 6)
	@RestapiField(
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			//disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Usuari, Long> usuari;
	private boolean actiu = true;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String description;

	public String getDescription() {
		if (codi != null && usuari != null) {
			return "(" + codi + ") " + usuari.getDescription();
		} else if (codi != null) {
			return "(" + codi + ") ???";
		} else {
			return null;
		}
	}

}

