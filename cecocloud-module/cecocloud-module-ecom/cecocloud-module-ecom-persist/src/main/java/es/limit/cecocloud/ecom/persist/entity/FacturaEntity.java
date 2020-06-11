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

import es.limit.cecocloud.ecom.logic.api.dto.Factura;
import es.limit.cecocloud.ecom.logic.api.dto.Factura.FacturaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomFacturaEntity")
@Table(
		name = "tcom_fac",
		indexes = {
				@Index(name = "ircom_fac_pk", columnList = "fac_idf_cod,fac_emp_cod,fac_cls,fac_num,fac_ser_cod", unique = true),
				@Index(name = "icom_fac_idf_fk", columnList = "fac_idf_cod"),
				@Index(name = "icom_fac_emp_fk", columnList = "fac_emp_cod"),
				@Index(name = "icom_fac_ser_fk", columnList = "fac_ser_cod")				
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "fac_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "fac_emp_cod", length = 4)),
	@AttributeOverride(name = "id.serieVendaCodi", column = @Column(name = "fac_ser_cod", length = 2)),
	@AttributeOverride(name = "id.classe", column = @Column(name = "fac_cls", length = 1)),
	@AttributeOverride(name = "id.numero", column = @Column(name = "fac_num", length = 22, precision = 10)),	
	
	@AttributeOverride(name = "embedded.classe", column = @Column(name = "fac_cls", length = 1, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "fac_num", length = 22, precision = 10, insertable = false, updatable = false)),
	
	@AttributeOverride(name = "embedded.dia", column = @Column(name = "fac_dia", length = 7, nullable = false)),
	@AttributeOverride(name = "embedded.nomFiscalClient", column = @Column(name = "fac_nomfiscli", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.formaPagament", column = @Column(name = "fac_fpa", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.valorDivisaEuros", column = @Column(name = "fac_valdiveur", length = 22, precision = 15, scale = 8, nullable = false)),
	@AttributeOverride(name = "embedded.importBrut", column = @Column(name = "fac_bru", length = 22, precision = 15, scale = 3, nullable = false)),
	@AttributeOverride(name = "embedded.baseImposable", column = @Column(name = "fac_bim", length = 22, precision = 15, scale = 3, nullable = false)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "fac_tot", length = 22, precision = 15, scale = 3, nullable = false)),
	@AttributeOverride(name = "embedded.recarrecEquivalencia", column = @Column(name = "fac_recequ", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.cos", column = @Column(name = "fac_cos", length = 22, precision = 15, scale = 3, nullable = false)),	
	@AttributeOverride(name = "embedded.referencia", column = @Column(name = "fac_ref", length = 100)),	
	
	// Dades extres pel client no registrat:
	@AttributeOverride(name = "embedded.codiClient", column = @Column(name = "fac_cli_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "fac_cli_nomfis", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "fac_cli_nomcom", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "fac_cli_tipnif", length = 1)),	
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "fac_cli_nif", length = 12)),
	@AttributeOverride(name = "embedded.nomDomicili", column = @Column(name = "fac_cli_nomdom", length = 30)),
	@AttributeOverride(name = "embedded.numeroDomicili", column = @Column(name = "fac_cli_numdom", length = 5)),
	@AttributeOverride(name = "embedded.escalaDomicili", column = @Column(name = "fac_cli_escdom", length = 2)),
	@AttributeOverride(name = "embedded.pisDomicili", column = @Column(name = "fac_cli_pisdom", length = 2)),
	@AttributeOverride(name = "embedded.portaDomicili", column = @Column(name = "fac_cli_pordom", length = 2)),
	@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "fac_cli_domfis", length = 60)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "fac_cli_tel", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "fac_cli_eml", length = 60)),
	@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "fac_cli_emlfac", length = 100)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "fac_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "fac_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "fac_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "fac_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "fac_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_fac_idf_fk"))
})

public class FacturaEntity extends AbstractWithIdentificadorAuditableEntity<Factura, FacturaPk> {

