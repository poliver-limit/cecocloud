/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.enums.ComptabilitzacioTipusEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació sobre el tipus ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(
		descriptionField = "nom")
public class ClasseRetencio extends AbstractIdentificableWithIdentificadorAndCodi<String>{
	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteVentes;
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteCompres;
	@NotNull
	@RestapiField(
			type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			hiddenInLov = true)
	private ComptabilitzacioTipusEnumDto tipusComptabilitzacio;
}