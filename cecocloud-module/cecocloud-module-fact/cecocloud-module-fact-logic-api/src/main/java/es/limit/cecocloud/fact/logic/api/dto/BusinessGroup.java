/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Information about business groups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 *
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
		)
public class BusinessGroup extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull
	@Size(max = 4)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true)
	private String codi;
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String nom;
	
}