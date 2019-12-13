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
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.PeuDocument.PeuDocumentPk;
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
public class PeuDocument extends AbstractIdentificableAmbIdentificador<PeuDocumentPk> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 4)
	@RestapiField(disabledForUpdate = true, toUpperCase = true,includeInQuickFilter = true)
	private String codi;
	
	@RestapiField(includeInQuickFilter = true)
	@Size(max = 30)
	private String descripcio;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean factura;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean albara;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean pre;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean com;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean imprimirPeuCertificacio;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean familiaCliProv;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	@Size(max = 1000)
	private String pie;
	
	@RestapiField(hiddenInGrid = true,
			hiddenInLov = true)
	private boolean impCls;
	
	@Digits(integer=3, fraction=3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal ordre;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)	
	private GenericReference<SerieCompra, String> serieCompra;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Empresa, String> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PeuDocumentPk extends AmbIdentificadorICodiPk<String> {
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
