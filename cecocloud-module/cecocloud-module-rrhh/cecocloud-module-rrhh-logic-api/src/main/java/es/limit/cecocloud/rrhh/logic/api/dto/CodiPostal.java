/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi;
//import es.limit.cecocloud.rrhh.logic.api.dto.Pais;
//import es.limit.cecocloud.rrhh.logic.api.dto.Provincia;
import es.limit.cecocloud.rrhh.logic.api.dto.Provincia.ProvinciaPk;
//import es.limit.cecocloud.rrhh.logic.api.dto.Provincia.ProvinciaPk;
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

}
