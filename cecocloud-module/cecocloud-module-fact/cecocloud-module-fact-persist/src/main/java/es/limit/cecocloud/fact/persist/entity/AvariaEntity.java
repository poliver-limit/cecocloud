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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.fact.logic.api.dto.Avaria;
import es.limit.cecocloud.fact.logic.api.dto.Avaria.AvariaPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de avaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factAvariaEntity")
@Table(
		name = "tges_avr",
		indexes = {
				@Index(name = "iges_avr_idf_fk", columnList = "avr_idf_cod"),
				@Index(name = "irges_avr_pk", columnList = "avr_idf_cod, avr_emp_cod, avr_num", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "avr_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "avr_emp_cod", length = 4)),
	@AttributeOverride(name = "id.num", column = @Column(name = "avr_num", length = 22, precision = 10)),
	
	@AttributeOverride(name = "embedded.num", column = @Column(name = "avr_num", length = 4, precision = 10, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcioAvaria", column = @Column(name = "avr_desavr", length = 1000)),
	@AttributeOverride(name = "embedded.descripcioTrab", column = @Column(name = "avr_destre", length = 1000)),
	@AttributeOverride(name = "embedded.numSerie", column = @Column(name = "avr_numser", length = 20)),
	@AttributeOverride(name = "embedded.situacio", column = @Column(name = "avr_sit", length = 250)),
	@AttributeOverride(name = "embedded.maquinaCodi", column = @Column(name = "avr_maq_cod", length = 15)),
	@AttributeOverride(name = "embedded.matricula", column = @Column(name = "avr_mtr", length = 20)),
	@AttributeOverride(name = "embedded.marca", column = @Column(name = "avr_mca", length = 60)),
	@AttributeOverride(name = "embedded.model", column = @Column(name = "avr_mod", length = 60)),
	@AttributeOverride(name = "embedded.referencia", column = @Column(name = "avr_ref", length = 60)),
	@AttributeOverride(name = "embedded.quilometres", column = @Column(name = "avr_qlm", length = 22, precision = 8)),
	@AttributeOverride(name = "embedded.hores", column = @Column(name = "avr_hor", length = 22, precision = 8)),
	@AttributeOverride(name = "embedded.garantia", column = @Column(name = "avr_gar", length = 1)),
	@AttributeOverride(name = "embedded.repararAnomalia", column = @Column(name = "avr_repano", length = 22, precision = 1)),
	@AttributeOverride(name = "embedded.diaFin", column = @Column(name = "avr_diafin", length = 7)),
	@AttributeOverride(name = "embedded.diaRecollida", column = @Column(name = "avr_dialli", length = 7)),
	@AttributeOverride(name = "embedded.confCliente", column = @Column(name = "avr_cnfcli", length = 1)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "avr_obs", length = 1000)),
	@AttributeOverride(name = "embedded.diaCreacio", column = @Column(name = "avr_dia", length = 7)),
	@AttributeOverride(name = "embedded.persEntrega", column = @Column(name = "avr_perlli", length = 60)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "avr_nom", length = 40)),
	@AttributeOverride(name = "embedded.persComunica", column = @Column(name = "avr_persol", length = 30)),
	@AttributeOverride(name = "embedded.numParte", column = @Column(name = "avr_numpat", length = 20)),
	@AttributeOverride(name = "embedded.numVale", column = @Column(name = "avr_numval", length = 15)),
	@AttributeOverride(name = "embedded.ubicacioIni", column = @Column(name = "avr_ubiini", length = 60)),
	@AttributeOverride(name = "embedded.ubicacioTrab", column = @Column(name = "avr_ubitre", length = 60)),
	@AttributeOverride(name = "embedded.ubicacioFin", column = @Column(name = "avr_ubifin", length = 60)),
	@AttributeOverride(name = "embedded.diaAviso", column = @Column(name = "avr_diaavi", length = 7)),
	@AttributeOverride(name = "embedded.domicili", column = @Column(name = "avr_dom", length = 60)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "avr_tel", length = 60)),
	@AttributeOverride(name = "embedded.visita", column = @Column(name = "avr_vst", length = 22, scale = 127)),
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "avr_nif", length = 12)),
	@AttributeOverride(name = "embedded.estat", column = @Column(name = "avr_est", length = 1)),
	@AttributeOverride(name = "embedded.dataEntrada", column = @Column(name = "avr_datent", length = 7)),
	@AttributeOverride(name = "embedded.dataTancament", column = @Column(name = "avr_dattan", length = 7)),
	@AttributeOverride(name = "embedded.pendentRecollir", column = @Column(name = "avr_penrcl", length = 6)),
	@AttributeOverride(name = "embedded.telefon002", column = @Column(name = "avr_tel002", length = 60)),
	@AttributeOverride(name = "embedded.eml", column = @Column(name = "avr_eml", length = 60)),
	@AttributeOverride(name = "embedded.diaSolent", column = @Column(name = "avr_diasolent", length = 7)),
	@AttributeOverride(name = "embedded.diaRectal", column = @Column(name = "avr_diarectal", length = 7)),
	@AttributeOverride(name = "embedded.pagaCta", column = @Column(name = "avr_pagacta", length = 1)),
	@AttributeOverride(name = "embedded.represCli", column = @Column(name = "avr_represcli", length = 1)),
	@AttributeOverride(name = "embedded.aviVadCodi", column = @Column(name = "avi_vad_cod003", length = 22, precision = 10)),
	@AttributeOverride(name = "embedded.latitud", column = @Column(name = "avr_lat", length = 22, precision = 19, scale = 16)),
	@AttributeOverride(name = "embedded.longitud", column = @Column(name = "avr_lon", length = 22, precision = 19, scale = 16)),
	@AttributeOverride(name = "embedded.fin", column = @Column(name = "avr_fin", length = 1)),
	@AttributeOverride(name = "embedded.pen", column = @Column(name = "avr_pen", length = 1)),
	@AttributeOverride(name = "embedded.ordre", column = @Column(name = "avr_ord", length = 22, precision = 2)),
	@AttributeOverride(name = "embedded.diaPrt", column = @Column(name = "avr_diaprt", length = 7)),
	@AttributeOverride(name = "embedded.diaPrtIni", column = @Column(name = "avr_diaprtini", length = 7)),
	@AttributeOverride(name = "embedded.diaPrtFin", column = @Column(name = "avr_diaprtfin", length = 7)),
	@AttributeOverride(name = "embedded.obserOperari", column = @Column(name = "avr_obsope", length = 1000)),
	@AttributeOverride(name = "embedded.con", column = @Column(name = "avr_con", length = 60)),
	@AttributeOverride(name = "embedded.pda", column = @Column(name = "avr_pda", length = 1)),
	@AttributeOverride(name = "embedded.maquina", column = @Column(name = "avr_maq", length = 1000)),
	@AttributeOverride(name = "embedded.descripcioMaquina", column = @Column(name = "avr_desmaq", length = 1000)),
	@AttributeOverride(name = "embedded.observacioPrn", column = @Column(name = "avr_obsprn", length = 2000)),
	@AttributeOverride(name = "embedded.impMat", column = @Column(name = "avr_impmat", length = 22, precision = 18, scale = 2)),
	@AttributeOverride(name = "embedded.impMao", column = @Column(name = "avr_impmao", length = 22, precision = 18, scale = 2)),
	@AttributeOverride(name = "embedded.impDesp", column = @Column(name = "avr_impdesp", length = 22, precision = 18, scale = 2)),
	@AttributeOverride(name = "embedded.impTot", column = @Column(name = "avr_imptot", length = 22, precision = 18, scale = 2)),
	@AttributeOverride(name = "embedded.conCrg", column = @Column(name = "avr_concrg", length = 1)),
	@AttributeOverride(name = "embedded.guid", column = @Column(name = "avr_guid", length = 50)),
	@AttributeOverride(name = "embedded.cobDpl", column = @Column(name = "avr_cobdpl", length = 1)),
	@AttributeOverride(name = "embedded.cobMo", column = @Column(name = "avr_cobmo", length = 1)),
	@AttributeOverride(name = "embedded.cobCon", column = @Column(name = "avr_cobcon", length = 1)),
	@AttributeOverride(name = "embedded.fullObraNum", column = @Column(name = "avr_fob_num", length = 22, precision = 10)),
	@AttributeOverride(name = "embedded.tip", column = @Column(name = "avr_tip", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "avr_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "avr_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "avr_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "avr_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "avr_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_idf_fk"))
})
public class AvariaEntity extends AbstractWithIdentificadorAuditableEntity<Avaria, AvariaPk> {

