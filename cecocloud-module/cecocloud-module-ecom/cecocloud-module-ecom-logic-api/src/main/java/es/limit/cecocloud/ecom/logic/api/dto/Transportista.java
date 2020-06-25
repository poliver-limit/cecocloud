/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
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
public class Transportista extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 6)
	@NotNull
	@RestapiField(disabledForUpdate = true,
				toUpperCase=true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
//	@Size(max = 30)
	@Size(max = 24) // Per adaptacio pantalla
	private String nom;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
	hiddenInLov=true)
	@Size(max = 12)
	private String nif;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String domicili;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
//	@Size(max = 60)
	@Size(max = 20) // Per adaptacio pantalla
	private String telefon;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String fax;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String email;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String adresaWeb;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String contacte;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String formaPagament;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
//	@Size(max = 60)
	@Size(max = 24) // Per adaptacio pantalla
	private String horariRepartiment;
	
//	@Size(max = 1000)
	@Size(max = 100) // Per adaptacio pantalla
	@RestapiField(
//			type = RestapiFieldType.TEXTAREA, // Per adaptacio pantalla
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean vehicleEmpresa = false;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			includeInQuickFilter = true)	
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Proveidor, WithIdentificadorAndCodiPk<String>> proveidor;

}