/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase.FacturaBasePk;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "facturaNumero"
)
@PrimaryKeyNotExists(fields = {"factura", "serieVenda", "iva"}, groups = { OnCreate.class })
public class FacturaBase extends AbstractIdentificableWithIdentificador<FacturaBasePk> {

//	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer facturaNumero;
	
//	@NotNull(groups = { OnCreate.class })
	@Size(max = 1)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String facturaClasse;	

	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
//	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			hiddenInGrid = false,
			disabledForUpdate = true,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<Factura, FacturaPk> factura;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class FacturaBasePk extends WithIdentificadorPk {
		private String empresaCodi;
		private String serieVendaCodi;
		private Integer facturaNumero;
		private String facturaClasse;
		private String ivaCodi;
		public FacturaBasePk(
				String identificadorCodi,
				String empresaCodi,
				String serieVendaCodi,
				Integer facturaNumero,
				String facturaClasse,
				String ivaCodi) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.serieVendaCodi = serieVendaCodi;
			this.facturaNumero = facturaNumero;
			this.facturaClasse = facturaClasse;
			this.ivaCodi = ivaCodi;
		}
	}

}
