/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class DocumentPagamentCobrament extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@RestapiField(disabledForUpdate = true,
				toUpperCase = true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean controlarEfectes;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean agruparVencimentsRemeses;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer numeroDias;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diaEfectosNegociados;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean aplicarDescuentosProntoPago;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	private boolean transpasar;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	private boolean asientoCompuesto;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 4)
	private String codigoContable;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String codigoFacturaElectronica;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 2, fraction = 2)
	private BigDecimal percentatgeComisio;
	
	@NotNull
	@Size(max = 64)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableComissio;
	
	@NotNull
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String concepteContable;
	
	@NotNull
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableOrigenIngressos;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 2)
	private String tipusSeientIngressos;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos2;
	
	@NotNull
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableDestiPagos;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String tipusSeientPagos;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos;
	
	@NotNull
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos2;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<NaturalesaPagamentCobrament, WithIdentificadorAndCodiPk<String>> naturalesaPagamentCobrament;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;

}
