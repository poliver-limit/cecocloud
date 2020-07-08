/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
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
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
public class DocumentPagamentCobrament extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull(groups = { OnCreate.class })
	@RestapiField(disabledForUpdate = true,
				toUpperCase = true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean controlarEfectes = false;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean agruparVencimentsRemeses = false;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer numeroDias;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			sizeMax=3,
			hiddenInLov = true)
	private Integer diaEfectosNegociados;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean aplicarDescuentosProntoPago = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull(groups = { OnCreate.class })
	@Convert(converter = StringBooleanConverter.class)
	private boolean transpasar = false;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull(groups = { OnCreate.class })
	@Convert(converter = StringBooleanConverter.class)
	private boolean asientoCompuesto = false;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 4)
	private String codigoContable;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String codigoFacturaElectronica;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Digits(integer = 2, fraction = 2)
	private BigDecimal percentatgeComisio;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 64)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableComissio;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String concepteContable;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableOrigenIngressos;
	
	@NotNull(groups = { OnCreate.class })
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 2)
	private String tipusSeientIngressos;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContableIngressos2;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 10)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String compteContableDestiPagos;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String tipusSeientPagos;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos;
	
	@NotNull(groups = { OnCreate.class })
	@Size(max = 2)
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private String diariContablePagos2;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<NaturalesaPagamentCobrament, WithIdentificadorAndCodiPk<String>> naturalesaPagamentCobrament;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov=true)	
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@NotNull(groups = { OnCreate.class })
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;

}
