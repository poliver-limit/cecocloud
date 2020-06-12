/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

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
import es.limit.cecocloud.ecom.logic.api.dto.Venciment.VencimentPk;
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
@PrimaryKeyNotExists(fields = {"factura", "serieVenda","numero"}, groups = { OnCreate.class })
public class Venciment extends AbstractIdentificableWithIdentificador<VencimentPk> {

	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer numero;
	
//	@NotNull(groups = {OnCreate.class})	
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer facturaNumero;
	
//	@NotNull
	@Size(max = 1)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String facturaClasse;	
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date dia;
	
	@NotNull
	@Digits(integer = 19, fraction = 3)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuAmbIva;
	
	@NotNull
	@Digits(integer = 14, fraction = 8)
	@RestapiField(			
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal valorDivisaEuros;	
	
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer cmpvenseq;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 7)
	private Date diaInicial;
	
	@Size(max = 1)
	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = false,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private String retencioGarantia;	

	@RestapiField(
			disabledForCreate = false,
			disabledForUpdate = false,
			hiddenInGrid = true,
			toUpperCase = true,
			includeInQuickFilter = true,
			sizeMax = 22)
	private Integer cntenv;	
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = false,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
//	@NotNull
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			hiddenInGrid = true,
			disabledForUpdate = true,
			hiddenInForm = false
			)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serieVenda;
	
	@NotNull
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
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class VencimentPk extends WithIdentificadorPk {
		private Integer numero;
		private String empresaCodi;
		private String serieVendaCodi;
		private Integer facturaNumero;
		private String facturaClasse;		
		public VencimentPk(
				String identificadorCodi,				
				String empresaCodi,
				String serieVendaCodi,
				Integer facturaNumero,
				String facturaClasse,
				Integer numero) {
			super(identificadorCodi);
			this.numero = numero;
			this.empresaCodi = empresaCodi;
			this.serieVendaCodi = serieVendaCodi;
			this.facturaNumero = facturaNumero;
			this.facturaClasse = facturaClasse;			
		}
	}

}
