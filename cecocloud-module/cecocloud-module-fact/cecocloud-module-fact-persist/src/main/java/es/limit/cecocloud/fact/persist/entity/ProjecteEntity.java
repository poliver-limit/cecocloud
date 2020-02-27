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

import es.limit.cecocloud.fact.logic.api.dto.Projecte;
import es.limit.cecocloud.fact.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
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
		@Index(name = "irges_prj_pk", columnList = "prj_idf_cod,prj_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "prj_idf_cod", length = 4)),
		@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "prj_emp_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "id.codi", column = @Column(name = "prj_cod", length = 4)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "prj_cod", length = 4, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.numero", column = @Column(name = "prj_num", length = 6)),
		@AttributeOverride(name = "embedded.nom", column = @Column(name = "prj_nom", length = 250, nullable = false)),
		@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "prj_des", length = 1000)),
		@AttributeOverride(name = "embedded.referencia", column = @Column(name = "prj_ref", length = 20)),
		@AttributeOverride(name = "embedded.observacions", column = @Column(name = "prj_obs", length = 1000)),
		@AttributeOverride(name = "embedded.codiAlternatiu", column = @Column(name = "prj_ali", length = 35)),
		@AttributeOverride(name = "embedded.responsable", column = @Column(name = "prj_res", length = 60)),
		@AttributeOverride(name = "embedded.contactePersona", column = @Column(name = "prj_percon", length = 60)),
		@AttributeOverride(name = "embedded.contacteTelefon", column = @Column(name = "prj_telcon", length = 30)),
		@AttributeOverride(name = "embedded.adreca", column = @Column(name = "prj_dir", length = 200)),
		@AttributeOverride(name = "embedded.estat", column = @Column(name = "prj_est")),
		@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "prj_datini")),
		@AttributeOverride(name = "embedded.dataFi", column = @Column(name = "prj_datfin")),
		@AttributeOverride(name = "embedded.dataFiPrevist", column = @Column(name = "prj_datfinprt")),
		@AttributeOverride(name = "embedded.dataAdjudicacio", column = @Column(name = "prj_diaadj")),
		@AttributeOverride(name = "embedded.dataExecucio", column = @Column(name = "prj_plaeje")),
		@AttributeOverride(name = "embedded.dataRecepcioProvisional", column = @Column(name = "prj_diarebpvi")),
		@AttributeOverride(name = "embedded.dataRecepcioFinal", column = @Column(name = "prj_diarebfin")),
		@AttributeOverride(name = "embedded.dataIniciGarantia", column = @Column(name = "prj_datgar")),
		@AttributeOverride(name = "embedded.dataDevolucioAval", column = @Column(name = "prj_diadevava")),
		@AttributeOverride(name = "embedded.horesEquiv", column = @Column(name = "prj_horequ")),
		@AttributeOverride(name = "embedded.horesEquivConstruccio", column = @Column(name = "prj_horeqc")),
		@AttributeOverride(name = "embedded.horesEquivGarantia", column = @Column(name = "prj_horeqg")),
		@AttributeOverride(name = "embedded.percentExecucioLliure", column = @Column(name = "prj_pteeje")),
		@AttributeOverride(name = "embedded.percentExecucioConstruccio", column = @Column(name = "prj_pteejc")),
		@AttributeOverride(name = "embedded.percentExecucioGarantia", column = @Column(name = "prj_pteejg")),
		@AttributeOverride(name = "embedded.divisaValorEuros", column = @Column(name = "prj_valdiveur")),
		@AttributeOverride(name = "embedded.valorEstimat", column = @Column(name = "prj_valetm")),
		@AttributeOverride(name = "embedded.importFianca", column = @Column(name = "prj_impfia")),
		@AttributeOverride(name = "embedded.dipositFianca", column = @Column(name = "prj_dipfia", length = 250)),
		@AttributeOverride(name = "embedded.direccioTecnica", column = @Column(name = "prj_dirtec", length = 60)),
		@AttributeOverride(name = "embedded.albaransClientCrear", column = @Column(name = "prj_crealbcli", length = 1)),
		@AttributeOverride(name = "embedded.albaransClientPreu", column = @Column(name = "prj_prualbcli")),
		@AttributeOverride(name = "embedded.albaransClientProjecteTipus", column = @Column(name = "prj_tip")),
		@AttributeOverride(name = "embedded.dietes", column = @Column(name = "prj_dta", length = 1)),
		@AttributeOverride(name = "embedded.plusPerillositat", column = @Column(name = "prj_plspel", length = 1)),
		@AttributeOverride(name = "embedded.controlarCostos", column = @Column(name = "prj_crlcos", length = 1)),
		@AttributeOverride(name = "embedded.horesCami", column = @Column(name = "prj_horrut")),
		@AttributeOverride(name = "embedded.estudiDespesesGenerals", column = @Column(name = "prj_gstgen")),
		@AttributeOverride(name = "embedded.estudiBaixaPercent", column = @Column(name = "prj_baj")),
		@AttributeOverride(name = "embedded.estudiTasaPercent", column = @Column(name = "prj_tas")),
		@AttributeOverride(name = "embedded.estudiSumarValoracioEnExces", column = @Column(name = "prj_valexc", length = 1)),
		@AttributeOverride(name = "embedded.mesosGarantia", column = @Column(name = "prj_mesgar")),
		@AttributeOverride(name = "embedded.tipusInversio", column = @Column(name = "prj_tipinv", length = 1)),
		@AttributeOverride(name = "embedded.retencioPercent", column = @Column(name = "prj_ret")),
		@AttributeOverride(name = "embedded.retencioTipus", column = @Column(name = "prj_tipret", length = 1)),
		@AttributeOverride(name = "embedded.comptabilitatCodiProjecte", column = @Column(name = "prj_codcmp", length = 4)),

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

