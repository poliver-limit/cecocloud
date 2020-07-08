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
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class Magatzem extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String nom;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 60)
	private String domicili;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 1)
	private String valoracioInventarisTraspassos = "1";	
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 60)
	private String telefon;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 60)
	private String fax;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 60)
	private String email;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 30)
	private String responsable;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 1000)
	private String observacions;

	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 2)
	private String tipusSeientComptable;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 2)
	private String diariComptableTraspassos;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 2)
	private String diariComptableTraspassos2;
	
	@RestapiField(
			includeInQuickFilter = true,
			hiddenInGrid = true
	)
	@Size(max = 10)
	private String compteTraspassos;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@NotNull(groups = { OnCreate.class })
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
}
