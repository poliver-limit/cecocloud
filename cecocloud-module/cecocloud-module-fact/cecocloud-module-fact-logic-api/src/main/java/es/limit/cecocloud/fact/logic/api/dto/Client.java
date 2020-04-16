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
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.GenericReferenceWithCompositePk;
import es.limit.base.boot.logic.api.dto.Identificable.OnCreate;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.validation.PrimaryKeyNotExists;
import es.limit.base.boot.logic.api.validation.DocumentIdentitat;
import es.limit.cecocloud.fact.logic.api.converter.AlbaraClientSubtipusConverter;
import es.limit.cecocloud.fact.logic.api.converter.EnviamentFacturaConverter;
import es.limit.cecocloud.fact.logic.api.converter.RebutsConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusDescompteConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusEstrangerConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusFacturaConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusMissatgeConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusNifConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusPersonaConverter;
import es.limit.cecocloud.fact.logic.api.converter.TipusRetencioConverter;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientSubtipusEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.EnviamentFacturaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.RebutsEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusDescompteEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusEstrangerEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusFacturaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusMissatgeEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusNifEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusPersonaEnumDto;
import es.limit.cecocloud.fact.logic.api.dto.enums.TipusRetencioEnumDto;
import es.limit.cecocloud.logic.api.converter.StringBooleanConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació de un client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@PrimaryKeyNotExists(fields = "codi", groups = { OnCreate.class })
//@DocumentIdentitat(field = "nif", groups = { OnCreate.class })
@RestapiResource(descriptionField = "nomComercial")

public class Client extends AbstractIdentificableWithIdentificadorAndCodi<String> {

//	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;

	@NotNull
	@RestapiField(includeInQuickFilter = true, 	disabledForCreate = false, disabledForUpdate = true)
	@Size(max = 40)
	private String nomComercial;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean bloquejat = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean potencial = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = RebutsConverter.class)
	private RebutsEnumDto rebuts;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean recarrecEquivalencia = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean albaraValorat = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusFacturaConverter.class)
	private TipusFacturaEnumDto tipusFactura;

	@Size(max = 40)
	@RestapiField(hiddenInLov = true)
	private String nomFiscal;

	@Size(max = 30)
	@RestapiField(hiddenInLov = true)
	private String alias;

	@Size(max = 12)
	@RestapiField(hiddenInLov = true)
	@DocumentIdentitat()
	private String nif;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliFiscal;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String telefon;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String fax;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String email;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String adresaWeb;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String personaContacte;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = EnviamentFacturaConverter.class)
	private EnviamentFacturaEnumDto enviamentFactura;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal facturacioMinima;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float descompteComptats;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float descompteTermini;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusDescompteConverter.class)
	private TipusDescompteEnumDto tipusDescompte;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal riscMaxim;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float percentatgeRetencio;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusRetencioConverter.class)
	private TipusRetencioEnumDto tipusRetencio;

	@Size(max = 10)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String compteContable;

	@Size(max = 10)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String compteVentesComptabilitat;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Long numeroCC;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String digitsControl;

	@Size(max = 2000)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String observacions;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxt1;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxt2;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxt3;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxt4;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxt5;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNum1;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNum2;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNum3;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNum4;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNum5;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean facturesSenseDescompte = false;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Integer copiesFactura;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean entitatPublica = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean censadoAEAT = false;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Date proximaVisitaComercial;

	@Size(max = 4)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String situacioComercialCodi;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxtComercial1;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxtComercial2;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxtComercial3;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxtComercial4;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String parametreTxtComercial5;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNumComercial1;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNumComercial2;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNumComercial3;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNumComercial4;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal parametreNumComercial5;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float descompteFinalFacturesComptatClase1;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float descompteFinalFacturesTerminiClase1;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Float percentatgePermesFacturesClase1;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean mostrarPercentatgeFacturacioClase1 = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean aplicarPreusPerVolum = false;

	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String nomDomicili;

	@Size(max = 5)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String numeroDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String escalaDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String pisDomicili;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String portaDomicili;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal riscLimit;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusMissatgeConverter.class)
	private TipusMissatgeEnumDto tipusMissatge;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = AlbaraClientSubtipusConverter.class)
	private AlbaraClientSubtipusEnumDto albaraClientSubtipus;

	@Size(max = 100)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String emailFactura;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean publicarDocumentsWeb = false;

	@Size(max = 1000)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String observacionsFactura;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean aplicarImpostPuntVerd = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean aplicarImpostServei = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean impostInclos = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean permesEntrarPartes = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusNifConverter.class)
	private TipusNifEnumDto tipusNif;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String paisIban;

	@Size(max = 2)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String digitsControlIban;

	@Size(max = 11)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String bicIban;

	@Size(max = 100)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String emailEnviamentAlbarans;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean noImprimirSubclient = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean noImprimirPaletsRetornats = false;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal latitud;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private BigDecimal longitud;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusPersonaConverter.class)
	private TipusPersonaEnumDto tipusPersona;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = TipusEstrangerConverter.class)
	private TipusEstrangerEnumDto tipusEstranger;

	@Size(max = 40)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String nomFiscal001;

	@Size(max = 40)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String llinatgeFiscal001;

	@Size(max = 40)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String llinatgeFiscal002;

	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String oficinaComptable;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliOficinaComptable;

	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String organGestor;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliOrganGestor;

	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String unitatTramitadora;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String domiciliUnitatTramitadora;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String telefonFacturaElectronica;

	@Size(max = 60)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String emailFacturaElectronica;

	@Size(max = 255)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String contacteFacturaElectronica;

	@Size(max = 35)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String referenciaUnicaMandat;

	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private Date dataFirmaMandat;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean facturaElectronica = false;