	@Embedded
	protected Avaria embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_emp_fk"))			
	protected EmpresaEntity empresa;
	@Column(name = "avr_emp_coddti", length = 4)
	private String empresaCodiDesti;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_ope_cod_fk"))
	private OperariEntity operari;
	@Column(name = "avr_ope_cod", length = 6)
	private String operariCodi;
	@Column(name = "avr_ope_atz", length = 6)
	private String operariAut;
	@Column(name = "avr_ope_cod002", length = 6)
	private String operariCodi002;
	@Column(name = "avr_ope_codsup", length = 6)
	private String operariCodiSup;
	@Column(name = "avr_ope_codtec", length = 6)
	private String operariCodiTec;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_pre_cod_fk"))
	private PressupostEntity pressupost;
	@Column(name = "avr_pre_cod", length = 22, precision = 10)
	private Integer pressupostCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "avr_cpo_cod", length = 8)
	private String codiPostalCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_scl_cod_fk"))
	private SubClientEntity subClient;
	@Column(name = "avr_scl_cod", length = 4)
	private String subClientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_cli_cod_fk"))
	private ClientEntity client;
	@Column(name = "avr_cli_cod", length = 6)
	private String clientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "tal_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_emp_cod", referencedColumnName = "tal_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_tal_cod", referencedColumnName = "tal_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "avr_tal_cod_fk"))
	private TallerEntity taller;
	@Column(name = "avr_tal_cod", length = 6)
	private String tallerCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "avr_idf_cod", referencedColumnName = "prj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_emp_cod", referencedColumnName = "prj_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "avr_prj_num", referencedColumnName = "prj_num", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rges_avr_prj_fk"))
	protected ProjecteEntity projecte;
	@Column(name = "avr_prj_num", length = 6)
	private String projecteCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "alb_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_emp_cod", referencedColumnName = "alb_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_alb_numdoc", referencedColumnName = "alb_numdoc", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_alb_fk"))			
	protected AlbaraEntity albara;
	@Column(name = "avr_alb_numdoc", length = 22, precision = 18)
	private Integer albaraNumDoc;
	@Column(name = "avr_alb_numdocdti", length = 22, precision = 18)
	private Integer albaraNumDocDti;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "vad_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_vad_cod", referencedColumnName = "vad_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_vad_fk"))			
	protected MantenimentDeTipusEntity mantenimentDeTipus;
	@Column(name = "avr_vad_cod", length = 22, precision = 10)
	private String mantenimentDeTipusCodi;
	@Column(name = "avr_vad_cod002", length = 22, precision = 10)
	private String mantenimentDeTipusCodi002;
	@Column(name = "avr_vad_cod003", length = 22, precision = 10)
	private String mantenimentDeTipusCodi003;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_tve_codsol", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_tve_fk"))			
	protected TipusVencimentEntity tipusVenciment;
	@Column(name = "avr_tve_codsol", length = 22, precision = 10)
	private String tipusVencimentCodiSon;
	@Column(name = "avr_tve_codacc", length = 22, precision = 10)
	private String tipusVencimentCodiAcc;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_acc_fk"))			
	protected ClientAdresaEntity clientAdresa;
	@Column(name = "avr_acc_cod", length = 4)
	private String clientAdresaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_dpg_fk"))			
	protected DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "avr_dpg_cod", length = 4)
	private String documentPagamentCobramentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "avr_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "avr_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_avr_ser_fk"))			
	protected SerieVendaEntity serieVenda;
	@Column(name = "avr_ser_cod", length = 4)
	private String serieVendaCodi;
	
	
	@Builder
	public AvariaEntity(
			AvariaPk pk,			
			IdentificadorEntity identificador,
			Avaria embedded,
			EmpresaEntity empresa,
			OperariEntity operari,
			PressupostEntity pressupost,
			CodiPostalEntity codiPostal,
			SubClientEntity subClient,
			ClientEntity client,
			TallerEntity taller,
			ProjecteEntity projecte,
			AlbaraEntity albara,
			MantenimentDeTipusEntity mantenimentDeTipus,
			TipusVencimentEntity tipusVenciment,
			ClientAdresaEntity clientAdresa,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			SerieVendaEntity serieVenda) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;

		updateOperari(operari);
		updatePressupost(pressupost);
		updateCodiPostal(codiPostal);
		updateSubClient(subClient);
		updateClient(client);
		updateTaller(taller);
		updateProjecte(projecte);
		updateAlbara(albara);
		updateMantenimentDeTipus(mantenimentDeTipus);
		updateTipusVenciment(tipusVenciment);
		updateClientAdresa(clientAdresa);
		updateDocumentPagamentCobrament(documentPagamentCobrament);
		updateSerieVenda(serieVenda);
	}

	@Override
	public void update(Avaria embedded) {
		this.embedded = embedded;
	}

	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getId().getCodi();
		}
	}
	
	public void updatePressupost(PressupostEntity pressupost) {
		this.pressupost = pressupost;
		if (pressupost != null) {
			this.pressupostCodi = pressupost.getId().getCodi();
		}
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getId().getCodi();
		}
	}
	
	public void updateSubClient(SubClientEntity subClient) {
		this.subClient = subClient;
		if (subClient != null) {
			this.subClientCodi = subClient.getId().getCodi();
		}
	}
	
	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getId().getCodi();
		}
	}
	
	public void updateTaller(TallerEntity taller) {
		this.taller = taller;
		if (taller != null) {
			this.tallerCodi = taller.getId().getCodi();
		}
	}
	
	public void updateProjecte(ProjecteEntity projecte) {
		this.projecte = projecte;
		if (projecte != null) {
			this.projecteCodi = projecte.getId().getCodi();
		}
	}
	
	public void updateAlbara(AlbaraEntity albara) {
		this.albara = albara;
		if (albara != null) {
			this.albaraNumDoc = albara.getEmbedded().getNumeroDocument();
		}
	}
	
	public void updateMantenimentDeTipus(MantenimentDeTipusEntity mantenimentDeTipus) {
		this.mantenimentDeTipus = mantenimentDeTipus;
		if (mantenimentDeTipus != null) {
			this.mantenimentDeTipusCodi = mantenimentDeTipus.getId().getCodi();
		}
	}
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment != null) {
			this.tipusVencimentCodiSon = tipusVenciment.getId().getCodi();
		}
	}
	
	public void updateClientAdresa(ClientAdresaEntity clientAdresa) {
		this.clientAdresa = clientAdresa;
		if (clientAdresa != null) {
			this.clientAdresaCodi = clientAdresa.getId().getCodi();
		}
	}
	
	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobrament = documentPagamentCobrament;
		if (documentPagamentCobrament != null) {
			this.documentPagamentCobramentCodi = documentPagamentCobrament.getId().getCodi();
		}
	}
	
	public void updateSerieVenda(SerieVendaEntity serieVenda) {
		this.serieVenda = serieVenda;
		if (serieVenda != null) {
			this.serieVendaCodi = serieVenda.getId().getCodi();
		}
	}

}
