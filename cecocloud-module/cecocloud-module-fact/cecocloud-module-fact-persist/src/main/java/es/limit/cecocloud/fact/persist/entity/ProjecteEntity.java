/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import java.util.Optional;
import java.util.regex.Pattern;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable;
import es.limit.cecocloud.fact.logic.api.dto.HistoricResponsable.HistoricResponsablePk;
import es.limit.cecocloud.fact.logic.api.dto.Projecte;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.fact.logic.api.dto.enums.OperariTipusEnumDto;
import es.limit.cecocloud.fact.persist.entity.ProjecteEntity.ProjecteEntityListener;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.fact.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.fact.persist.repository.HistoricResponsableRepository;
import es.limit.cecocloud.fact.persist.repository.ProjecteRepository;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tges_prj", indexes = { @Index(name = "iges_prj_idf_fk", columnList = "prj_idf_cod"),
		@Index(name = "irges_prj_pk", columnList = "prj_idf_cod,prj_num", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "prj_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "prj_emp_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "prj_num", length = 6)), // prj_num		
		
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "prj_num", length = 6, insertable = false, updatable = false)),		
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "prj_nom", length = 250, nullable = false)),
		@AttributeOverride(name = "embedded.divisaValorEuros", column = @Column(name = "prj_valdiveur", length = 22, precision = 15, scale = 8)),
		@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "prj_des", length = 1000)),
		@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "prj_datini")),
		@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "prj_datfin")),
		@AttributeOverride(name = "embedded.responsable", column = @Column(name = "prj_res", length = 60)),
		@AttributeOverride(name = "embedded.valorEstimat", column = @Column(name = "prj_valetm", length = 22, precision = 15, scale = 3)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "prj_obs", length = 1000)),
		@AttributeOverride(name = "embedded.dataAdjudicacio", column = @Column(name = "prj_diaadj")),
		@AttributeOverride(name = "embedded.dataExecucio", column = @Column(name = "prj_plaeje")),
		@AttributeOverride(name = "embedded.dataRecepcioProvisional", column = @Column(name = "prj_diarebpvi")),
		@AttributeOverride(name = "embedded.importFianca", column = @Column(name = "prj_impfia", length = 22, precision = 15, scale = 3)),
		@AttributeOverride(name = "embedded.dipositFianca", column = @Column(name = "prj_dipfia", length = 250)),
		@AttributeOverride(name = "embedded.dataDevolucioAval", column = @Column(name = "prj_diadevava")),
		@AttributeOverride(name = "embedded.dataRecepcioFinal", column = @Column(name = "prj_diarebfin")),
		@AttributeOverride(name = "embedded.direccioTecnica", column = @Column(name = "prj_dirtec", length = 60)),
		@AttributeOverride(name = "embedded.codiAlternatiu", column = @Column(name = "prj_ali", length = 35)),
		@AttributeOverride(name = "embedded.estat", column = @Column(name = "prj_est", length = 22, precision = 1)),
		@AttributeOverride(name = "embedded.albaransClientCrear", column = @Column(name = "prj_crealbcli", length = 1)),
		@AttributeOverride(name = "embedded.albaransClientPreu", column = @Column(name = "prj_prualbcli", length = 22, precision = 1)),
		@AttributeOverride(name = "embedded.albaransClientProjecteTipus", column = @Column(name = "prj_tip", length = 22, precision = 1)),
		@AttributeOverride(name = "embedded.dietes", column = @Column(name = "prj_dta", length = 1)),
		@AttributeOverride(name = "embedded.comptabilitatCodiProjecte", column = @Column(name = "prj_codcmp", length = 4)),
		@AttributeOverride(name = "embedded.retencioTipus", column = @Column(name = "prj_tipret", length = 1)),
		@AttributeOverride(name = "embedded.retencioPercent", column = @Column(name = "prj_ret", length = 22, precision = 5, scale = 2)),
		@AttributeOverride(name = "embedded.referencia", column = @Column(name = "prj_ref", length = 20)),
		@AttributeOverride(name = "embedded.plusPerillositat", column = @Column(name = "prj_plspel", length = 1)),
		@AttributeOverride(name = "embedded.estudiDespesesGenerals", column = @Column(name = "prj_gstgen",  length = 22, precision = 15, scale = 2)),
		@AttributeOverride(name = "embedded.estudiBaixaPercent", column = @Column(name = "prj_baj", length = 22, precision = 15, scale = 8)),
		@AttributeOverride(name = "embedded.estudiTasaPercent", column = @Column(name = "prj_tas", length = 22, precision = 5, scale = 2)),
		@AttributeOverride(name = "embedded.contactePersona", column = @Column(name = "prj_percon", length = 60)),
		@AttributeOverride(name = "embedded.contacteTelefon", column = @Column(name = "prj_telcon", length = 30)),
		@AttributeOverride(name = "embedded.estudiSumarValoracioEnExces", column = @Column(name = "prj_valexc", length = 1)),	
		//////////////////////////////////// NO IMPLEMENTADES PER L'ANTERIOR DESENVOLUPADOR /////////////////////////////////////////////////////////////
		@AttributeOverride(name = "embedded.dricmp", column = @Column(name = "prj_dricmp", length = 2)),
		@AttributeOverride(name = "embedded.dricmp002", column = @Column(name = "prj_dricmp002", length = 2)),
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@AttributeOverride(name = "embedded.dataFiPrevist", column = @Column(name = "prj_datfinprt")),
		@AttributeOverride(name = "embedded.mesosGarantia", column = @Column(name = "prj_mesgar", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.percentExecucioLliure", column = @Column(name = "prj_pteeje", length = 22, precision = 7, scale = 2, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.horesEquiv", column = @Column(name = "prj_horequ", length = 22, precision = 7, scale = 2, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.percentExecucioConstruccio", column = @Column(name = "prj_pteejc", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.horesEquivConstruccio", column = @Column(name = "prj_horeqc", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.percentExecucioGarantia", column = @Column(name = "prj_pteejg", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.horesEquivGarantia", column = @Column(name = "prj_horeqg", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.tipusInversio", column = @Column(name = "prj_tipinv", length = 1)),
		@AttributeOverride(name = "embedded.tipusObra", column = @Column(name = "prj_tipobr", length = 1)),
		@AttributeOverride(name = "embedded.controlarCostos", column = @Column(name = "prj_crlcos", length = 1)),
		@AttributeOverride(name = "embedded.horesCami", column = @Column(name = "prj_horrut", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.adreca", column = @Column(name = "prj_dir", length = 200)),
		@AttributeOverride(name = "embedded.poblacio", column = @Column(name = "prj_pob", length = 100)),
		@AttributeOverride(name = "embedded.dataIniciGarantia", column = @Column(name = "prj_datgar")),
		@AttributeOverride(name = "embedded.multiclient", column = @Column(name = "prj_mulcli", length = 1)),
		@AttributeOverride(name = "embedded.dataFinalGarantia", column = @Column(name = "prj_datfingar")),
		////////////////////////////////////NO IMPLEMENTADES PER L'ANTERIOR DESENVOLUPADOR //////////////////////////////////////////////////////////////
		@AttributeOverride(name = "embedded.kmt", column = @Column(name = "prj_kmt", length = 22, precision = 5, scale = 2)),	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@AttributeOverride(name = "embedded.tipusExecucio", column = @Column(name = "prj_tipeje", length = 22, precision = 1)),
		@AttributeOverride(name = "embedded.preuMigFacturacio", column = @Column(name = "prj_prumigfac", length = 22, precision = 15, scale = 2)),
		@AttributeOverride(name = "embedded.dataFormalitzacio", column = @Column(name = "prj_datfmz")),
		@AttributeOverride(name = "embedded.tecnologies", column = @Column(name = "prj_tec", length = 3000)),		
		@AttributeOverride(name = "embedded.descripcioCurta", column = @Column(name = "prj_descur", length = 500)),
		//////////////////////////////////NO IMPLEMENTADES PER L'ANTERIOR DESENVOLUPADOR ////////////////////////////////////////////////////////////////		
		@AttributeOverride(name = "embedded.pteinccstmo", column = @Column(name = "prj_pteinccstmo", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.pteinccstmaq", column = @Column(name = "prj_pteinccstmaq", length = 22, precision = 7, scale = 2)),
		@AttributeOverride(name = "embedded.impfixmo", column = @Column(name = "prj_impfixmo", length = 22, precision = 18, scale = 4)),
		@AttributeOverride(name = "embedded.impfixmaq", column = @Column(name = "prj_impfixmaq", length = 22, precision = 18, scale = 4)),		
		
		//@AttributeOverride(name = "embedded.producteReferencia", column = @Column(name = "prj_apl_ref", length = 22, insertable = false, updatable = false)),
		//@AttributeOverride(name = "embedded.expedientCodi", column = @Column(name = "prj_exd_cod", length = 4, insertable = false, updatable = false)),
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		@AttributeOverride(name = "embedded.exportarMobil", column = @Column(name = "prj_pda", length = 1)),		
		//////////////////////////////////// NO IMPLEMENTADES PER L'ANTERIOR DESENVOLUPADOR /////////////////////////////////////////////////////////////		
		@AttributeOverride(name = "embedded.idfProjecteJira", column = @Column(name = "prj_jiridf", length = 10)),
		@AttributeOverride(name = "embedded.tipusGestio", column = @Column(name = "prj_tipges", length = 1)),
		@AttributeOverride(name = "embedded.cpa", column = @Column(name = "prj_cpa", length = 1)),			
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////// REFERIDES A CODIS PERÒ SENSE SER RELACIO  A TAULES /////////////////////////////////////////////////////////
		@AttributeOverride(name = "embedded.articleCodi001", column = @Column(name = "prj_art_cod001", length = 15)),
		@AttributeOverride(name = "embedded.articleCodi002", column = @Column(name = "prj_art_cod002", length = 15)),		
		@AttributeOverride(name = "embedded.estudiCodi001", column = @Column(name = "prj_etp_cod001", length = 4)),
		@AttributeOverride(name = "embedded.estudiCodi002", column = @Column(name = "prj_etp_cod002", length = 4)),
		@AttributeOverride(name = "embedded.estudiCodi003", column = @Column(name = "prj_etp_cod003", length = 4)),		
		@AttributeOverride(name = "embedded.unitatControlEstudiCodi001", column = @Column(name = "prj_uce_cod001", length = 30)),
		@AttributeOverride(name = "embedded.unitatControlEstudiCodi002", column = @Column(name = "prj_uce_cod002", length = 30)),
		@AttributeOverride(name = "embedded.unitatControlEstudiCodi003", column = @Column(name = "prj_uce_cod003", length = 30)),		
		@AttributeOverride(name = "embedded.estudiLiniaCodi001", column = @Column(name = "prj_les_cod001", length = 30)),
		@AttributeOverride(name = "embedded.estudiLiniaCodi002", column = @Column(name = "prj_les_cod002", length = 30)),
		@AttributeOverride(name = "embedded.estudiLiniaCodi003", column = @Column(name = "prj_les_cod003", length = 30)),
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		@AttributeOverride(name = "embedded.createdBy", column = @Column(name = "prj_usucre", length = 64, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.createdDate", column = @Column(name = "prj_datcre", length = 64, insertable = false, updatable = false)),
		
		@AttributeOverride(name = "createdBy", column = @Column(name = "prj_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "prj_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "prj_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "prj_datmod"))
})
		@AssociationOverrides({ 
			@AssociationOverride(name = "identificador", 
					joinColumns = {
									@JoinColumn(name = "prj_idf_cod", insertable = false, updatable = false) }, 
					foreignKey = @ForeignKey(name = "rges_prj_idf_fk")) 
})
@EntityListeners({ProjecteEntityListener.class})
public class ProjecteEntity extends AbstractWithIdentificadorAuditableEntity<Projecte, ProjectePk> {

	@Embedded
	protected Projecte embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_emp_cod_fk"))
	private EmpresaEntity empresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_div_cod_fk"))
	private DivisaEntity divisa;
	@Column(name = "prj_div_cod", length = 4)
	private String divisaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_cli_cod_fk"))
	private ClientEntity client;
	@Column(name = "prj_cli_cod", length = 6)
	private String clientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_acc_cod_fk"))
	private ClientAdresaEntity clientAdresa;
	@Column(name = "prj_acc_cod", length = 4)
	private String clientAdresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_scl_cod_fk"))
	private SubClientEntity subClient;
	@Column(name = "prj_scl_cod", length = 4)
	private String subClientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ffa_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ffa_cod", referencedColumnName = "ffa_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ffa_cod_fk"))
	private FinalFacturaEntity finalFactura;
	@Column(name = "prj_ffa_cod", length = 6)
	private String finalFacturaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "tpj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_tpj_cod", referencedColumnName = "tpj_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_tpj_cod_fk"))
	private ProjecteTipusEntity projecteTipus;
	@Column(name = "prj_tpj_cod", length = 6)
	private String projecteTipusCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_ope_cod_fk"))
	private OperariEntity operariResponsable;
	@Column(name = "prj_ope_cod", length = 6)
	private String operariResponsableCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "clr_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_clr_cod", referencedColumnName = "clr_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_clr_cod_fk"))
	private ClasseRetencioEntity classeRetencio;
	@Column(name = "prj_clr_cod", length = 4)
	private String classeRetencioCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ope_enccod", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ope_enccod_fk"))
	private OperariEntity operariEncarregat;
	@Column(name = "prj_ope_enccod", length = 6)
	private String operariEncarregatCodi;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_ser_cod_fk"))
	private SerieVendaEntity serie;
	@Column(name = "prj_ser_cod", length = 2)
	private String serieCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_zon_cod", referencedColumnName = "zon_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_zon_cod_fk"))
	private ZonaEntity zona;
	@Column(name = "prj_zon_cod", length = 4)
	private String zonaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ope_codcgr", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ope_codcgr_fk"))
	private OperariEntity operariCapGrup;
	@Column(name = "prj_ope_codcgr", length = 6)
	private String operariCapGrupCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ope_codadm", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ope_codadm_fk"))
	private OperariEntity operariAdministratiu;
	@Column(name = "prj_ope_codadm", length = 6)
	private String operariAdministratiuCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_rgi_codinv", referencedColumnName = "rgi_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_rgi_codinv_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "prj_rgi_codinv", length = 2)
	private String regimIvaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "sei_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "sei_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_sei_codinv", referencedColumnName = "sei_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_sei_codinv_fk"))
	private SerieIntracomunitariaEntity serieIntracomunitaria;
	@Column(name = "prj_sei_codinv", length = 2)
	private String serieIntracomunitariaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_iva_codinv", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_iva_codinv_fk"))
	private IvaEntity iva;
	@Column(name = "prj_iva_codinv", length = 4)
	private String ivaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ane_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "ane_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ane_cod", referencedColumnName = "ane_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ane_cod_fk"))
	private AreaNegociEntity areaNegoci;
	@Column(name = "prj_ane_cod", length = 4)
	private String areaNegociCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "prj_cpo_cod", length = 8)
	private String codiPostalCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_mag_cod_fk"))
	private MagatzemEntity magatzem;
	@Column(name = "prj_mag_cod", length = 4)
	private String magatzemCodi;
	
	//////////////////////////////////// NO IMPLEMENTADES PER L'ANTERIOR DESENVOLUPADOR /////////////////////////////////////////////////////////////	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "apl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_apl_ref", referencedColumnName = "apl_ref", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_apl_ref_fk"))
	private ProducteEntity producte;
	@Column(name = "prj_apl_ref", length = 22)
	private Integer producteReferencia;
		
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "sec_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "sec_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_sec_cod", referencedColumnName = "sec_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_sec_cod_fk"))
	private SeccioEntity seccio;
	@Column(name = "prj_sec_cod", length = 2)
	private String seccioCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "exd_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "exd_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_exd_cod", referencedColumnName = "exd_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_exd_cod_fk"))
	private ExpedientEntity expedient;
	@Column(name = "prj_exd_cod", length = 4)
	private String expedientCodi;
	
	@Builder
	public ProjecteEntity(ProjectePk pk, 
			Projecte embedded, 
			IdentificadorEntity identificador, 
			EmpresaEntity empresa,			
			DivisaEntity divisa, 
			ClientEntity client,
			ClientAdresaEntity clientAdresa,
			SubClientEntity subClient, 
			FinalFacturaEntity finalFactura,
			ProjecteTipusEntity projecteTipus, 
			OperariEntity operariResponsable,
			ClasseRetencioEntity classeRetencio,
			OperariEntity operariEncarregat, 
			SerieVendaEntity serie, 
			ZonaEntity zona, 
			OperariEntity operariCapGrup,			
			OperariEntity operariAdministratiu,
			RegimIvaEntity regimIva,
			SerieIntracomunitariaEntity serieIntracomunitaria,
			IvaEntity iva,
			AreaNegociEntity areaNegoci,			
			CodiPostalEntity codiPostal,			
			MagatzemEntity magatzem, 
			ProducteEntity producte,			
			SeccioEntity seccio,
			ExpedientEntity expedient
			) {
		
		setId(pk);		
		
		this.embedded = embedded;
		this.identificador = identificador;		
		this.empresa = empresa;
		
//		afegirZerosAlCodi(this);	
		updateDivisa(divisa);
		updateClient(client);
		updateClientAdresa(clientAdresa);
		updateSubClient(subClient);
		updateFinalFactura(finalFactura);
		updateProjecteTipus(projecteTipus);
		updateOperariResponsable(operariResponsable);
		updateClasseRetencio(classeRetencio);
		updateOperariEncarregat(operariEncarregat);
		updateSerie(serie);
		updateZona(zona);
		updateOperariCapGrup(operariCapGrup);		
		updateOperariAdministratiu(operariAdministratiu);
		updateRegimIva(regimIva);
		updateSerieIntracomunitaria(serieIntracomunitaria);
		updateIva(iva);
		updateAreaNegoci(areaNegoci);
		updateCodiPostal(codiPostal);		
		updateMagatzem(magatzem);
		updateProducte(producte);	
		updateSeccio(seccio);
		updateExpedient(expedient);
	}

	@Override
	public void update(Projecte embedded) {
		this.embedded = embedded;
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getId().getCodi();
		}
	}
	
	public void updateSeccio(SeccioEntity seccio) {
		this.seccio = seccio;
		if (seccio != null) {
			this.seccioCodi = seccio.getId().getCodi();
		}
	}

	public void updateProjecteTipus(ProjecteTipusEntity projecteTipus) {
		this.projecteTipus = projecteTipus;
		if (projecteTipus != null) {
			this.projecteTipusCodi = projecteTipus.getId().getCodi();
		}
	}

	public void updateOperariResponsable(OperariEntity operariResponsable) {
		this.operariResponsable = operariResponsable;
		if (operariResponsable != null) {
			this.operariResponsableCodi = operariResponsable.getId().getCodi();
		}
	}

	public void updateOperariCapGrup(OperariEntity operariCapGrup) {
		this.operariCapGrup = operariCapGrup;
		if (operariCapGrup != null) {
			this.operariCapGrupCodi = operariCapGrup.getId().getCodi();
		}
	}

	public void updateOperariEncarregat(OperariEntity operariEncarregat) {
		this.operariEncarregat = operariEncarregat;
		if (operariEncarregat != null) {
			this.operariEncarregatCodi = operariEncarregat.getId().getCodi();
		}
	}

	public void updateOperariAdministratiu(OperariEntity operariAdministratiu) {
		this.operariAdministratiu = operariAdministratiu;
		if (operariAdministratiu != null) {
			this.operariAdministratiuCodi = operariAdministratiu.getId().getCodi();
		}
	}

	public void updateSerie(SerieVendaEntity serie) {
		this.serie = serie;
		if (serie != null) {
			this.serieCodi = serie.getId().getCodi();
		}
	}

	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getId().getCodi();
		}
	}

	public void updateSubClient(SubClientEntity subClient) {
		this.subClient = subClient;
		if (subClient != null) {
			this.subClientCodi = subClient.getId().getCodi();
		}
	}

	public void updateClientAdresa(ClientAdresaEntity clientAdresa) {
		this.clientAdresa = clientAdresa;
		if (clientAdresa != null) {
			this.clientAdresaCodi = clientAdresa.getId().getCodi();
		}
	}

	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}

	public void updateClasseRetencio(ClasseRetencioEntity classeRetencio) {
		this.classeRetencio = classeRetencio;
		if (classeRetencio != null) {
			this.classeRetencioCodi = classeRetencio.getId().getCodi();
		}
	}

	public void updateAreaNegoci(AreaNegociEntity areaNegoci) {
		this.areaNegoci = areaNegoci;
		if (areaNegoci != null) {
			this.areaNegociCodi = areaNegoci.getId().getCodi();
		}
	}

	public void updateMagatzem(MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getId().getCodi();
		}
	}

	public void updateZona(ZonaEntity zona) {
		this.zona = zona;
		if (zona != null) {
			this.zonaCodi = zona.getId().getCodi();
		}
	}

	public void updateFinalFactura(FinalFacturaEntity finalFactura) {
		this.finalFactura = finalFactura;
		if (finalFactura != null) {
			this.finalFacturaCodi = finalFactura.getId().getCodi();
		}
	}
	
	public void updateIva(IvaEntity iva) {
		this.iva = iva;
		if (iva != null) {
			this.ivaCodi = iva.getId().getCodi();
		}
	}
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		if (regimIva != null) {
			this.regimIvaCodi = regimIva.getId().getCodi();
		}
	}
	
	public void updateSerieIntracomunitaria(SerieIntracomunitariaEntity serieIntracomunitaria) {
		this.serieIntracomunitaria = serieIntracomunitaria;
		if (serieIntracomunitaria != null) {
			this.serieIntracomunitariaCodi = serieIntracomunitaria.getId().getCodi();
		}
	}
	
	public void updateProducte(ProducteEntity producte) {
		this.producte = producte;
		if (producte != null) {
			this.producteReferencia = producte.getId().getReferencia();
		}
	}
	
	public void updateExpedient(ExpedientEntity expedient) {
		this.expedient = expedient;
		if (expedient != null) {
			this.expedientCodi = expedient.getId().getCodi();
		}
	}
	
	public static class ProjecteEntityListener {
		@PrePersist
		public void calcular(ProjecteEntity projecte) {
			
			int tamanyCodi = 6;
			
			String codi = projecte.getEmbedded().getCodi();			
			String codiEmpresa = projecte.getId().getEmpresaCodi();
			if (codi == null || codi.isEmpty()) {
				int num = EntityListenerUtil.getSeguentNumComptadorComprovantPkAmbZeros(
						projecte.getId().getIdentificadorCodi(),
						codiEmpresa+"_TGES_PRJ",
						"TGES_PRJ",
						new PkBuilder<ProjectePk>() {
							@Override
							public ProjectePk build(int num) {
								return new ProjectePk(projecte.getId().getIdentificadorCodi(), projecte.getId().getEmpresaCodi(), Integer.toString(num));
							}
							@Override
							public ProjectePk build(String num) {
								return new ProjectePk(projecte.getId().getIdentificadorCodi(), projecte.getId().getEmpresaCodi(), num);
							}	
						},
						EntityListenerUtil.getBean(ProjecteRepository.class),
						tamanyCodi);
				String seqST = addZeros(num, tamanyCodi);
				projecte.getEmbedded().setCodi(seqST);
				projecte.getId().setCodi(seqST);
			} else {
				afegirZerosAlCodi(projecte, tamanyCodi);
//				calcHoresEquiv(projecte);
//				calcPercExec(projecte);
//				if (isNumeric(codi)) {					
//					codi = addZeros(Integer.parseInt(codi), 6);
//					projecte.getEmbedded().setCodi(codi);
//					projecte.getId().setCodi(codi);
//				}
			}
			
			
			String operariResponsableCodi = projecte.getOperariResponsableCodi();
			String operariCapGrupCodi = projecte.getOperariCapGrupCodi();
			String operariEncarregatCodi = projecte.getOperariEncarregatCodi();
			String operariAdministratiuCodi = projecte.getOperariAdministratiuCodi();
			
			String identificadorCodi = projecte.getId().getIdentificadorCodi();
			
			HistoricResponsablePk historicResponsablePk = new HistoricResponsablePk(identificadorCodi, codiEmpresa, codi, null); //Falta la sequencia
			HistoricResponsableRepository historicResponsableRepository = EntityListenerUtil.getBean(HistoricResponsableRepository.class);
			Optional<HistoricResponsableEntity> historicResponsableEntity = historicResponsableRepository.findById(historicResponsablePk);

			if(!historicResponsableEntity.isPresent() && operariResponsableCodi != null) {
				HistoricResponsable historicResponsable = new HistoricResponsable();
				historicResponsable.getPk().setIdentificadorCodi(identificadorCodi);
				historicResponsable.getPk().setEmpresaCodi(codiEmpresa);
				historicResponsable.getPk().setProjecteNumero(codi);
				historicResponsable.setTipusOperari(OperariTipusEnumDto.RESPONSABLE);
				historicResponsable.getOperari().setCode(operariResponsableCodi);
				historicResponsableRepository.save(
						HistoricResponsableEntity.builder().
						pk(historicResponsablePk).
						embedded(historicResponsable).
						build());
			}
			
			if(!historicResponsableEntity.isPresent() && operariCapGrupCodi != null) {
				HistoricResponsable historicResponsable = new HistoricResponsable();
				historicResponsable.getPk().setIdentificadorCodi(identificadorCodi);
				historicResponsable.getPk().setEmpresaCodi(codiEmpresa);
				historicResponsable.getPk().setProjecteNumero(codi);
				historicResponsable.setTipusOperari(OperariTipusEnumDto.CAPGRUP);
				historicResponsable.getOperari().setCode(operariCapGrupCodi);
				historicResponsableRepository.save(
						HistoricResponsableEntity.builder().
						pk(historicResponsablePk).
						embedded(historicResponsable).
						build());		
			}
			
			if(!historicResponsableEntity.isPresent() && operariEncarregatCodi != null) {
				HistoricResponsable historicResponsable = new HistoricResponsable();
				historicResponsable.getPk().setIdentificadorCodi(identificadorCodi);
				historicResponsable.getPk().setEmpresaCodi(codiEmpresa);
				historicResponsable.getPk().setProjecteNumero(codi);
				historicResponsable.setTipusOperari(OperariTipusEnumDto.ENCARREGAT);
				historicResponsable.getOperari().setCode(operariEncarregatCodi);
				historicResponsableRepository.save(
						HistoricResponsableEntity.builder().
						pk(historicResponsablePk).
						embedded(historicResponsable).
						build());
			}
			
			if(!historicResponsableEntity.isPresent() && operariAdministratiuCodi != null) {
				HistoricResponsable historicResponsable = new HistoricResponsable();
				historicResponsable.getPk().setIdentificadorCodi(identificadorCodi);
				historicResponsable.getPk().setEmpresaCodi(codiEmpresa);
				historicResponsable.getPk().setProjecteNumero(codi);
				historicResponsable.setTipusOperari(OperariTipusEnumDto.ADMINISTRATIU);
				historicResponsable.getOperari().setCode(operariAdministratiuCodi);
				historicResponsableRepository.save(
						HistoricResponsableEntity.builder().
						pk(historicResponsablePk).
						embedded(historicResponsable).
						build());
			}
			
		}
		
	}
	
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	 
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static void afegirZerosAlCodi(ProjecteEntity projecte, int tamanyCodi) {
		
		String codi = projecte.getEmbedded().getCodi();
		if (isNumeric(codi)) {					
			codi = addZeros(Integer.parseInt(codi), tamanyCodi);
			projecte.getEmbedded().setCodi(codi);
			projecte.getId().setCodi(codi);
		}		
	}
	
	public static String addZeros(int codi, int tamanyCodi) {
		return String.format("%0"+String.valueOf(tamanyCodi)+"d", codi).toString();	
	}
	
