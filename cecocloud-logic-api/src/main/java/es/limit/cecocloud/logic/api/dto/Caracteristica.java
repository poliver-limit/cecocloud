/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una caracteristica.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom")
public class Caracteristica extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 100)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	@NotNull
	@Size(max = 4)
	@RestapiField(
			includeInQuickFilter = true)
	private String modul;

}
