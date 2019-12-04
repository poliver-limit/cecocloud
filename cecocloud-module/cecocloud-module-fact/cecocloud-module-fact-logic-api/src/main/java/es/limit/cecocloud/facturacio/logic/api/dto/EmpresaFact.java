/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact.EmpresaFactPk;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.FacturacioTipusEnum;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusComptabilitatClientEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusEstrangerEnumDto;
import es.limit.cecocloud.facturacio.logic.api.dto.enums.TipusPersonaEnumDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nomComercial"
)
public class EmpresaFact extends AbstractIdentificableWithCompositePk<EmpresaFactPk> {

	@Size(max = 4)
	@RestapiField(disabledForUpdate = true,
				toUpperCase = true,
				includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 40)
	@RestapiField(disabledForUpdate = true,
			includeInQuickFilter = true
	)
	private String nomComercial;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String domiciliComercial;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private CodiPostal codiPostalComercial;
	
	@NotNull
	@Size(max = 40)
	@RestapiField(includeInQuickFilter = true)
	private String nomFiscal;
	
	@NotNull
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String domiciliFiscal;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private CodiPostal codiPostalFiscal;
	
	@Transient
	@NotNull
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInGrid = true, hiddenInLov = true)
	private FacturacioTipusEnum facturacioTipus;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private Divisa divisa;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean recarrecEquivalencia;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInLov = true,
			hiddenInGrid = true)
	private String telefon;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String fax;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String email;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String web;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInGrid = true,
			hiddenInLov = true)
	private Magatzem magatzem;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	private TipusComptabilitatClientEnumDto comptabilitatClients;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	private TipusComptabilitatClientEnumDto comptabilitatProveidors;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String comptabilitatAssentamentTipus;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String diarioFactProveedores;
	
	@Size(max = 2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String diarioProfProveedores;
	
	@Size(max = 60)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String comptabilitatCodi;
	
	@Size(max = 250)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	private String registreMercantil;
	
	@Digits(integer=10, fraction=2)
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Digits(integer=10, fraction=2) 
	private BigDecimal valorFacturacio;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean regimCriteriCaixa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			hiddenInLov=true)
	private TipusPersonaEnumDto personaTipus;
	
	@Transient
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	private TipusEstrangerEnumDto tipoResidencia;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 40)
	private String nomFiscal1;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 40)
	private String llinatgeFiscal1;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 40)
	private String llinatgeFiscal2;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private boolean logoImprimir;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 300)
	private String logoPath;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = true)
	private Date tancamentData;

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInForm = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class EmpresaFactPk implements Serializable {
		private String identificadorCodi;	
		private String codi;
	}

}
