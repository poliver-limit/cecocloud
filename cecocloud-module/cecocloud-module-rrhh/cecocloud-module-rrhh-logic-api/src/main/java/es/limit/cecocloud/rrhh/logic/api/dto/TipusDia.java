/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un TipusDia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class TipusDia extends AbstractIdentificableAmbIdentificadorICodi<String> {
	
	@Size(max = 22)
	@RestapiField(disabledForUpdate = true, toUpperCase = true)
	private String codi;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true)	
	private GenericReference<Regim, String> regim;
	
	@Size(max = 30)
	private String nom;

}
