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
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra.SerieCompraPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'un peu document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class PeuDocument extends AbstractIdentificableWithIdentificador<PeuDocumentPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true,includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean factura;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean albara;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean pre;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean com;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean imprimirPeuCertificacio;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean familiaCliProv;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 1000)
	private String pie;
	
	@NotNull
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean impCls;
	
	@Digits(integer=3, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal ordre;
	
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<SerieCompra, SerieCompraPk> serieCompra;	
	
	@Transient
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true
			)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;


	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PeuDocumentPk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public PeuDocumentPk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}

}
