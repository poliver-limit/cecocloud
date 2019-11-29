/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.DocumentPagamentCobrament.DocumentPagamentCobramentPk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom"
)
public class DocumentPagamentCobrament extends AbstractIdentificableWithCompositePk<DocumentPagamentCobramentPk> {

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
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean controlarEfectes;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean agruparVencimentsRemeses;
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
	private boolean aplicarDescuentosProntoPago;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	private boolean transpasar;
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@NotNull
	private boolean asientoCompuesto;
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
	private String TipusSeientIngressos;
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
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private NaturalesaPagamentCobrament naturalesaPagamentCobrament;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov=true)
	private Iva iva;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			hiddenInLov = true)
	private RegimIva regimIva;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class DocumentPagamentCobramentPk implements Serializable {
		private String identificadorCodi;
		private String codi;
	}

}
