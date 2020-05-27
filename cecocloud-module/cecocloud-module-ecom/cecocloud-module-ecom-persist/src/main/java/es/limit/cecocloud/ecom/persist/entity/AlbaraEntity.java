/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import es.limit.cecocloud.ecom.logic.api.dto.Albara;
import es.limit.cecocloud.ecom.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.ecom.persist.entity.MagatzemPeriodeEntity;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un albara
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomAlbaraEntity")
@Table(
		name = "tcom_alb",
		indexes = {
				@Index(name = "icom_alb_idf_fk", columnList = "alb_idf_cod"),
				@Index(name = "ircom_alb_pk", columnList = "alb_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "alb_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "alb_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "alb_numdoc", length = 4)),
	
	//@AttributeOverride(name = "embedded.codi", column = @Column(name = "alb_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.numeroDocument", column = @Column(name = "alb_numdoc", insertable = false, updatable= false)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "alb_num", nullable = false)),
	@AttributeOverride(name = "embedded.classe", column = @Column(name = "alb_cls", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.serCodfac", column = @Column(name = "alb_ser_codfac", length = 2)),
	@AttributeOverride(name = "embedded.data", column = @Column(name = "alb_dia", nullable = false)),
	@AttributeOverride(name = "embedded.formaPago", column = @Column(name = "alb_fpa", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.facturable", column = @Column(name = "alb_fbl", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.desti", column = @Column(name = "alb_dti", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.divisaValorEuros", column = @Column(name = "alb_valdiveur", nullable = false)),
	@AttributeOverride(name = "embedded.facturaNumero", column = @Column(name = "alb_fac_num")),
	@AttributeOverride(name = "embedded.facturaClasse", column = @Column(name = "alb_fac_cls")),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "alb_obs", length = 1000)),
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "alb_pru", precision = 15, scale = 8)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "alb_pruiva", precision = 15, scale = 8)),
	
	// Dades extres pel client no registrat:
	@AttributeOverride(name = "embedded.codiClient", column = @Column(name = "alb_cli_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "alb_cli_nomfis", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "alb_cli_nomcom", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "alb_cli_tipnif", length = 1)),	
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "alb_cli_nif", length = 12)),
	@AttributeOverride(name = "embedded.nomDomicili", column = @Column(name = "alb_cli_nomdom", length = 30)),
	@AttributeOverride(name = "embedded.numeroDomicili", column = @Column(name = "alb_cli_numdom", length = 5)),
	@AttributeOverride(name = "embedded.escalaDomicili", column = @Column(name = "alb_cli_escdom", length = 2)),
	@AttributeOverride(name = "embedded.pisDomicili", column = @Column(name = "alb_cli_pisdom", length = 2)),
	@AttributeOverride(name = "embedded.portaDomicili", column = @Column(name = "alb_cli_pordom", length = 2)),
	@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "alb_cli_domfis", length = 60)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "alb_cli_tel", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "alb_cli_eml", length = 60)),
	@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "alb_cli_emlfac", length = 100)),		
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "alb_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "alb_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "alb_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "alb_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "alb_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_idf_fk"))
})
public class AlbaraEntity extends AbstractWithIdentificadorAuditableEntity<Albara, AlbaraPk> {