//	public static void calcPercExec(ProjecteEntity projecte) {
//		BigDecimal horesEquiv = projecte.getEmbedded().getHoresEquiv();
//		BigDecimal horesCons = projecte.getEmbedded().getHoresEquivConstruccio();
//		BigDecimal horesGaran = projecte.getEmbedded().getHoresEquivGarantia();
//		
//		BigDecimal percCons = projecte.getEmbedded().getPercentExecucioConstruccio();
//		BigDecimal percGaran = projecte.getEmbedded().getPercentExecucioGarantia();
//		BigDecimal percLLiu = projecte.getEmbedded().getPercentExecucioLliure();
//		
//		BigDecimal percLLiuCons = BigDecimal.ZERO;
//		BigDecimal percLLiuGaran = BigDecimal.ZERO;
//		BigDecimal cent = new BigDecimal(100);
//		
//		if(horesEquiv != BigDecimal.ZERO) {
//			percLLiuCons = ((percCons != null) ? percCons : BigDecimal.ZERO).divide(cent);
//			percLLiuCons.multiply((horesCons != null) ? horesCons : BigDecimal.ZERO);
//			
//			percLLiuGaran = ((percGaran != null) ? percGaran : BigDecimal.ZERO).divide(cent);
//			percLLiuGaran.multiply((horesGaran != null) ? horesGaran : BigDecimal.ZERO);
//			
//			percLLiu = percLLiuCons.add(percLLiuGaran);
//			percLLiu.divide(horesEquiv);
//			percLLiu.multiply(cent);
//			
//			projecte.getEmbedded().setPercentExecucioLliure(percLLiu);
//		}
//	}
//	
//	public static void calcHoresEquiv(ProjecteEntity projecte) {
//		BigDecimal horesCons = projecte.getEmbedded().getHoresEquivConstruccio();
//		BigDecimal horesGaran = projecte.getEmbedded().getHoresEquivGarantia();
//		BigDecimal horesEquiv = projecte.getEmbedded().getHoresEquiv();
//		
//		if(horesCons != null || horesGaran != null) {
//			horesEquiv = (horesCons != null) ? horesCons : BigDecimal.ZERO;
//			horesEquiv.add((horesGaran != null) ? horesGaran : BigDecimal.ZERO);
//		}
//		
//		projecte.getEmbedded().setHoresEquiv(horesEquiv);
//	}
}
