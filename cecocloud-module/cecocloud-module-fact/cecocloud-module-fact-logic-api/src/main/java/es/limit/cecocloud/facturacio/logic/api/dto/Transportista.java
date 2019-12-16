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
 * DTO amb informació d'un transportista.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class Transportista extends AbstractIdentificableAmbIdentificadorICodi<String> {

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
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
	hiddenInLov=true)
	@Size(max = 12)
	private String nif;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String domicili;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Size(max = 60)
	private String telefon;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String fax;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String email;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String adresaWeb;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String contacte;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String formaPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 60)
	private String horariRepartiment;
	
	@Size(max = 1000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA,
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean vehicleEmpresa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			includeInQuickFilter = true)	
	private GenericReference<CodiPostal, String> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReference<Divisa, String> divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReference<Proveidor, String> proveidor;

}
