/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * Information about parameters.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 *
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
		)
public class Parameter extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 15)
	@RestapiField(hiddenInLov = true, includeInQuickFilter = true, disabledForUpdate = true)
	private String codi;
	@NotNull
	@Size(max = 4000)
	@RestapiField(
			includeInQuickFilter = true)
	private String value;
	@NotNull
	@Size(max = 1000)
	@RestapiField(
			includeInQuickFilter = true)
	private String description;
	
}