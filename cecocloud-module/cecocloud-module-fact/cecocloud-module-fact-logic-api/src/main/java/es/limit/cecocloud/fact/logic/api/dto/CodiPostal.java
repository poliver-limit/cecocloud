/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.Provincia.ProvinciaPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un codi postal
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "poblacio"
)
public class CodiPostal extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 8)
	@NotNull
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String descPostNomCodi;
	
	@NotNull
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			includeInQuickFilter = true)
	private String poblacio;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String municipi;

	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Pais, WithIdentificadorAndCodiPk<String>> pais;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			//lovParentField = "pais",			
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<Provincia, ProvinciaPk> provincia;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String poblacioMunicipiCodiTxt;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String codiPoblacioProvinciaTxt;

}
