/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Zona extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@RestapiField(hiddenInGrid = true)
	@NotNull
	@Convert(converter = StringBooleanConverter.class)
	private Boolean zonaTreball = false;
	
	@Size(max = 30)
	@NotNull
	private String nom;
	
	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true)
	private String observacio;

}
