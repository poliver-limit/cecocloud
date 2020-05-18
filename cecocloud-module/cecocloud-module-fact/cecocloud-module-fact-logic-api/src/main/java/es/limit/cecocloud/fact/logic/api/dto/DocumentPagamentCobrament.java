/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
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
	@NotNull
	@RestapiField(disabledForUpdate = true,
				toUpperCase = true,
				includeInQuickFilter = true)
	private String codi;
	@NotNull
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	@Convert(converter = StringBooleanConverter.class)
	private boolean asientoCompuesto = false;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	@Convert(converter = StringBooleanConverter.class)
	private boolean transpasar = false;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean controlarEfectes = false;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean agruparVencimentsRemeses = false;
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer numeroDias;
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diaEfectosNegociados;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean aplicarDescuentosProntoPago = false;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 4)
	private String codigoContable;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String codigoFacturaElectronica;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 2, fraction = 2)
	private BigDecimal percentatgeComisio;
	@Size(max = 64)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableComissio;
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String concepteContable;
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableOrigenIngressos;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 2)
	private String tipusSeientIngressos;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos2;
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableDestiPagos;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String tipusSeientPagos;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos;
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos2;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<NaturalesaPagamentCobrament, WithIdentificadorAndCodiPk<String>> naturalesaPagamentCobrament;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;

}
