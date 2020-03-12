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
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació sobre el tipus organitzacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter
@RestapiResource(
		descriptionField = "nom")
public class Organitzacio extends AbstractIdentificableWithIdentificadorAndCodi<String> {
	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String domicili;
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true)
	private String telefon;
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String fax;
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String email;
	@Size(max = 60)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String adresaWeb;
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String gerent;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String contacte;
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;

}
