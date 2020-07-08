/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un article marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class ArticleMarca extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String descripcio;

}
