/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nomComercial"
)
public class Empresa extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(disabledForUpdate = true,
				toUpperCase = true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 40)
	@RestapiField(disabledForUpdate = true,
			includeInQuickFilter = true
	)
	private String nomComercial;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;

}
