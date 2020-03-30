/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "rrhhOperariEntity")
@Table(
		name = "trhu_ope",
		indexes = {
				@Index(name = "irhu_ope_idf_fk", columnList = "ope_idf_cod"),
				@Index(name = "irrhu_ope_pk", columnList = "ope_idf_cod,ope_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "ope_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "ope_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "ope_cod", length = 4, insertable = false, updatable = false)),		
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "ope_nom", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "ope_act")),	
	@AttributeOverride(name = "embedded.entsor", column = @Column(name = "ope_entsor")),	
	@AttributeOverride(name = "embedded.comercial", column = @Column(name = "ope_cml")),	
//	@AttributeOverride(name = "embedded.horariCodi", column = @Column(name = "ope_hor_cod", length = 4, nullable = false)),			
	@AttributeOverride(name = "embedded.mostrTurno", column = @Column(name = "ope_tor")),			
	@AttributeOverride(name = "embedded.pin", column = @Column(name = "ope_pin")),			
	@AttributeOverride(name = "embedded.enc", column = @Column(name = "ope_enc")),			
	@AttributeOverride(name = "embedded.incidencia", column = @Column(name = "ope_ind")),			
	@AttributeOverride(name = "embedded.horesp", column = @Column(name = "ope_horesp", length = 1)),			
	@AttributeOverride(name = "embedded.aplicaDiesLab", column = @Column(name = "ope_apldia", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDilluns", column = @Column(name = "ope_dls", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDimarts", column = @Column(name = "ope_dms", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDimecres", column = @Column(name = "ope_dcs", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDijous", column = @Column(name = "ope_djs", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDivendres", column = @Column(name = "ope_dvs", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDissabte", column = @Column(name = "ope_dse", length = 1)),			
	@AttributeOverride(name = "embedded.laboralDiumenge", column = @Column(name = "ope_dme", length = 1)),			
	@AttributeOverride(name = "embedded.nonGrato", column = @Column(name = "ope_ngr", length = 1)),			
	@AttributeOverride(name = "embedded.ptenmn", column = @Column(name = "ope_ptenmn")),			
	@AttributeOverride(name = "embedded.ado", column = @Column(name = "ope_ado", length = 1)),			
	@AttributeOverride(name = "embedded.controlPartes", column = @Column(name = "ope_ctlffo", length = 1)),			
	@AttributeOverride(name = "embedded.controlHoresExtras", column = @Column(name = "ope_ctlhoe", length = 1)),			
//	@AttributeOverride(name = "embedded.usuariCodi", column = @Column(name = "ope_usu_cod", length = 30)),

	@AttributeOverride(name = "embedded.calculoHorasPartesTrabajo", column = @Column(name = "ope_calhor")),
	@AttributeOverride(name = "embedded.horasCalculNominas", column = @Column(name = "ope_horcan")),
	@AttributeOverride(name = "embedded.estadoCivil", column = @Column(name = "ope_estciv")),
	@AttributeOverride(name = "embedded.digitsControl", column = @Column(name = "ope_dcc")),
	@AttributeOverride(name = "embedded.numeroFills", column = @Column(name = "ope_fil")),
	@AttributeOverride(name = "embedded.horesLliuresPerAny", column = @Column(name = "ope_horlli")),
	@AttributeOverride(name = "embedded.horesLliures", column = @Column(name = "ope_horlli002")),
	
	@AttributeOverride(name = "embedded.oficinaBancaria", column = @Column(name = "ope_ofb")),
	@AttributeOverride(name = "embedded.entitatBancaria", column = @Column(name = "ope_ban")),
	@AttributeOverride(name = "embedded.horesVacances", column = @Column(name = "ope_horvac")),
	@AttributeOverride(name = "embedded.codiPostalPoblacio", column = @Column(name = "ope_cpo")),
	@AttributeOverride(name = "embedded.numeroMatricula", column = @Column(name = "ope_mtr")),
	@AttributeOverride(name = "embedded.codiAlternatiu", column = @Column(name = "ope_codalt")),
	
	@AttributeOverride(name = "embedded.compteComptable", column = @Column(name = "ope_ctecmp")),
	@AttributeOverride(name = "embedded.compteCorrent", column = @Column(name = "ope_ccr")),
	@AttributeOverride(name = "embedded.dataNaixement", column = @Column(name = "ope_datnai")),
	@AttributeOverride(name = "embedded.dataAltaEmpresa", column = @Column(name = "ope_dat")),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "ope_nif")),
	
	// Comento el camp numeroSeguretatSocial, fins a aclariment, ja que s'ha donat com a nom de la columna ope_nif
//	@AttributeOverride(name = "embedded.numeroSeguretatSocial", column = @Column(name = "ope_nif")),
	
	@AttributeOverride(name = "embedded.nmn1", column = @Column(name = "ope_nmn1")),
	@AttributeOverride(name = "embedded.nmn2", column = @Column(name = "ope_nmn2")),
	@AttributeOverride(name = "embedded.importHoresExtresDilluns", column = @Column(name = "ope_pruextdls")),
	@AttributeOverride(name = "embedded.importHoresExtresDimarts", column = @Column(name = "ope_pruextdms")),
	@AttributeOverride(name = "embedded.importHoresExtresDimecres", column = @Column(name = "ope_pruextdcs")),
	@AttributeOverride(name = "embedded.importHoresExtresDijous", column = @Column(name = "ope_pruextdjs")),
	@AttributeOverride(name = "embedded.importHoresExtresDivendres", column = @Column(name = "ope_pruextdvs")),
	@AttributeOverride(name = "embedded.importHoresExtresDisabte", column = @Column(name = "ope_pruextdse")),
	@AttributeOverride(name = "embedded.importHoresExtresDiumenge", column = @Column(name = "ope_pruextdme")),
	@AttributeOverride(name = "embedded.importHoresNormals", column = @Column(name = "ope_pruhornor")),
	@AttributeOverride(name = "embedded.prunitdls", column = @Column(name = "ope_prunitdls")),
	@AttributeOverride(name = "embedded.prunitdms", column = @Column(name = "ope_prunitdms")),
	@AttributeOverride(name = "embedded.prunitdcs", column = @Column(name = "ope_prunitdcs")),
	@AttributeOverride(name = "embedded.prunitdjs", column = @Column(name = "ope_prunitdjs")),
	@AttributeOverride(name = "embedded.prunitdvs", column = @Column(name = "ope_prunitdvs")),
	@AttributeOverride(name = "embedded.prunitdse", column = @Column(name = "ope_prunitdse")),
	@AttributeOverride(name = "embedded.prunitdme", column = @Column(name = "ope_prunitdme")),
	@AttributeOverride(name = "embedded.complementSalarial1", column = @Column(name = "ope_cplsal1")),
	@AttributeOverride(name = "embedded.complementSalarial2", column = @Column(name = "ope_cplsal2")),
	@AttributeOverride(name = "embedded.costeAdicional", column = @Column(name = "ope_cosadd")),
	@AttributeOverride(name = "embedded.poblacio", column = @Column(name = "ope_pob")),
	@AttributeOverride(name = "embedded.provincia", column = @Column(name = "ope_prv")),
	@AttributeOverride(name = "embedded.nomDelPare", column = @Column(name = "ope_nompae")),
	@AttributeOverride(name = "embedded.nomDeLaMare", column = @Column(name = "ope_nommae")),
	@AttributeOverride(name = "embedded.llocNaixement", column = @Column(name = "ope_llcnai")),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "ope_eml")),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "ope_tel")),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "ope_dom")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "ope_obs")),
	@AttributeOverride(name = "embedded.datvaltrg", column = @Column(name = "ope_datvaltrg")),
	@AttributeOverride(name = "embedded.operariPrejubilat", column = @Column(name = "ope_pjb")),
	@AttributeOverride(name = "embedded.dataPrejubilacio", column = @Column(name = "ope_diapjb")),
	@AttributeOverride(name = "embedded.horesAnualsPrejubilacio", column = @Column(name = "ope_horanypjb")),
	@AttributeOverride(name = "embedded.horesPendentsAnysAnteriorJubilacio", column = @Column(name = "ope_horpenanyantpjb")),
	@AttributeOverride(name = "embedded.observacionsPrejubilacio", column = @Column(name = "ope_obspjb")),
	@AttributeOverride(name = "embedded.plusProductivitat", column = @Column(name = "ope_plupdt")),
	
	@AttributeOverride(name = "embedded.dataIniciTorn", column = @Column(name = "ope_tordiaini")),
	@AttributeOverride(name = "embedded.sexe", column = @Column(name = "ope_sex")),
	@AttributeOverride(name = "embedded.telefonEmpresa", column = @Column(name = "ope_telemp")),
	@AttributeOverride(name = "embedded.targetesProfessionalsContruccio", column = @Column(name = "ope_tpc")),
	@AttributeOverride(name = "embedded.percentatgeMinusvalia", column = @Column(name = "ope_mns")),
	@AttributeOverride(name = "embedded.tgtcod", column = @Column(name = "ope_tgtcod")),
	@AttributeOverride(name = "embedded.horesRuta", column = @Column(name = "ope_horrut")),
	@AttributeOverride(name = "embedded.dietes", column = @Column(name = "ope_derdie")),
	@AttributeOverride(name = "embedded.ibnpai", column = @Column(name = "ope_ibnpai")),
	@AttributeOverride(name = "embedded.ibndcc", column = @Column(name = "ope_ibndcc")),
	@AttributeOverride(name = "embedded.ibnbic", column = @Column(name = "ope_ibnbic")),
	@AttributeOverride(name = "embedded.discos", column = @Column(name = "ope_discos")),
	@AttributeOverride(name = "embedded.anecmp", column = @Column(name = "ope_anecmp")),
	@AttributeOverride(name = "embedded.depcmp", column = @Column(name = "ope_depcmp")),
	@AttributeOverride(name = "embedded.depcmpfxe", column = @Column(name = "ope_depcmpfxe")),
	
	@AttributeOverride(name = "embedded.dtehor", column = @Column(name = "ope_dtehor")),
	@AttributeOverride(name = "embedded.maxhoe001", column = @Column(name = "ope_maxhoe001")),
	@AttributeOverride(name = "embedded.ptenmn002", column = @Column(name = "ope_ptenmn002")),
	@AttributeOverride(name = "embedded.emailEmpresa", column = @Column(name = "ope_emlemp")),
	@AttributeOverride(name = "embedded.costIndirecte", column = @Column(name = "ope_cosidr")),
	@AttributeOverride(name = "embedded.pas", column = @Column(name = "ope_pas")),
	@AttributeOverride(name = "embedded.app", column = @Column(name = "ope_app")),
	@AttributeOverride(name = "embedded.ali", column = @Column(name = "ope_ali")),
	
	@AttributeOverride(name = "embedded.mdcntf", column = @Column(name = "ope_mdcntf")),
	@AttributeOverride(name = "embedded.nothorext", column = @Column(name = "ope_nothorext")),
	@AttributeOverride(name = "embedded.usucld", column = @Column(name = "ope_usucld")),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "ope_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "ope_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "ope_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "ope_datmod")),	
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "ope_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rrhu_ope_idf_fk"))
})
public class OperariEntity extends AbstractWithIdentificadorAuditableEntity<Operari, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Operari embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_hor_cod", referencedColumnName = "hor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_hor_fk"))			
	protected HorariEntity horari;	
	@Column(name ="ope_hor_cod", length = 4, nullable = false)
	private String horariCodi;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "tcs_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_tcs_cod", referencedColumnName = "tcs_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rges_ope_tcs_fk"))			
	protected TipusComissioEntity tipusComissio;	
	@Column(name ="ope_tcs_cod", length = 4)
	private String tipusComissioCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "ban_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_ban_codccr", referencedColumnName = "ban_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rges_ope_ban_fk"))			
	protected BancEntity banc;	
	@Column(name ="ope_ban_codccr", length = 4)
	private Integer bancCodi;
	
	/*@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "ofb_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_ofb_codccr", referencedColumnName = "ofb_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rges_ope_ofb_fk"))			
	protected OficinaBancariaEntity oficinaBancariaCcr;	
	@Column(name ="ope_ofb_codccr", length = 4, nullable = false)
	private Integer oficinaBancariaCodi;*/
	
		
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "zon_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_zon_cod", referencedColumnName = "zon_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_zon_fk"))			
	protected ZonaEntity zona;	
	@Column(name ="ope_zon_cod", length = 4, nullable = false)
	private String zonaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_emp_codccr", referencedColumnName = "emp_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_emp_fk"))			
	protected EmpresaEntity empresa;	
	@Column(name ="ope_emp_codccr", length = 4, nullable = false)
	private String empresaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_hor_cod002", referencedColumnName = "hor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_hor2_fk"))			
	protected HorariEntity horariBocadillo;	
	@Column(name ="ope_hor_cod002", length = 4, nullable = false)
	private String horariBocadilloCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_hor_codnit", referencedColumnName = "hor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_horn_fk"))			
	protected HorariEntity horariCodNit;	
	@Column(name ="ope_hor_codnit", length = 4, nullable = false)
	private String horaricodnitCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "gre_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_gre_cod", referencedColumnName = "gre_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_gre_fk"))			
	protected RecursGrupEntity recursGrup;	
	@Column(name ="ope_gre_cod", length = 4, nullable = false)
	private String recursGrupCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_ope_cod", referencedColumnName = "ope_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_ope_fk"))			
	protected OperariEntity operari;	
	@Column(name ="ope_ope_cod", length = 4)
	private String operariCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "vad_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_vad_cod", referencedColumnName = "vad_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_var_fk"))			
	protected MantenimentDeTipusEntity mantenimentDeTipus;	
	@Column(name ="ope_vad_cod", length = 4, nullable = false)
	private String mantenimentDeTipusCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "tor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_tor_cod", referencedColumnName = "tor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_tor_fk"))			
	protected TornEntity torn;	
	@Column(name ="ope_tor_cod", length = 4)
	private String tornCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "gfe_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_gfe_cod", referencedColumnName = "gfe_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_gfe_fk"))			
	protected GrupFestiuEntity grupFestiu;	
	@Column(name ="ope_gfe_cod", length = 4, nullable = false)
	private String grupFestiuCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "cen_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_cen_cod", referencedColumnName = "cen_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_cen_fk"))			
	protected CentreEntity centre;	
	@Column(name ="ope_cen_cod", length = 4)
	private String centreCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "ope_idf_cod", referencedColumnName = "hor_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "ope_hor_cod003", referencedColumnName = "hor_cod",	insertable = false,	updatable = false)
					},
			foreignKey = @ForeignKey(name = "rrhu_ope_hor3_fk"))			
	protected HorariEntity horariCod003;	
	@Column(name ="ope_hor_cod003", length = 4, nullable = false)
	private String horariCod003Codi;	

	@Builder
	public OperariEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Operari embedded,
			IdentificadorEntity identificador,
			HorariEntity horari,
			
			TipusComissioEntity tipusComissio,
			BancEntity banc,
			//OficinaBancariaEntity oficinaBancariaCcr,
			HorariEntity horariBocadillo,
			ZonaEntity zona,
			EmpresaEntity empresa,
			HorariEntity horariCodNit,
			RecursGrupEntity recursGrup,
			OperariEntity operari,
			MantenimentDeTipusEntity mantenimentDeTipus,
			TornEntity torn,
			GrupFestiuEntity grupFestiu,
			CentreEntity centre,
			HorariEntity horariCod003
			
			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;	

		this.updateHorari(horari);		
		this.updateTipusComissio(tipusComissio);
		this.updateHorariBocadillo(horariBocadillo);
		this.updateBanc(banc);
		//this.updateOficinaBancaria(oficinaBancariaCcr);		
		this.updateZona(zona);
		this.updateEmpresa(empresa);
		this.updateHorariCodNit(horariCodNit);
		this.updateRecursGrup(recursGrup);
		this.updateOperari(operari);
		this.updateMantenimentDeTipus(mantenimentDeTipus);
		this.updateTorn(torn);
		this.updteGrupFestiu(grupFestiu);
		this.updateCentre(centre);
		this.updateHorariCod003(horariCod003);
	}

	@Override
	public void update(Operari embedded) {
		this.embedded = embedded;
	}
	
	public void updateHorari (HorariEntity horari) {
		this.horari = horari;
		if (horari!=null) this.horariCodi = horari.getEmbedded().getCodi();	
	}
	
	public void updateTipusComissio (TipusComissioEntity tipusComissio) {
	 	this.tipusComissio = tipusComissio;
	 	if (tipusComissio!=null) this.tipusComissioCodi= tipusComissio.getEmbedded().getCodi();	
	}
	
	public void updateHorariBocadillo (HorariEntity horariBocadillo) {
		this.horariBocadillo = horariBocadillo;
		if (horariBocadillo!=null) this.horariBocadilloCodi = horariBocadillo.getEmbedded().getCodi();	
	}
	
	public void updateBanc (BancEntity banc) {
		this.banc = banc;
		if (banc!=null) this.bancCodi= banc.getEmbedded().getCodi();	
	}
		
	public void updateZona(ZonaEntity zona) {
		this.zona = zona;
		if (zona!=null)	this.zonaCodi = zona.getEmbedded().getCodi();
	}
	
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
		if (empresa!=null) this.empresaCodi = empresa.getEmbedded().getCodi();
	}	

	public void updateHorariCodNit (HorariEntity horariCodNit) {
		this.horariCodNit = horariCodNit;
		if (horariCodNit!=null) this.horaricodnitCodi = horariCodNit.getEmbedded().getCodi();
	}
	
	public void updateRecursGrup (RecursGrupEntity recursGrup) {
		this.recursGrup = recursGrup;
		if (recursGrup!=null) this.recursGrupCodi = recursGrup.getEmbedded().getCodi();
	}
	
	public void updateOperari (OperariEntity operari) {
		this.operari = operari;
		if (operari!=null) this.operariCodi = operari.getEmbedded().getCodi();
	}
	
	public void updateMantenimentDeTipus (MantenimentDeTipusEntity mantenimentDeTipus) {
		this.mantenimentDeTipus = mantenimentDeTipus;
		if (mantenimentDeTipus!=null) this.mantenimentDeTipusCodi = mantenimentDeTipus.getEmbedded().getCodi();
	}
	
	public void updateTorn(TornEntity torn) {
		this.torn = torn;
		if (torn!=null) this.tornCodi = torn.getEmbedded().getCodi();
	}
	
	public void updteGrupFestiu (GrupFestiuEntity grupFestiu) {
		this.grupFestiu = grupFestiu;
		if (grupFestiu!=null) this.grupFestiuCodi = grupFestiu.getEmbedded().getCodi();
	}
	
	public void updateCentre (CentreEntity centre) {
		this.centre = centre;
		if (centre!=null) this.centreCodi = centre.getEmbedded().getCodi();
	}
	
	public void updateHorariCod003 (HorariEntity horariCod003) {
		this.horariCod003 = horariCod003;
		if (horariCod003!=null) this.horariCod003Codi = horariCod003.getEmbedded().getCodi();
	}
}
