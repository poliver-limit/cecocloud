/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.PaisNifTipusEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)

public class PaisNif extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, 
			toUpperCase = true)
	private String codi;
	
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private PaisNifTipusEnumDto tipusNif;
	
	@Size(max = 40)
	@NotNull
	@RestapiField(
			includeInQuickFilter = true, hiddenInGrid = false)
	private String nom;
	
	@Size(max = 15)
	@RestapiField(hiddenInGrid = true)
	private String tamanyNif;

}