//	@Size(max = 1)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	@Convert(converter = StringBooleanConverter.class)
	private Boolean cobrarDiesLloguer = false;	

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Divisa, WithIdentificadorAndCodiPk<String>> divisa;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusVenciment, WithIdentificadorAndCodiPk<String>> tipusVenciment1;
	
	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReference<TipusAdresa, String> tipusAdresa;
	

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<RegimIva, WithIdentificadorAndCodiPk<String>> regimIva;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Rappel, WithIdentificadorAndCodiPk<String>> rappel;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<DocumentPagamentCobrament, WithIdentificadorAndCodiPk<String>> documentPagament;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusFacturacio, WithIdentificadorAndCodiPk<String>> tipusFacturacio;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<FamiliaClient, WithIdentificadorAndCodiPk<String>> familiaClient;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostal;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Idioma, WithIdentificadorAndCodiPk<String>> idioma;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Zona, WithIdentificadorAndCodiPk<String>> zona;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Empresa, WithIdentificadorAndCodiPk<String>> empresa;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<SerieVenda, SerieVendaPk> serie;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Iva, WithIdentificadorAndCodiPk<String>> iva;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa1;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Tarifa, WithIdentificadorAndCodiPk<String>> tarifa2;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Banc, WithIdentificadorAndCodiPk<Integer>> banc;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<OficinaBancaria, OficinaBancariaPk> oficinaBancaria;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Transportista, WithIdentificadorAndCodiPk<String>> transportista;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<Operari, es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk<String>> operari;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ClasseRetencio, WithIdentificadorAndCodiPk<String>> claseRetencio;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<ClientAdresa, ClientAdresaPk> adresaComercialClient;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV)
	private GenericReferenceWithCompositePk<Organitzacio, WithIdentificadorAndCodiPk<String>> organitzacio;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TarifaDescompte, WithIdentificadorAndCodiPk<String>> tarifaDescompte;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TipusComissio, WithIdentificadorAndCodiPk<String>> tipusComissio;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true, lovDescriptionField = "nomCodiTxt")
	private GenericReference<PaisNif, String> paisNif;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<TarifaDescompte, WithIdentificadorAndCodiPk<String>> tarifaDescompte2;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalOficinaComptable;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalOrganGestor;

	@Transient
	@RestapiField(type = RestapiFieldType.LOV, hiddenInGrid = true)
	private GenericReferenceWithCompositePk<CodiPostal, WithIdentificadorAndCodiPk<String>> codiPostalUnitatTramitadora;

}
