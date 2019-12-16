/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

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
 * DTO amb informació d'una familia cost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class FamiliaCost extends AbstractIdentificableAmbIdentificadorICodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInLov=true,
			hiddenInGrid = true)
	private String observacions;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReference<ArticleFamilia, String> articleFamilia;

}
