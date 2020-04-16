/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.listener.ClientEntityListener;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tges_cli", indexes = { @Index(name = "iges_cli_idf_fk", columnList = "cli_idf_cod"),
		@Index(name = "irges_cli_pk", columnList = "cli_idf_cod,cli_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cli_idf_cod", length = 4)), // hauria de ser 6
		@AttributeOverride(name = "id.codi", column = @Column(name = "cli_cod", length = 6)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "cli_cod", length = 6, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "cli_nomcom", length = 40, nullable = false)),
		@AttributeOverride(name = "embedded.bloquejat", column = @Column(name = "cli_blo", length = 1)),
		@AttributeOverride(name = "embedded.potencial", column = @Column(name = "cli_pot", length = 1)),
		@AttributeOverride(name = "embedded.rebuts", column = @Column(name = "cli_reb", length = 1)),
		@AttributeOverride(name = "embedded.recarrecEquivalencia", column = @Column(name = "cli_recequ", length = 1)),
		@AttributeOverride(name = "embedded.albaraValorat", column = @Column(name = "cli_albval", length = 1)),
		@AttributeOverride(name = "embedded.tipusFactura", column = @Column(name = "cli_tipfac", length = 1)),
		@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "cli_nomfis", length = 40)),
		@AttributeOverride(name = "embedded.alias", column = @Column(name = "cli_ali", length = 30)),
		@AttributeOverride(name = "embedded.nif", column = @Column(name = "cli_nif", length = 12)),
		@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "cli_domfis", length = 60)),
		@AttributeOverride(name = "embedded.telefon", column = @Column(name = "cli_tel", length = 60)),
		@AttributeOverride(name = "embedded.fax", column = @Column(name = "cli_fax", length = 60)),
		@AttributeOverride(name = "embedded.email", column = @Column(name = "cli_eml", length = 60)),
		@AttributeOverride(name = "embedded.adresaWeb", column = @Column(name = "cli_www", length = 60)),
		@AttributeOverride(name = "embedded.personaContacte", column = @Column(name = "cli_con", length = 60)),
		@AttributeOverride(name = "embedded.enviamentFactura", column = @Column(name = "cli_envfac", length = 1)),
		@AttributeOverride(name = "embedded.facturacioMinima", column = @Column(name = "cli_facmin")),
		@AttributeOverride(name = "embedded.descompteComptats", column = @Column(name = "cli_dtectt")),
		@AttributeOverride(name = "embedded.descompteTermini", column = @Column(name = "cli_dtepla")),
		@AttributeOverride(name = "embedded.tipusDescompte", column = @Column(name = "cli_tipdte")),
		@AttributeOverride(name = "embedded.riscMaxim", column = @Column(name = "cli_rismax")),
		@AttributeOverride(name = "embedded.percentatgeRetencio", column = @Column(name = "cli_ret")),
		@AttributeOverride(name = "embedded.percentatgeRetencio", column = @Column(name = "cli_ret")),
		@AttributeOverride(name = "embedded.tipusRetencio", column = @Column(name = "cli_tipret", length = 1)),
		@AttributeOverride(name = "embedded.compteContable", column = @Column(name = "cli_ctecmp", length = 10)),
		@AttributeOverride(name = "embedded.compteVentesComptabilitat", column = @Column(name = "cli_cteven", length = 10)),
		@AttributeOverride(name = "embedded.numeroCC", column = @Column(name = "cli_ccr")),
		@AttributeOverride(name = "embedded.digitsControl", column = @Column(name = "cli_dcc", length = 2)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "cli_obs", length = 2000)),
		@AttributeOverride(name = "embedded.parametreTxt1", column = @Column(name = "cli_partxt001", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxt2", column = @Column(name = "cli_partxt002", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxt3", column = @Column(name = "cli_partxt003", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxt4", column = @Column(name = "cli_partxt004", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxt5", column = @Column(name = "cli_partxt005", length = 60)),
		@AttributeOverride(name = "embedded.parametreNum1", column = @Column(name = "cli_parnum001")),
		@AttributeOverride(name = "embedded.parametreNum2", column = @Column(name = "cli_parnum002")),
		@AttributeOverride(name = "embedded.parametreNum3", column = @Column(name = "cli_parnum003")),
		@AttributeOverride(name = "embedded.parametreNum4", column = @Column(name = "cli_parnum004")),
		@AttributeOverride(name = "embedded.parametreNum5", column = @Column(name = "cli_parnum005")),
		@AttributeOverride(name = "embedded.facturesSenseDescompte", column = @Column(name = "cli_facsendte", length = 1)),
		@AttributeOverride(name = "embedded.copiesFactura", column = @Column(name = "cli_copfac")),
		@AttributeOverride(name = "embedded.entitatPublica", column = @Column(name = "cli_ettpub", length = 1)),
		@AttributeOverride(name = "embedded.censadoAEAT", column = @Column(name = "cli_rgtaea", length = 1)),
		@AttributeOverride(name = "embedded.proximaVisitaComercial", column = @Column(name = "cli_viscmlprt")),
		@AttributeOverride(name = "embedded.situacioComercialCodi", column = @Column(name = "cli_stc_cod", length = 4)),
		@AttributeOverride(name = "embedded.parametreTxtComercial1", column = @Column(name = "cli_partxtcom001", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxtComercial2", column = @Column(name = "cli_partxtcom002", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxtComercial3", column = @Column(name = "cli_partxtcom003", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxtComercial4", column = @Column(name = "cli_partxtcom004", length = 60)),
		@AttributeOverride(name = "embedded.parametreTxtComercial5", column = @Column(name = "cli_partxtcom005", length = 60)),
		@AttributeOverride(name = "embedded.parametreNumComercial1", column = @Column(name = "cli_parnumcom001")),
		@AttributeOverride(name = "embedded.parametreNumComercial2", column = @Column(name = "cli_parnumcom002")),
		@AttributeOverride(name = "embedded.parametreNumComercial3", column = @Column(name = "cli_parnumcom003")),
		@AttributeOverride(name = "embedded.parametreNumComercial4", column = @Column(name = "cli_parnumcom004")),
		@AttributeOverride(name = "embedded.parametreNumComercial5", column = @Column(name = "cli_parnumcom005")),
		@AttributeOverride(name = "embedded.descompteFinalFacturesComptatClase1", column = @Column(name = "cli_dtectt001")),
		@AttributeOverride(name = "embedded.descompteFinalFacturesTerminiClase1", column = @Column(name = "cli_dtepla001")),
		@AttributeOverride(name = "embedded.percentatgePermesFacturesClase1", column = @Column(name = "cli_ptefac001")),
		@AttributeOverride(name = "embedded.mostrarPercentatgeFacturacioClase1", column = @Column(name = "cli_avifac001")),
		@AttributeOverride(name = "embedded.aplicarPreusPerVolum", column = @Column(name = "cli_pvl", length = 1)),
		@AttributeOverride(name = "embedded.nomDomicili", column = @Column(name = "cli_nomdom", length = 30)),
		@AttributeOverride(name = "embedded.numeroDomicili", column = @Column(name = "cli_numdom", length = 5)),
		@AttributeOverride(name = "embedded.escalaDomicili", column = @Column(name = "cli_escdom", length = 2)),
		@AttributeOverride(name = "embedded.pisDomicili", column = @Column(name = "cli_pisdom", length = 2)),
		@AttributeOverride(name = "embedded.portaDomicili", column = @Column(name = "cli_pordom", length = 2)),
		@AttributeOverride(name = "embedded.riscLimit", column = @Column(name = "cli_rislim")),
		@AttributeOverride(name = "embedded.tipusMissatge", column = @Column(name = "cli_tipmsg", length = 1)),
		@AttributeOverride(name = "embedded.albaraClientSubtipus", column = @Column(name = "cli_albcls")),
		@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "cli_emlfac", length = 100)),
		@AttributeOverride(name = "embedded.publicarDocumentsWeb", column = @Column(name = "cli_pubweb", length = 1)),
		@AttributeOverride(name = "embedded.observacionsFactura", column = @Column(name = "cli_obsfac", length = 1000)),
		@AttributeOverride(name = "embedded.aplicarImpostPuntVerd", column = @Column(name = "cli_aplims", length = 1)),
		@AttributeOverride(name = "embedded.aplicarImpostServei", column = @Column(name = "cli_aplimpsrv", length = 1)),
		@AttributeOverride(name = "embedded.impostInclos", column = @Column(name = "cli_imsicl", length = 1)),
		@AttributeOverride(name = "embedded.permesEntrarPartes", column = @Column(name = "cli_ctlffo", length = 1)),
		@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "cli_tipnif", length = 1)),				
		@AttributeOverride(name = "embedded.paisIban", column = @Column(name = "cli_ibnpai", length = 2)),
		@AttributeOverride(name = "embedded.digitsControlIban", column = @Column(name = "cli_ibndcc", length = 2)),
		@AttributeOverride(name = "embedded.bicIban", column = @Column(name = "cli_ibnbic", length = 11)),
		@AttributeOverride(name = "embedded.emailEnviamentAlbarans", column = @Column(name = "cli_emlalb", length = 100)),
		@AttributeOverride(name = "embedded.noImprimirSubclient", column = @Column(name = "cli_notprnscl", length = 1)),
		@AttributeOverride(name = "embedded.noImprimirPaletsRetornats", column = @Column(name = "cli_notprnpal", length = 1)),
		@AttributeOverride(name = "embedded.latitud", column = @Column(name = "cli_lat")),
		@AttributeOverride(name = "embedded.longitud", column = @Column(name = "cli_lon")),
		@AttributeOverride(name = "embedded.tipusPersona", column = @Column(name = "cli_tipper", length = 1)),
		@AttributeOverride(name = "embedded.tipusEstranger", column = @Column(name = "cli_tipext", length = 1)),
		@AttributeOverride(name = "embedded.nomFiscal001", column = @Column(name = "cli_nomfis001", length = 40)),
		@AttributeOverride(name = "embedded.llinatgeFiscal001", column = @Column(name = "cli_llnfis001", length = 40)),
		@AttributeOverride(name = "embedded.llinatgeFiscal002", column = @Column(name = "cli_llnfis002", length = 40)),
		@AttributeOverride(name = "embedded.oficinaComptable", column = @Column(name = "cli_oficmp", length = 30)),
		@AttributeOverride(name = "embedded.domiciliOficinaComptable", column = @Column(name = "cli_domoficmp", length = 60)),
		@AttributeOverride(name = "embedded.organGestor", column = @Column(name = "cli_orgges", length = 30)),
		@AttributeOverride(name = "embedded.domiciliOrganGestor", column = @Column(name = "cli_domorgges", length = 60)),
		@AttributeOverride(name = "embedded.unitatTramitadora", column = @Column(name = "cli_unitrm", length = 30)),
		@AttributeOverride(name = "embedded.domiciliUnitatTramitadora", column = @Column(name = "cli_domunitrm", length = 60)),
		@AttributeOverride(name = "embedded.telefonFacturaElectronica", column = @Column(name = "cli_telfacele", length = 60)),
		@AttributeOverride(name = "embedded.emailFacturaElectronica", column = @Column(name = "cli_emlfacele", length = 60)),
		@AttributeOverride(name = "embedded.contacteFacturaElectronica", column = @Column(name = "cli_confacele", length = 255)),
		@AttributeOverride(name = "embedded.referenciaUnicaMandat", column = @Column(name = "cli_banrefmdl019", length = 35)),
		@AttributeOverride(name = "embedded.dataFirmaMandat", column = @Column(name = "cli_bandatfirmdl019")),
		@AttributeOverride(name = "embedded.facturaElectronica", column = @Column(name = "cli_facele")),
		@AttributeOverride(name = "embedded.cobrarDiesLloguer", column = @Column(name = "cli_cobdiallo")),
		@AttributeOverride(name = "createdBy", column = @Column(name = "cli_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "cli_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cli_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cli_datmod")) 
})
		@AssociationOverrides({ 
				@AssociationOverride(
						name = "identificador", joinColumns = {
								@JoinColumn(name = "cli_idf_cod", insertable = false, updatable = false) }, 
						foreignKey = @ForeignKey(name = "rges_cli_idf_fk")) 
})
@EntityListeners({ClientEntityListener.class})
public class ClientEntity extends AbstractWithIdentificadorAuditableEntity<Client, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Client embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_div_cod_fk"))
	private DivisaEntity divisa;
	@Column(name = "cli_div_cod", length = 4)
	private String divisaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tve_cod_fk"))
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "cli_tve_cod", length = 4)
	private String tipusVencimentCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {						
						@JoinColumn(name = "cli_sgl", referencedColumnName = "tad_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_sgl_cod_fk"))
	private TipusAdresaEntity tipusAdresa;
	@Column(name = "cli_sgl", length = 4)
	private String tipusAdresaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tve_cod001", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tve_cod001_fk"))
	private TipusVencimentEntity tipusVenciment1;
	@Column(name = "cli_tve_cod001", length = 4)
	private String tipusVenciment1Codi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_rgi_cod_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "cli_rgi_cod", length = 2)
	private String regimIvaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "rap_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_rap_cod", referencedColumnName = "rap_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_rap_cod_fk"))
	private RappelEntity rappel;
	@Column(name = "cli_rap_cod", length = 4)
	private String rappelCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_dpg_cod_fk"))
	private DocumentPagamentCobramentEntity documentPagament;
	@Column(name = "cli_dpg_cod", length = 4)
	private String documentPagamentCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tfc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tfc_cod", referencedColumnName = "tfc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tfc_cod_fk"))
	private TipusFacturacioEntity tipusFacturacio;
	@Column(name = "cli_tfc_cod", length = 4)
	private String tipusFacturacioCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "fmc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_fmc_cod", referencedColumnName = "fmc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_fmc_cod_fk"))
	private FamiliaClientEntity familiaClient;
	@Column(name = "cli_fmc_cod", length = 4)
	private String familiaClientCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "cli_cpo_cod", length = 8)
	private String codiPostalCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_idi_cod_fk"))
	private IdiomaEntity idioma;
	@Column(name = "cli_idi_cod", length = 4)
	private String idiomaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_zon_cod", referencedColumnName = "zon_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_zon_cod_fk"))
	private ZonaEntity zona;
	@Column(name = "cli_zon_cod", length = 4)
	private String zonaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_emp_codser", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_emp_codser_fk"))
	private EmpresaEntity empresa;
	@Column(name = "cli_emp_codser", length = 4)
	private String empresaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_emp_codser", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_ser_cod_fk"))
	private SerieVendaEntity serie;
	@Column(name = "cli_ser_cod", length = 4)
	private String serieCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_iva_cod_fk"))
	private IvaEntity iva;
	@Column(name = "cli_iva_cod", length = 4)
	private String ivaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tar_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tar_cod001", referencedColumnName = "tar_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_tar_cod001_fk"))
	private TarifaEntity tarifa1;
	@Column(name = "cli_tar_cod001", length = 4)
	private String tarifa1Codi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tar_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tar_cod002", referencedColumnName = "tar_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tar_cod002_fk"))
	private TarifaEntity tarifa2;
	@Column(name = "cli_tar_cod002", length = 4)
	private String tarifa2Codi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "ban_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_ban_cod", referencedColumnName = "ban_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_ban_cod_fk"))
	private BancEntity banc;
	@Column(name = "cli_ban_cod")
	private Integer bancCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "ofb_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_ban_cod", referencedColumnName = "ofb_ban_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_ofb_cod", referencedColumnName = "ofb_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_ofb_cod_fk"))
	private OficinaBancariaEntity oficinaBancaria;
	@Column(name = "cli_ofb_cod")
	private Integer oficinaBancariaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tra_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tra_cod", referencedColumnName = "tra_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tra_cod_fk"))
	private TransportistaEntity transportista;
	@Column(name = "cli_tra_cod", length = 6)
	private String transportistaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_ope_cod_fk"))
	private OperariEntity operari;
	@Column(name = "cli_ope_cod", length = 6)
	private String operariCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "clr_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_clr_cod", referencedColumnName = "clr_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_clr_cod_fk"))
	private ClasseRetencioEntity claseRetencio;
	@Column(name = "cli_clr_cod", length = 4)
	private String claseRetencioCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_acc_cod_fk"))
	private ClientAdresaEntity adresaComercialClient;
	@Column(name = "cli_acc_cod", length = 4)
	private String adresaComercialClientCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "org_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_org_cod", referencedColumnName = "org_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_org_cod_fk"))
	private OrganitzacioEntity organitzacio;
	@Column(name = "cli_org_cod", length = 6)
	private String organitzacioCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tds_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tds_cod", referencedColumnName = "tds_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tds_cod_fk"))
	private TarifaDescompteEntity tarifaDescompte;
	@Column(name = "cli_tds_cod", length = 6)
	private String tarifaDescompteCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tcs_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tcs_cod", referencedColumnName = "tcs_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_tcs_cod_fk"))
	private TipusComissioEntity tipusComissio;
	@Column(name = "cli_tcs_cod", length = 4)
	private String tipusComissioCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "cli_painif", referencedColumnName = "pni_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_pni_cod_fk"))
	private PaisNifEntity paisNif;
	@Column(name = "cli_painif", length = 4)
	private String paisNifCodi;

	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tds_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tds_cod002", referencedColumnName = "tds_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tds_cod002_fk"))
	private TarifaDescompteEntity tarifaDescompte2;
	@Column(name = "cli_tds_cod002", length = 6)
	private String tarifaDescompte2Codi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_cpo_codoficmp", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_cpo_codoficmp_fk"))
	private CodiPostalEntity codiPostalOficinaComptable;
	@Column(name = "cli_cpo_codoficmp", length = 8)
	private String codiPostalOficinaComptableCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_cpo_codorgges", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_cpo_codorgges_fk"))
	private CodiPostalEntity codiPostalOrganGestor;
	@Column(name = "cli_cpo_codorgges", length = 8)
	private String codiPostalOrganGestorCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_cpo_codorgges", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_cpo_codunitrm_fk"))
	private CodiPostalEntity codiPostalUnitatTramitadora;
	@Column(name = "cli_cpo_codunitrm", length = 8)
	private String codiPostalUnitatTramitadoraCodi;

	@Builder
	public ClientEntity(
			WithIdentificadorAndCodiPk<String> pk, 
			Client embedded, 
			IdentificadorEntity identificador,
			DivisaEntity divisa, 
			TipusVencimentEntity tipusVenciment, 
			TipusVencimentEntity tipusVenciment1,
			TipusAdresaEntity tipusaAdresa,
			RegimIvaEntity regimIva, 
			RappelEntity rappel, 
			DocumentPagamentCobramentEntity documentPagament,
			TipusFacturacioEntity tipusFacturacio, 
			FamiliaClientEntity familiaClient, 
			CodiPostalEntity codiPostal,
			IdiomaEntity idioma, 
			ZonaEntity zona, 
			EmpresaEntity empresa, 
			SerieVendaEntity serie, 
			IvaEntity iva,
			TarifaEntity tarifa1, 
			TarifaEntity tarifa2, 
			BancEntity banc, 
			OficinaBancariaEntity oficinaBancaria,
			TransportistaEntity transportista, 
			OperariEntity operari, 
			ClasseRetencioEntity claseRetencio,
			ClientAdresaEntity adresaComercialClient, 
			OrganitzacioEntity organitzacio,
			TarifaDescompteEntity tarifaDescompte, 
			TipusComissioEntity tipusComissio, 
			TipusAdresaEntity tipusAdresa,
			PaisNifEntity paisNif, 
			TarifaDescompteEntity tarifaDescompte2, 
			CodiPostalEntity codiPostalOficinaComptable,
			CodiPostalEntity codiPostalOrganGestor, 
			CodiPostalEntity codiPostalUnitatTramitadora) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateDivisa(divisa);
		updateTipusVenciment(tipusVenciment);
		updateTipusVenciment1(tipusVenciment1);
		updateTipusAdresa(tipusAdresa);
		updateRegimIva(regimIva);
		updateRappel(rappel);
		updateDocumentPagament(documentPagament);
		updateTipusFacturacio(tipusFacturacio);
		updateFamiliaClient(familiaClient);
		updateCodiPostal(codiPostal);
		updateIdioma(idioma);
		updateZona(zona);
		updateEmpresa(empresa);
		updateSerie(serie);
		updateIva(iva);
		updateTarifa1(tarifa1);
		updateTarifa2(tarifa2);
		updateBanc(banc);
		updateOficinaBancaria(oficinaBancaria);
		updateTransportista(transportista);
		updateOperari(operari);
		updateClasseRetencio(claseRetencio);
		updateAdresaComercialClient(adresaComercialClient);
		updateOrganitzacio(organitzacio);
		updateTarifaDescompte(tarifaDescompte);
		updateTipusComissio(tipusComissio);
		updatePaisNif(paisNif);
		updateTarifaDescompte2(tarifaDescompte2);
		updateCodiPostalOficinaComptable(codiPostalOficinaComptable);
		updateCodiPostalOrganGestor(codiPostalOrganGestor);
		updateCodiPostalUnitatTramitadora(codiPostalUnitatTramitadora);
	}

	@Override
	public void update(Client embedded) {
		this.embedded = embedded;
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}

	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment != null) {
			this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
		}
	}

	public void updateTipusVenciment1(TipusVencimentEntity tipusVenciment1) {
		this.tipusVenciment1 = tipusVenciment1;
		if (tipusVenciment1 != null) {
			this.tipusVenciment1Codi = tipusVenciment1.getEmbedded().getCodi();
		}
	}
	
	public void updateTipusAdresa(TipusAdresaEntity tipusAdresa) {
		this.tipusAdresa = tipusAdresa;
		if (tipusAdresa != null) {
			this.tipusAdresaCodi = tipusAdresa.getEmbedded().getCodi();
		}
	}

	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		if (regimIva != null) {
			this.regimIvaCodi = regimIva.getEmbedded().getCodi();
		}
	}

	public void updateRappel(RappelEntity rappel) {
		this.rappel = rappel;
		if (rappel != null) {
			this.rappelCodi = rappel.getEmbedded().getCodi();
		}
	}

	public void updateDocumentPagament(DocumentPagamentCobramentEntity documentPagament) {
		this.documentPagament = documentPagament;
		if (documentPagament != null) {
			this.documentPagamentCodi = documentPagament.getEmbedded().getCodi();
		}
	}

	public void updateTipusFacturacio(TipusFacturacioEntity tipusFacturacio) {
		this.tipusFacturacio = tipusFacturacio;
		if (tipusFacturacio != null) {
			this.tipusFacturacioCodi = tipusFacturacio.getEmbedded().getCodi();
		}
	}

	public void updateFamiliaClient(FamiliaClientEntity familiaClient) {
		this.familiaClient = familiaClient;
		if (familiaClient != null) {
			this.familiaClientCodi = familiaClient.getEmbedded().getCodi();
		}
	}

	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
	}

	public void updateIdioma(IdiomaEntity idioma) {
		this.idioma = idioma;
		if (idioma != null) {
			this.idiomaCodi = idioma.getEmbedded().getCodi();
		}
	}

	public void updateZona(ZonaEntity zona) {
		this.zona = zona;
		if (zona != null) {
			this.zonaCodi = zona.getEmbedded().getCodi();
		}
	}

	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
		if (empresa != null) {
			this.empresaCodi = empresa.getEmbedded().getCodi();
		}
	}

	public void updateSerie(SerieVendaEntity serie) {
		this.serie = serie;
		if (serie != null) {
			this.serieCodi = serie.getEmbedded().getCodi();
		}
	}

	public void updateIva(IvaEntity iva) {
		this.iva = iva;
		if (iva != null) {
			this.ivaCodi = iva.getEmbedded().getCodi();
		}
	}

	public void updateTarifa1(TarifaEntity tarifa1) {
		this.tarifa1 = tarifa1;
		if (tarifa1 != null) {
			this.tarifa1Codi = tarifa1.getEmbedded().getCodi();
		}
	}

	public void updateTarifa2(TarifaEntity tarifa2) {
		this.tarifa2 = tarifa2;
		if (tarifa2 != null) {
			this.tarifa2Codi = tarifa2.getEmbedded().getCodi();
		}
	}

	public void updateBanc(BancEntity banc) {
		this.banc = banc;
		if (banc != null) {
			this.bancCodi = banc.getEmbedded().getCodi();
		}
	}

	public void updateOficinaBancaria(OficinaBancariaEntity oficinaBancaria) {
		this.oficinaBancaria = oficinaBancaria;
		if (oficinaBancaria != null) {
			this.oficinaBancariaCodi = oficinaBancaria.getEmbedded().getCodi();
		}
	}

	public void updateTransportista(TransportistaEntity transportista) {
		this.transportista = transportista;
		if (transportista != null) {
			this.transportistaCodi = transportista.getEmbedded().getCodi();
		}
	}

	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}

	public void updateClasseRetencio(ClasseRetencioEntity claseRetencio) {
		this.claseRetencio = claseRetencio;
		if (claseRetencio != null) {
			this.claseRetencioCodi = claseRetencio.getEmbedded().getCodi();
		}
	}

	public void updateAdresaComercialClient(ClientAdresaEntity adresaComercialClient) {
		this.adresaComercialClient = adresaComercialClient;
		if (adresaComercialClient != null) {
			this.adresaComercialClientCodi = adresaComercialClient.getEmbedded().getCodi();
		}
	}

	public void updateOrganitzacio(OrganitzacioEntity organitzacio) {
		this.organitzacio = organitzacio;
		if (organitzacio != null) {
			this.organitzacioCodi = organitzacio.getEmbedded().getCodi();
		}
	}

	public void updateTarifaDescompte(TarifaDescompteEntity tarifaDescompte) {
		this.tarifaDescompte = tarifaDescompte;
		if (tarifaDescompte != null) {
			this.tarifaDescompteCodi = tarifaDescompte.getEmbedded().getCodi();
		}
	}

	public void updateTipusComissio(TipusComissioEntity tipusComissio) {
		this.tipusComissio = tipusComissio;
		if (tipusComissio != null) {
			this.tipusComissioCodi = tipusComissio.getEmbedded().getCodi();
		}
	}

	public void updatePaisNif(PaisNifEntity paisNif) {
		this.paisNif = paisNif;
		if (paisNif != null) {
			this.paisNifCodi = paisNif.getId();
		}
	}

	public void updateTarifaDescompte2(TarifaDescompteEntity tarifaDescompte2) {
		this.tarifaDescompte2 = tarifaDescompte2;
		if (tarifaDescompte2 != null) {
			this.tarifaDescompte2Codi = tarifaDescompte2.getEmbedded().getCodi();
		}
	}

	public void updateCodiPostalOficinaComptable(CodiPostalEntity codiPostalOficinaComptable) {
		this.codiPostalOficinaComptable = codiPostalOficinaComptable;
		if (codiPostalOficinaComptable != null) {
			this.codiPostalOficinaComptableCodi = codiPostalOficinaComptable.getEmbedded().getCodi();
		}
	}

	public void updateCodiPostalOrganGestor(CodiPostalEntity codiPostalOrganGestor) {
		this.codiPostalOrganGestor = codiPostalOrganGestor;
		if (codiPostalOrganGestor != null) {
			this.codiPostalOrganGestorCodi = codiPostalOrganGestor.getEmbedded().getCodi();
		}
	}

	public void updateCodiPostalUnitatTramitadora(CodiPostalEntity codiPostalUnitatTramitadora) {
		this.codiPostalUnitatTramitadora = codiPostalUnitatTramitadora;
		if (codiPostalUnitatTramitadora != null) {
			this.codiPostalUnitatTramitadoraCodi = codiPostalUnitatTramitadora.getEmbedded().getCodi();
		}
	}

}
