/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientPreuConverter;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientProjecteTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ProjecteEstatConverter;
import es.limit.cecocloud.fact.logic.api.converter.RetencioTipusConverter;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientPreuEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientProjecteTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ProjecteEstatEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RetencioTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "codi"
)
public class Projecte extends AbstractIdentificableWithIdentificador<ProjectePk> {
	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 6)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Size(max = 6)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String numero;
	
	@NotNull
	@Size(max = 250)
	@RestapiField(			
			hiddenInLov = true)
	private String nom;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true
			)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;

	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcio;
	
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String referencia;
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;
	
	@Size(max = 35)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiAlternatiu;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String responsable;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ProjecteTipus, WithIdentificadorAndCodiPk<String>> projecteTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariResponsable;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariCapGrup;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariEncarregat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariAdministratiu;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String contactePersona;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String contacteTelefon;
	
	@Size(max = 200)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String adreca;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ClientAdresa, ClientAdresaPk> clientAdresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = ProjecteEstatConverter.class)
	private ProjecteEstatEnumDto estat;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataInici;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFi;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFiPrevist;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataAdjudicacio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataExecucio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataRecepcioProvisional;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataRecepcioFinal;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataIniciGarantia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataDevolucioAval;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal horesEquiv;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal horesEquivConstruccio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal horesEquivGarantia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentExecucioLliure;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentExecucioConstruccio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal percentExecucioGarantia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal divisaValorEuros;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal valorEstimat;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal importFianca;
	
	@Size(max = 250)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String dipositFianca;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String direccioTecnica;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean albaransClientCrear;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = AlbaraClientPreuConverter.class)
	private AlbaraClientPreuEnumDto albaransClientPreu;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = AlbaraClientProjecteTipusConverter.class)
	private AlbaraClientProjecteTipusEnumDto albaransClientProjecteTipus;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean dietes;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean plusPerillositat;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean controlarCostos;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal horesCami;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal estudiDespesesGenerals;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal estudiBaixaPercent;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal estudiTasaPercent;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean estudiSumarValoracioEnExces;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal mesosGarantia;
	
	@Size(max = 1)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String tipusInversio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ClasseRetencio, WithIdentificadorAndCodiPk<String>> retencioClasse;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal retencioPercent;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = RetencioTipusConverter.class)
	private RetencioTipusEnumDto retencioTipus;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String comptabilitatCodiProjecte;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<AreaNegoci, AreaNegociPk> areaNegoci;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<FinalFactura, WithIdentificadorAndCodiPk<String>> finalFactura;
	
		
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class ProjectePk extends WithIdentificadorAndCodiPk<String> {
		private String empresaCodi;
		public ProjectePk(
				String identificadorCodi,
				String empresaCodi,
				String codi) {
			super(identificadorCodi, codi);
			this.empresaCodi = empresaCodi;
		}
	}
}
