/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.AbstractIdentificableWithIdentificador;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació sobre el tipus TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(
		descriptionField = "descripcio")

//public class TipusAdresa extends AbstractIdentificableWithIdentificadorAndCodi<String>{
public class TipusAdresa extends AbstractIdentificableWithIdentificador<String> {
	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase=true,
			includeInQuickFilter = true)
	@Size(max = 4)
	protected String codi;
	@NotNull
	@Size(max = 30)
	protected String descripcio;

}
