package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
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
		descriptionField = "nom")

public class TipusAdresa extends AbstractIdentificableWithIdentificadorAndCodi<String>{
	
	@NotNull(groups = {OnCreate.class})
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase=true,
			includeInQuickFilter = true)
	@Size(max = 2)
	protected String codi;
	@NotNull
	@Size(max = 30)
	protected String descripcio;

}
