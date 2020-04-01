/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un mantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "codi")
public class MantenimentDeTipus extends AbstractIdentificableWithIdentificadorAndCodi<String>{
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true)
	private String codi;

	@NotNull
	private Integer tipus;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true)
	private String descripcio;


}
