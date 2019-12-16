/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'una tipus de risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class TipusRisc extends AbstractIdentificableAmbIdentificadorICodi<String> {

	@NotNull(groups = {OnCreate.class})
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			includeInQuickFilter = true)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_pensrv;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_albnotfac;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_vtopennotvnt;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_vtopenvnt;
	
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer tri_efeneg;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean tri_nifigu;

}