	@Embedded
	protected Albara embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_alb_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_alb_ptv_fk"))
	protected PuntVendaEntity puntVenda;
	@Column(name = "alb_ptv_cod", length = 4, nullable = false)
	private String puntVendaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "alb_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_ope_fk"))
	private OperariEntity operari;
	@Column(name = "alb_ope_cod", length = 6, nullable = false)
	private String operariCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "alb_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_ser_fk"))
	private SerieVendaEntity serieVenda;
	@Column(name = "alb_ser_cod", length = 2)
	private String serieVendaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_mag_fk"))
	private MagatzemEntity magatzem;
	@Column(name = "alb_mag_cod", length = 4)
	private String magatzemCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "alb_idf_cod", referencedColumnName = "pmg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_mag_cod", referencedColumnName = "pmg_mag_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_pmg_cod", referencedColumnName = "pmg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_pmg_fk"))
	protected MagatzemPeriodeEntity magatzemPeriode;
	@Column(name = "alb_pmg_cod")
	private String magatzemPeriodeCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "alb_div_cod", length = 4)
	private String divisaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "alb_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "alb_cpo_cod", length = 8)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "alb_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "alb_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_opecml_fk"))
	private OperariEntity operariCml;
	@Column(name = "alb_ope_codcml", length = 6, nullable = false)
	private String operariCmlCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_cli_fk"))
	private ClientEntity client;
	@Column(name = "alb_cli_cod", length = 6)
	private String clientCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_alb_pre_fk"))
	protected PressupostEntity pressupost;
	@Column(name = "alb_pre_cod", length = 4, nullable = true)
	private Integer pressupostCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_iva_fk"))
	private IvaEntity iva;
	@Column(name = "alb_iva_cod", length = 4)
	private String ivaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_idi_fk"))
	private IdiomaEntity idioma;
	@Column(name = "alb_idi_cod", length = 4)
	private String idiomaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "pas_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_pas_cod", referencedColumnName = "pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_pai_fk"))
	private PaisEntity pais;
	@Column(name = "alb_pas_cod", length = 4)
	private String paisCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "prv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_prv_cod", referencedColumnName = "prv_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_pas_cod", referencedColumnName = "prv_pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_prv_fk"))
	private ProvinciaEntity provincia;
	@Column(name = "alb_prv_cod", length = 4)
	private String provinciaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "alb_dpg_cod", length = 4)
	private String documentPagamentCobramentCodi;	
	
	// Dades extres pel client no registrat:
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "alb_cli_painif", referencedColumnName = "pni_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_alb_cli_pni_fk"))
	private PaisNifEntity paisNif;
	@Column(name = "alb_cli_painif", length = 4)
	private String paisNifCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {						
						@JoinColumn(name = "alb_cli_sgl", referencedColumnName = "tad_cod", insertable = false, updatable = false)
			},		
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@NotFound(action = NotFoundAction.IGNORE)
	private TipusAdresaEntity tipusAdresa;
	@Column(name = "alb_cli_sgl", length = 4)
	private String tipusAdresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "alb_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "alb_cli_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_alb_cli_cpo_fk"))
	private CodiPostalEntity codiPostalClient;
	@Column(name = "alb_cli_cpo_cod", length = 8)
	private String codiPostalClientCodi;
	
	// Falta afegir "clients proveïdors"
	// Transportista i vehicles
	// codi,nom transportista, codis vehicles i descrupcions.
	
	@Builder
	public AlbaraEntity(
			AlbaraPk pk,
			Albara embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,			
			PuntVendaEntity puntVenda,
			OperariEntity operari,
			SerieVendaEntity serieVenda,
			MagatzemEntity magatzem,
			MagatzemPeriodeEntity magatzemPeriode,
			DivisaEntity divisa,
			CodiPostalEntity codiPostal,
			OperariEntity operariCml,
			ClientEntity client,
			PressupostEntity pressupost,
			IvaEntity iva,
			IdiomaEntity idioma,
			PaisEntity pais,
			ProvinciaEntity provincia,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			
			PaisNifEntity paisNif,
			TipusAdresaEntity tipusAdresa,
			CodiPostalEntity codiPostalClient
			) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		
		this.updatePuntVenda(puntVenda);
		this.updateOperari(operari);
		this.updateSerieVenda(serieVenda);
		this.updateMagatzem(magatzem);
		this.updateMagatzemPeriode(magatzemPeriode);
		this.updateDivisa(divisa);
		this.updateCodiPostal(codiPostal);
		this.updateOperariCml(operariCml);
		this.updateClient(client);
		this.updatePressupost(pressupost);
		this.updateIva(iva);
		this.updateIdioma(idioma);
		this.updatePais(pais);
		this.updateProvincia(provincia);
		this.updateDocumentPagamentCobrament(documentPagamentCobrament);
		
		this.updatePaisNif(paisNif);
		this.updateTipusAdresa(tipusAdresa);
		this.updateCodiPostalClient(codiPostalClient);
		
		
		
	}

	@Override
	public void update(Albara embedded) {
		this.embedded = embedded;
	}
	
	public void updatePuntVenda(PuntVendaEntity puntVenda) {
		this.puntVenda = puntVenda;
		if (puntVenda != null) {
			this.puntVendaCodi = puntVenda.getEmbedded().getCodi();
		}
	}
	
	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}
	
	public void updateOperariCml(OperariEntity operariCml) {
		this.operariCml = operariCml;
		if (operariCml != null) {
			this.operariCmlCodi = operariCml.getEmbedded().getCodi();
		}
	}
	
	public void updateSerieVenda(SerieVendaEntity serieVenda) {
		this.serieVenda = serieVenda;
		if (serieVenda != null) {
			this.serieVendaCodi = serieVenda.getEmbedded().getCodi();
		}
	}
	
	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getEmbedded().getCodi();
		}
	}
	
	public void updatePressupost(PressupostEntity pressupost) {
		this.pressupost = pressupost;
		if (pressupost != null) {
			this.pressupostCodi = pressupost.getEmbedded().getCodi();
		}
	}
	
	public void updateIva(IvaEntity iva) {
		this.iva = iva;
		if (iva != null) {
			this.ivaCodi = iva.getEmbedded().getCodi();
		}
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		if (divisa != null) {
			this.divisaCodi = divisa.getEmbedded().getCodi();
		}
	}
	
	public void updateMagatzem(MagatzemEntity magatzem) {
		this.magatzem = magatzem;
		if (magatzem != null) {
			this.magatzemCodi = magatzem.getEmbedded().getCodi();
		}
	}
	
	public void updateMagatzemPeriode(MagatzemPeriodeEntity magatzemPeriode) {
		this.magatzemPeriode = magatzemPeriode;
		if (magatzemPeriode != null) {
			this.magatzemPeriodeCodi = magatzemPeriode.getEmbedded().getCodi();
		}
	}
	
	public void updateIdioma(IdiomaEntity idioma) {
		this.idioma = idioma;
		if (idioma != null) {
			this.idiomaCodi = idioma.getEmbedded().getCodi();
		}
	}
	
	public void updatePais(PaisEntity pais) {
		this.pais = pais;
		if (pais != null) {
			this.paisCodi = pais.getEmbedded().getCodi();
		}
	}
	
	public void updateProvincia(ProvinciaEntity provincia) {
		this.provincia = provincia;
		if (provincia != null) {
			this.provinciaCodi = provincia.getEmbedded().getCodi();
		}
	}
	
	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobrament = documentPagamentCobrament;
		if (documentPagamentCobrament != null) {
			this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
		}
	}
	
	public void updatePaisNif(PaisNifEntity paisNif) {
		this.paisNif = paisNif;
		if (paisNif != null) {
			this.paisNifCodi = paisNif.getEmbedded().getCodi();
		}
	}
	
	public void updateTipusAdresa(TipusAdresaEntity tipusAdresa) {
		this.tipusAdresa = tipusAdresa;
		if (tipusAdresa != null) {
			this.tipusAdresaCodi = tipusAdresa.getEmbedded().getCodi();
		}
	}
	
	public void updateCodiPostalClient(CodiPostalEntity codiPostalClient) {
		this.codiPostalClient = codiPostalClient;
		if (codiPostalClient != null) {
			this.codiPostalClientCodi = codiPostalClient.getEmbedded().getCodi();
		}
	}
	

}
