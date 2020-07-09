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
 * DTO amb informació d'un proveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nomComercial"
)
public class Proveidor extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 6)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(disabledForUpdate = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 40)
	private String nomComercial;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true, includeInQuickFilter = true)
	@Size(max = 40)
	private String nomFiscal;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean bloquetjat = false;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean subcontratista = false;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean dhm = false;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true,
			hiddenInGrid = true)	
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagamentCobrament;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<FamiliaProveidor, WithIdentificadorAndCodiPk<String>> familiaProveidor;
	
}
