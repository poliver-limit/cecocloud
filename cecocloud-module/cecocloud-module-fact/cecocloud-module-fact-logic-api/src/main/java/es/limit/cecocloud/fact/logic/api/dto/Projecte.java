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
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientPreuConverter;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientProjecteTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ProjecteEstatConverter;
import es.limit.cecocloud.fact.logic.api.converter.RetencioTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.InversioTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ObraTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusExecucioConverter;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientPreuEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientProjecteTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ProjecteEstatEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RetencioTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.InversioTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ObraTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusExecucioEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
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
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
@RestapiResource(
		descriptionField = "nom"
)
public class Projecte extends AbstractIdentificableWithIdentificador<ProjectePk> {	
	@NotNull(groups = {OnCreate.class})
	@Size(max = 6)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	private String codi;
	
	@NotNull
	@Size(max = 250)
	@RestapiField(			
			hiddenInLov = true)
	private String nom;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;
	
//	@Size(max = 35)
//	@RestapiField(
//			hiddenInGrid = true,
//			hiddenInLov = true)
//	private String codiAlternatiu;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String responsable;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true
			)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true
			)
	private GenericReferenceWithCompositePk<Seccio, SeccioPk> seccio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal valorEstimat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<FinalFactura, WithIdentificadorAndCodiPk<String>> finalFactura;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ProjecteTipus, WithIdentificadorAndCodiPk<String>> projecteTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false)
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	@Convert(converter = ProjecteEstatConverter.class)
	private ProjecteEstatEnumDto estat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariResponsable;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariCapGrup;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariEncarregat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU_ADO)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariAdministratiu;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean dietes = false;
	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean plusPerillositat = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean albaransClientCrear = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = AlbaraClientProjecteTipusConverter.class)
	private AlbaraClientProjecteTipusEnumDto albaransClientProjecteTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ClasseRetencio, WithIdentificadorAndCodiPk<String>> retencioClasse;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<AreaNegoci, AreaNegociPk> areaNegoci;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SerieIntracomunitaria, SerieIntracomunitariaPk> serieIntracomunitaria;

	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcioCurta;
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			type = RestapiFieldType.TEXTAREA)
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
	
	@Size(max = 100)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String poblacio;
	
	@Size(max = 2000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			type = RestapiFieldType.TEXTAREA)
	private String tecnologies;
	
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
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean multiclient = false;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	private Date dataInici;
	
	@RestapiField(
			hiddenInGrid = false,
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
	private Date dataFinalGarantia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataDevolucioAval;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFormalitzacio;
	
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
	
//	@RestapiField(
//			hiddenInGrid = true,
//			hiddenInLov = true)
//	private BigDecimal divisaValorEuros;
	
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
	@Convert(converter = AlbaraClientPreuConverter.class)
	private AlbaraClientPreuEnumDto albaransClientPreu;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TipusExecucioConverter.class)
	private TipusExecucioEnumDto tipusExecucio;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean controlarCostos = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean exportarMobil = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal preuMigFacturacio;
	
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
	private Boolean estudiSumarValoracioEnExces = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private BigDecimal mesosGarantia;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = InversioTipusConverter.class)
	private InversioTipusEnumDto tipusInversio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = ObraTipusConverter.class)
	private ObraTipusEnumDto tipusObra;
	
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
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;	
		
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
