/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom")
public class Recurs extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 100)
	@RestapiField(
			includeInQuickFilter = true,
			gridPercentWidth = 40)
	private String nom;
	@NotNull
	@Size(max = 1024)
	@RestapiField(
			includeInQuickFilter = true)
	private String className;

}
