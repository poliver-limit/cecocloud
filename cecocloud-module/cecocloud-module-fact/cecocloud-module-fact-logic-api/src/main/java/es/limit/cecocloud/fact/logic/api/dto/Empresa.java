/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.fact.logic.api.converter.FacturacioTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusComptabilitatClientConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusEstrangerConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusPersonaConverter;
import es.limit.cecocloud.fact.logic.api.dto.enums.FacturacioTipusEnum;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusComptabilitatClientEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusEstrangerEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusPersonaEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import lombok.Getter;
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
public class Empresa extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@Size(max = 4)
	@NotNull
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
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalComercial;
	
	@NotNull
	@Size(max = 40)
	@RestapiField(includeInQuickFilter = true,
			hiddenInGrid = true)
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
			hiddenInLov = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalFiscal;
	
	@NotNull
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = FacturacioTipusConverter.class)
	private FacturacioTipusEnum facturacioTipus;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,			
			hiddenInLov = true)	
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;	
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean recarrecEquivalencia;
	
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
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = TipusComptabilitatClientConverter.class)
	private TipusComptabilitatClientEnumDto comptabilitatClients;
	
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = TipusComptabilitatClientConverter.class)
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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean regimCriteriCaixa;	
	
	@RestapiField(
			type = RestapiFieldType.ENUM,
			hiddenInGrid = true,
			hiddenInLov=true)
	@Convert(converter = TipusPersonaConverter.class)
	private TipusPersonaEnumDto personaTipus;
	
	@RestapiField(type = RestapiFieldType.ENUM, hiddenInLov = true,
			hiddenInGrid = true)
	@Convert(converter = TipusEstrangerConverter.class)
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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean logoImprimir;
	
	@RestapiField(hiddenInLov = true,
			hiddenInGrid = true)
	@Size(max = 300)
	private String logoPath;
	
	@RestapiField(
			hiddenInLov = true, 
			hiddenInGrid = true)
	private Date tancamentData;

}
