/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
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

public class TipusAdresa extends AbstractIdentificable<String> {
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
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String descripcioCodiTxt;

}