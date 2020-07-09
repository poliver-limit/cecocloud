/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;

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
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat.VencimentPagatPk;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment.VencimentPk;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment.CaixaMovimentPk;
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
		descriptionField = "descripcio"
)
@PrimaryKeyNotExists(fields = {"caixa","empresa","caixaMoviment","moviment"}, groups = { OnCreate.class })
public class VencimentPagat extends AbstractIdentificableWithIdentificador<VencimentPagatPk> {

	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer moviment;	
	
	@NotNull(groups = { OnCreate.class })
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;
	
//	@NotNull(groups = {OnCreate.class})	
//	@RestapiField(
//			disabledForCreate = true,
//			disabledForUpdate = true,
//			toUpperCase = true,
//			includeInQuickFilter = true,
//			sizeMax = 22)
//	private Integer facturaNumero;
	
//	@NotNull(groups = { OnCreate.class })
//	@Size(max = 1)
//	@RestapiField(
//			disabledForCreate = true,
//			disabledForUpdate = true,
//			includeInQuickFilter = true,
//			hiddenInGrid = true)
//	private String facturaClasse;	
	
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer cmpvcpseq;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Caixa, CaixaPk> caixa;
	
	@NotNull(groups = { OnCreate.class })
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<CaixaMoviment, CaixaMovimentPk> caixaMoviment;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Venciment, VencimentPk> venciment;
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = false,
			hiddenInForm = false)
	private GenericReferenceWithCompositePk<Factura, FacturaPk> factura;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class VencimentPagatPk extends WithIdentificadorPk {
		private String empresaCodi;
		private String caixaCodi;
		private Integer caixaMovimentNumero;
		private Integer moviment;
		public VencimentPagatPk(
				String identificadorCodi,
				String empresaCodi,
				String caixaCodi,
				Integer caixaMovimentNumero,
				Integer moviment) {
			super(identificadorCodi);
			this.empresaCodi = empresaCodi;
			this.caixaCodi = caixaCodi;
			this.caixaMovimentNumero = caixaMovimentNumero;
			this.moviment = moviment;			
		}
	}

}
