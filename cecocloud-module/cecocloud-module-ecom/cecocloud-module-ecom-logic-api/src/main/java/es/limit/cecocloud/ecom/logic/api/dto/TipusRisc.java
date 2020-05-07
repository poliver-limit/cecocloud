/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
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
public class TipusRisc extends AbstractIdentificableWithIdentificadorAndCodi<String> {

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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean tri_nifigu = false;

}
