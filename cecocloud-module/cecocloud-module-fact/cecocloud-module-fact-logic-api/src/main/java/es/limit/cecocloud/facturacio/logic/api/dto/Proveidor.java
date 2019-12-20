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
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
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
public class Proveidor extends AbstractIdentificableAmbIdentificadorICodi<String> {

	@Size(max = 6)
	@RestapiField(disabledForUpdate = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 40)
	private String nomComercial;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 40)
	private String nomFiscal;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean bloquetjat;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean subcontratista;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov=true)
	private boolean dhm;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<RegimIva, AmbIdentificadorICodiPk<String>> RegimIva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<CodiPostal, AmbIdentificadorICodiPk<String>> codiPostal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<TipusVenciment, AmbIdentificadorICodiPk<String>> tipusVenciment;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<Divisa, AmbIdentificadorICodiPk<String>> divisa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, AmbIdentificadorICodiPk<String>> documentPagamentCobrament;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<FamiliaProveidor, AmbIdentificadorICodiPk<String>> familiaProveidor;
	
}