public class ProjecteEntity extends AbstractWithIdentificadorAuditableEntity<Projecte, ProjectePk> {

	@Embedded
	protected Projecte embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_emp_cod_fk"))
	private EmpresaEntity empresa;
	@Column(name = "prj_emp_cod", length = 4, insertable = false, updatable = false)
	private String empresaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
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
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "tpj_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_tpj_cod", referencedColumnName = "tpj_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_tpj_cod_fk"))
	private ProjecteTipusEntity projecteTipus;
	@Column(name = "prj_tpj_cod", length = 6, insertable = false, updatable = false)
	private String projecteTipusCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_ope_cod_fk"))
	private OperariEntity operariResponsable;
	@Column(name = "prj_ope_cod", length = 6, insertable = false, updatable = false)
	private String operariResponsableCodi;

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
						@JoinColumn(name = "prj_ope_enccod", referencedColumnName = "ope_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ope_enccod_fk"))
	private OperariEntity operariEncarregat;
	@Column(name = "prj_ope_enccod", length = 6)
	private String operariEncarregatCodi;

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
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_ser_cod_fk"))
	private SerieVendaEntity serie;
	@Column(name = "prj_ser_cod", length = 2, insertable = false, updatable = false)
	private String serieCodi;

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
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "scl_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cli_cod", referencedColumnName = "scl_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_scl_cod", referencedColumnName = "scl_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_scl_cod_fk"))
	private SubClientEntity subClient;
	@Column(name = "prj_scl_cod", length = 6, insertable = false, updatable = false)
	private String subClientCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "acc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cli_cod", referencedColumnName = "acc_cli_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_acc_cod", referencedColumnName = "acc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_acc_cod_fk"))
	private ClientAdresaEntity clientAdresa;
	@Column(name = "prj_acc_cod", length = 4, insertable = false, updatable = false)
	private String clientAdresaCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "prj_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "prj_cpo_cod", length = 8, insertable = false, updatable = false)
	private String codiPostalCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "clr_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_clr_cod", referencedColumnName = "clr_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_clr_cod_fk"))
	private ClasseRetencioEntity retencioClasse;
	@Column(name = "prj_clr_cod", length = 4)
	private String retencioClasseCodi;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ane_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_emp_cod", referencedColumnName = "ane_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ane_cod", referencedColumnName = "ane_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ane_cod_fk"))
	private AreaNegociEntity areaNegoci;
	@Column(name = "prj_ane_cod", length = 4, insertable = false, updatable = false)
	private String areaNegociCodi;

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
						@JoinColumn(name = "prj_idf_cod", referencedColumnName = "ffa_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "prj_ffa_cod", referencedColumnName = "ffa_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "prj_ffa_cod_fk"))
	private FinalFacturaEntity finalFactura;
	@Column(name = "prj_ffa_cod", length = 4)
	private String finalFacturaCodi;

	@Builder
	public ProjecteEntity(ProjectePk pk, 
			Projecte embedded, 
			IdentificadorEntity identificador, 
			EmpresaEntity empresa,
			DivisaEntity divisa, 
			ProjecteTipusEntity projecteTipus, 
			OperariEntity operariResponsable,
			OperariEntity operariCapGrup, 
			OperariEntity operariEncarregat, 
			OperariEntity operariAdministratiu,
			SerieVendaEntity serie, 
			ClientEntity client,
			SubClientEntity subClient, 
			ClientAdresaEntity clientAdresa,
			CodiPostalEntity codiPostal, 
			ClasseRetencioEntity retencioClasse, 
			AreaNegociEntity areaNegoci,
			MagatzemEntity magatzem, 
			ZonaEntity zona, 
			FinalFacturaEntity finalFactura) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		updateEmpresa(empresa);
		updateDivisa(divisa);
		updateProjecteTipus(projecteTipus);
		updateOperariResponsable(operariResponsable);
		updateOperariCapGrup(operariCapGrup);
		updateOperariEncarregat(operariEncarregat);
		updateOperariAdministratiu(operariAdministratiu);
		updateSerie(serie);
		updateClient(client);
		updateSubClient(subClient);
		updateClientAdresa(clientAdresa);
		updateCodiPostal(codiPostal);
		updateRetencioClasse(retencioClasse);
		updateAreaNegoci(areaNegoci);
		updateMagatzem(magatzem);
		updateZona(zona);
		updateFinalFactura(finalFactura);
	}

	@Override
	public void update(Projecte embedded) {
		this.embedded = embedded;
	}

	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
		if (empresa != null) {
			this.empresaCodi = empresa.getId().getCodi();
		}
	}

	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getId().getCodi();
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

	public void updateRetencioClasse(ClasseRetencioEntity retencioClasse) {
		this.retencioClasse = retencioClasse;
		if (retencioClasse != null) {
			this.retencioClasseCodi = retencioClasse.getId().getCodi();
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

}