	@Embedded
	protected Factura embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fac_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fac_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_fac_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fac_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fac_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fac_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_fac_ser_fk"))
	private SerieVendaEntity serieVenda;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_cli_fk"))
	private ClientEntity client;
	@Column(name = "fac_cli_cod", length = 6, nullable = false)
	private String clientCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "fac_cpo_cod_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "fac_cpo_cod", length = 8, nullable = false)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "fac_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "fac_rgi_cod_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "fac_rgi_cod", length = 2, nullable = false)
	private String regimIvaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "fac_tve_cod_fk"))	
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "fac_tve_cod", length = 4, nullable = false)
	private String tipusVencimentCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fac_idf_cod", referencedColumnName = "pre_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fac_pre_cod", referencedColumnName = "pre_cod", insertable = false, updatable = false),
					@JoinColumn(name = "fac_emp_cod", referencedColumnName = "pre_emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_fac_pre_fk"))
	protected PressupostEntity pressupost;
	@Column(name = "fac_pre_cod", length = 22)
	private Integer pressupostCodi;

	// Dades extres pel client no registrat:
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "fac_cli_painif", referencedColumnName = "pni_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_fac_cli_pni_fk"))
	private PaisNifEntity paisNif;
	@Column(name = "fac_cli_painif", length = 4)
	private String paisNifCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {						
						@JoinColumn(name = "fac_cli_sgl", referencedColumnName = "tad_cod", insertable = false, updatable = false)
			},		
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@NotFound(action = NotFoundAction.IGNORE)
	private TipusAdresaEntity tipusAdresa;
	@Column(name = "fac_cli_sgl", length = 4)
	private String tipusAdresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_cli_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_cli_cpo_fk"))
	private CodiPostalEntity codiPostalClient;
	@Column(name = "fac_cli_cpo_cod", length = 8)
	private String codiPostalClientCodi;
	
	//	Extres que originalment no hi eren a TGES:
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_idi_fk"))
	private IdiomaEntity idioma;
	@Column(name = "fac_idi_cod", length = 4)
	private String idiomaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "pas_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_pas_cod", referencedColumnName = "pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_pai_fk"))
	private PaisEntity pais;
	@Column(name = "fac_pas_cod", length = 4)
	private String paisCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "prv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_prv_cod", referencedColumnName = "prv_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_pas_cod", referencedColumnName = "prv_pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_prv_fk"))
	private ProvinciaEntity provincia;
	@Column(name = "fac_prv_cod", length = 4)
	private String provinciaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "fac_dpg_cod", length = 4)
	private String documentPagamentCobramentCodi;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "fac_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "fac_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false), 
			},
			foreignKey = @ForeignKey(name = "rcom_fac_ptv_fk"))
	private PuntVendaEntity puntVenda;
	@Column(name = "fac_ptv_cod", length = 4)
	private String puntVendaCodi;
	
//	FALTA QUE AQUESTES ENTITATS HI RELACIONIN
//	relacions	taules relacions amb albarà facturat
//	relacions	taules relacions amb bases factura
//	relacions	taules relacions amb venciment
//	relacions	donar per cobrada un factura.

	
	@Builder
	public FacturaEntity(
			FacturaPk pk,
			Factura embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serieVenda,
			ClientEntity client,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa,
			RegimIvaEntity regimIva,
			TipusVencimentEntity tipusVenciment,
			PressupostEntity pressupost,
			
			PaisNifEntity paisNif,
			TipusAdresaEntity tipusAdresa,
			CodiPostalEntity codiPostalClient,
			
			IdiomaEntity idioma,			
			PaisEntity pais,
			ProvinciaEntity provincia,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			PuntVendaEntity puntVenda) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;
		this.serieVenda = serieVenda;
		
		this.updateClient (client);
		this.updateCodiPostal (codiPostal);
		this.updateDivisa (divisa);
		this.updateRegimIva (regimIva);
		this.updateTipusVenciment (tipusVenciment);
		this.updatePressupost (pressupost);
		
		this.updatePaisNif(paisNif);
		this.updateTipusAdresa(tipusAdresa);
		this.updateCodiPostalClient(codiPostalClient);	
		
		this.updateIdioma(idioma);
		this.updatePais(pais);
		this.updateProvincia(provincia);
		this.updateDocumentPagamentCobrament(documentPagamentCobrament);
		this.updatePuntVenda(puntVenda);
	}

	@Override
	public void update(Factura embedded) {
		this.embedded = embedded;
	}
	
	public void updateClient(ClientEntity client) {
		this.client = client;
		if (client != null) {
			this.clientCodi = client.getEmbedded().getCodi();
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
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		if (regimIva != null) {
			this.regimIvaCodi = regimIva.getEmbedded().getCodi();
		}
	}
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment != null) {
			this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
		}
	}
	
	public void updatePressupost(PressupostEntity pressupost) {
		this.pressupost = pressupost;
		if (pressupost != null) {
			this.pressupostCodi = pressupost.getEmbedded().getCodi();
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
	
	public void updatePuntVenda(PuntVendaEntity puntVenda) {
		this.puntVenda = puntVenda;
		if (puntVenda != null) {
			this.puntVendaCodi = puntVenda.getEmbedded().getCodi();
		}
	}

}
