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

import org.springframework.data.domain.Sort.Direction;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExistsWithZeros;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientPreuConverter;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientProjecteTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.InversioTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ObraTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.ProjecteEstatConverter;
import es.limit.cecocloud.fact.logic.api.converter.RetencioTipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusExecucioConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusGestioConverter;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.Expedient.ExpedientPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Producte.ProductePk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientPreuEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientProjecteTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.InversioTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ObraTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.ProjecteEstatEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RetencioTipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusExecucioEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusGestioEnumDto;
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
@PrimaryKeyNotExistsWithZeros(numZeros = 6, fields = "codi", groups = { OnCreate.class })
@RestapiResource(
		descriptionField = "nom"
)
public class Projecte extends AbstractIdentificableWithIdentificador<ProjectePk> {	
//	@NotNull(groups = {OnCreate.class})
	@Size(max = 6)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase = true,
			includeInQuickFilter = true)
	public String codi;	
	
	@Size(max = 250)
	@RestapiField(			
			hiddenInLov = true)
	private String nom;
	
	@Digits(integer = 7, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal divisaValorEuros;
	
	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			type = RestapiFieldType.TEXTAREA)
	private String descripcio;
	
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	private Date dataInici;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = false,
			hiddenInLov = true)
	private Date dataFi;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String responsable;
	
	@Digits(integer = 12, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal valorEstimat;

	@Size(max = 1000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String observacions;	

	@NotNull
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
	
	@Digits(integer = 12, fraction = 3)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal importFianca;
	
	@Size(max = 250)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String dipositFianca;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataDevolucioAval;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataRecepcioFinal;
	
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String direccioTecnica;
	
	@Size(max = 35)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String codiAlternatiu;
	
	@RestapiField(
			dynamicEnumCode = "PRJ_LSTEST",
			hiddenInGrid = false,
			hiddenInLov = true)
	@Convert(converter = ProjecteEstatConverter.class)
	private ProjecteEstatEnumDto estat;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean albaransClientCrear = false;
	
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
	private Boolean dietes = false;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String comptabilitatCodiProjecte;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = RetencioTipusConverter.class)
	private RetencioTipusEnumDto retencioTipus;
	
	@Digits(integer = 3, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal retencioPercent;	
	
	@Size(max = 20)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String referencia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean plusPerillositat = false;
	
	@Digits(integer = 13, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal estudiDespesesGenerals;	
	
	@Digits(integer = 7, fraction = 8)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal estudiBaixaPercent;
	
	@Digits(integer = 3, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal estudiTasaPercent;	
		
	@Size(max = 60)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String contactePersona;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String contacteTelefon;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean estudiSumarValoracioEnExces = false;	
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String dricmp;
	
	@Size(max = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String dricmp002;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFiPrevist;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal mesosGarantia;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal percentExecucioLliure;
	
	@NotNull
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal horesEquiv;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal percentExecucioConstruccio;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal horesEquivConstruccio;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal percentExecucioGarantia;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal horesEquivGarantia;
	
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
	@Convert(converter = StringBooleanConverter.class)
	private Boolean controlarCostos = false;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal horesCami;
	
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
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataIniciGarantia;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean multiclient = false;
	
	@RestapiField(
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFinalGarantia;
	
	@Digits(integer = 3, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal kmt;
	
	@NotNull
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TipusExecucioConverter.class)
	private TipusExecucioEnumDto tipusExecucio;	
	
	@Digits(integer = 13, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal preuMigFacturacio;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private Date dataFormalitzacio;
	
	@Size(max = 3000)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			type = RestapiFieldType.TEXTAREA)
	private String tecnologies;
	
	@Size(max = 500)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String descripcioCurta;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal pteinccstmo;
	
	@Digits(integer = 5, fraction = 2)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal pteinccstmaq;
	
	@Digits(integer = 14, fraction = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impfixmo;
	
	@Digits(integer = 14, fraction = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			sizeMax = 22)
	private BigDecimal impfixmaq;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean exportarMobil = false;
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = TipusGestioConverter.class)
	private TipusGestioEnumDto tipusGestio;	
	
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean cpa = false;
	
	////////////////////////////////////REFERIDES A CODIS PERÒ SENSE SER RELACIO  A TAULES /////////////////////////////////////////////////////////
	@Size(max = 15)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String articleCodi001;
	
	@Size(max = 15)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String articleCodi002;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiCodi001;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiCodi002;
	
	@Size(max = 4)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiCodi003;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String unitatControlEstudiCodi001;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String unitatControlEstudiCodi002;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String unitatControlEstudiCodi003;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiLiniaCodi001;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiLiniaCodi002;
	
	@Size(max = 30)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true)
	private String estudiLiniaCodi003;
	
	@Size(max = 64)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private String createdBy;
	
	@Size(max = 64)
	@RestapiField(
			hiddenInGrid = true,
			hiddenInLov = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private String createdDate;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Transient	
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;
	
	@Transient
	@NotNull
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descDivisaNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = false,
			lovDescriptionField = "descNomComCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nomComercial",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Client, WithIdentificadorAndCodiPk<String>> client;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descCliAdreComCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<ClientAdresa, ClientAdresaPk> clientAdresa;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descSubcliNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<SubClient, SubClientPk> subClient;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descFinalNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<FinalFactura, WithIdentificadorAndCodiPk<String>> finalFactura;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descNomCodi",
					lovSortFields =  {
							@RestapiSort(
									field = "nom",
									direction = Direction.ASC
									)
							})
	private GenericReferenceWithCompositePk<ProjecteTipus, WithIdentificadorAndCodiPk<String>> projecteTipus;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU,
			lovDescriptionField = "descOpeNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariResponsable;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descripcioCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "des",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<ClasseRetencio, WithIdentificadorAndCodiPk<String>> classeRetencio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU,
			lovDescriptionField = "descOpeEncNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariEncarregat;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descSerieNomCodi",
					lovSortFields =  {
							@RestapiSort(
									field = "codi",
									direction = Direction.ASC
									)
							})
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;	

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "nomCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;	
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU,
			lovDescriptionField = "descOpeCapNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariCapGrup;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovNamedFilter = Operari.FILTER_ACTIU_ADO,
			lovDescriptionField = "descOpeAdmNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operariAdministratiu;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descripcioCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "descripcio",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descSerieNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<SerieIntracomunitaria, SerieIntracomunitariaPk> serieIntracomunitaria;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descripcioPercentatgeCodiTxt",
			lovSortFields =  {
					@RestapiSort(
							field = "codi",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descAreNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<AreaNegoci, AreaNegociPk> areaNegoci;	

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descPostNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "poblacio",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descMagatzemNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Magatzem, WithIdentificadorAndCodiPk<String>> magatzem;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true
			)
	private GenericReferenceWithCompositePk<Producte, ProductePk> producte;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descSeccComCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Seccio, SeccioPk> seccio;
	
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			hiddenInGrid = true,
			lovDescriptionField = "descExpNomCodi",
			lovSortFields =  {
					@RestapiSort(
							field = "nom",
							direction = Direction.ASC
							)
					})
	private GenericReferenceWithCompositePk<Expedient, ExpedientPk> expedient;
		
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
