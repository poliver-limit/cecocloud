/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.rrhh.logic.api.dto.enums.TipusHorariEnumDto;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Horari extends AbstractIdentificableAmbIdentificadorICodi<String> {
	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	private String nom;
	
	@Transient
	@NotNull
	@RestapiField(hiddenInGrid = false)
	private TipusHorariEnumDto tipus;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true)
	private BigDecimal hores;

}
