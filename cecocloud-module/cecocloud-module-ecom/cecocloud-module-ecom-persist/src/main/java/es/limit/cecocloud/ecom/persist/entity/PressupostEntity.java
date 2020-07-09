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

import es.limit.cecocloud.ecom.logic.api.dto.Pressupost;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.ecom.persist.entity.ClientEntity;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomPressupostEntity")
@Table(
		name = "tcom_pre",
		indexes = {				
				@Index(name = "rcom_pre_pk", columnList = "pre_idf_cod,pre_emp_cod,pre_cod", unique = true),
				@Index(name = "icom_pre_emp_fk", columnList = "pre_idf_cod, pre_emp_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pre_idf_cod", length = 22)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "pre_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pre_cod", length = 22, precision = 10)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pre_cod", insertable = false, updatable = false, length = 22)),
	@AttributeOverride(name = "embedded.numero", column = @Column(name = "pre_num", nullable = false, length = 22, precision = 10, scale = 0)),	
	@AttributeOverride(name = "embedded.versio", column = @Column(name = "pre_ver", nullable = false, length = 22, precision = 2, scale = 0)),	
	@AttributeOverride(name = "embedded.data", column = @Column(name = "pre_dia", nullable = false, length = 7)),	
	@AttributeOverride(name = "embedded.dataInici", column = @Column(name = "pre_diaini", length = 7)),
	@AttributeOverride(name = "embedded.estat", column = @Column(name = "pre_est", length = 1)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "pre_obs", length = 2000)),
	@AttributeOverride(name = "embedded.versio", column = @Column(name = "pre_ver", nullable = false, length = 22, precision = 2, scale = 0)),	
	@AttributeOverride(name = "embedded.preu", column = @Column(name = "pre_pru", precision = 15, scale = 8)),
	@AttributeOverride(name = "embedded.preuAmbIva", column = @Column(name = "pre_pruiva", precision = 15, scale = 8)),
	
	@AttributeOverride(name = "embedded.sync", column = @Column(name = "pre_sync", length = 1)),	
	// Dades extres pel client no registrat:
	@AttributeOverride(name = "embedded.codiClient", column = @Column(name = "pre_cli_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "pre_cli_nomfis", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "pre_cli_nomcom", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "pre_cli_tipnif", length = 1)),	
	@AttributeOverride(name = "embedded.nif", column = @Column(name = "pre_cli_nif", length = 12)),
	@AttributeOverride(name = "embedded.nomDomicili", column = @Column(name = "pre_cli_nomdom", length = 30)),
	@AttributeOverride(name = "embedded.numeroDomicili", column = @Column(name = "pre_cli_numdom", length = 5)),
	@AttributeOverride(name = "embedded.escalaDomicili", column = @Column(name = "pre_cli_escdom", length = 2)),
	@AttributeOverride(name = "embedded.pisDomicili", column = @Column(name = "pre_cli_pisdom", length = 2)),
	@AttributeOverride(name = "embedded.portaDomicili", column = @Column(name = "pre_cli_pordom", length = 2)),
	@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "pre_cli_domfis", length = 60)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "pre_cli_tel", length = 60)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "pre_cli_eml", length = 60)),
	@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "pre_cli_emlfac", length = 100)),		
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "pre_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pre_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pre_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pre_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pre_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pre_idf_fk"))
})
//@EntityListeners({PressupostEntityListener.class})
public class PressupostEntity extends AbstractWithIdentificadorAuditableEntity<Pressupost, PressupostPk> {

	@Embedded
	protected Pressupost embedded;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_pre_emp_fk"))
	protected EmpresaEntity empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "ser_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "ser_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_ser_cod", referencedColumnName = "ser_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_ser_fk"))
	private SerieVendaEntity serieVenda;
	@Column(name = "pre_ser_cod", length = 2, nullable = false)
	private String serieVendaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "cli_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cli_cod", referencedColumnName = "cli_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_cli_fk"))
	private ClientEntity client;
	@Column(name = "pre_cli_cod", length = 6)
	private String clientCodi;
	
//	@ManyToOne(optional = true, fetch = FetchType.LAZY)
//	@JoinColumns(
//			value = {
//						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
//						@JoinColumn(name = "pre_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
//			},
//			foreignKey = @ForeignKey(name = "rcom_pre_iva_fk"))
//	private IvaEntity iva;
//	@Column(name = "pre_iva_cod", length = 4)
//	private String ivaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "pre_cpo_cod", length = 8)
	private String codiPostalCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "pre_div_cod", length = 4)
	private String divisaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_mag_fk"))
	private MagatzemEntity magatzem;
	@Column(name = "pre_mag_cod", length = 4)
	private String magatzemCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_idi_fk"))
	private IdiomaEntity idioma;
	@Column(name = "pre_idi_cod", length = 4)
	private String idiomaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "pas_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_pas_cod", referencedColumnName = "pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_pai_fk"))
	private PaisEntity pais;
	@Column(name = "pre_pas_cod", length = 4)
	private String paisCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "prv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_prv_cod", referencedColumnName = "prv_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_pas_cod", referencedColumnName = "prv_pas_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_prv_fk"))
	private ProvinciaEntity provincia;
	@Column(name = "pre_prv_cod", length = 4)
	private String provinciaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;
	@Column(name = "pre_dpg_cod", length = 4)
	private String documentPagamentCobramentCodi;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "ptv_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_emp_cod", referencedColumnName = "ptv_emp_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_ptv_cod", referencedColumnName = "ptv_cod", insertable = false, updatable = false), 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_ptv_fk"))
	private PuntVendaEntity puntVenda;
	@Column(name = "pre_ptv_cod", length = 4)
	private String puntVendaCodi;	
	
	// Dades extres pel client no registrat:
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pre_cli_painif", referencedColumnName = "pni_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pre_cli_pni_fk"))
	private PaisNifEntity paisNif;
	@Column(name = "pre_cli_painif", length = 4)
	private String paisNifCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {						
						@JoinColumn(name = "pre_cli_sgl", referencedColumnName = "tad_cod", insertable = false, updatable = false)
			},		
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@NotFound(action = NotFoundAction.IGNORE)
	private TipusAdresaEntity tipusAdresa;
	@Column(name = "pre_cli_sgl", length = 2)
	private String tipusAdresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "pre_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "pre_cli_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "rcom_pre_cli_cpo_fk"))
	private CodiPostalEntity codiPostalClient;
	@Column(name = "pre_cli_cpo_cod", length = 8)
	private String codiPostalClientCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pre_idf_cod", referencedColumnName = "ope_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pre_ope_cod", referencedColumnName = "ope_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pre_ope_fk"))
	private OperariEntity operari;
	@Column(name = "pre_ope_cod", length = 6, nullable = false)
	private String operariCodi;
	
	@Builder
	public PressupostEntity(
			PressupostPk pk,
			Pressupost embedded,
			IdentificadorEntity identificador,
			EmpresaEntity empresa,
			SerieVendaEntity serieVenda,
			ClientEntity client,
//			IvaEntity iva,
			CodiPostalEntity codiPostal,
			DivisaEntity divisa,
			MagatzemEntity magatzem,
			IdiomaEntity idioma,			
			PaisEntity pais,
			ProvinciaEntity provincia,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			PuntVendaEntity puntVenda,
			PaisNifEntity paisNif,
			TipusAdresaEntity tipusAdresa,
			CodiPostalEntity codiPostalClient,
			OperariEntity operari
			) {
		
		setId(pk);		

		this.embedded = embedded;
		this.identificador = identificador;
		this.empresa = empresa;		
		
		this.updateSync();
		this.updateNumeroPressupost(serieVenda);
		this.updateSerieVenda(serieVenda);		
		this.updateClient(client);
//		this.updateIva(iva);
		this.updateCodiPostal(codiPostal);
		this.updateDivisa(divisa);
		this.updateMagatzem(magatzem);
		this.updateIdioma(idioma);
		this.updatePais(pais);
		this.updateProvincia(provincia);
		this.updateDocumentPagamentCobrament(documentPagamentCobrament);
		this.updatePuntVenda(puntVenda);
		this.updatePaisNif(paisNif);
		this.updateTipusAdresa(tipusAdresa);
		this.updateCodiPostalClient(codiPostalClient);	
		this.updateOperari(operari);
			
	}

	@Override
	public void update(Pressupost embedded) {
		this.embedded = embedded;
		this.updateSync();
	}	
	
	public void updateSync() {
		this.embedded.setSync(false);		
	}
	
	public void updateNumeroPressupost(SerieVendaEntity serieVenda) {
		
		Integer numeroPressupost = this.embedded.getNumero();
		if ((numeroPressupost==0)||(numeroPressupost==null)) {
			Integer darrerPressupost = serieVenda.getEmbedded().getDarrerPressupost();
			numeroPressupost = darrerPressupost + 1;		
			this.embedded.setNumero(numeroPressupost);
			serieVenda.getEmbedded().setDarrerPressupost(numeroPressupost);
		
			// Assignació del numero de pressupost al codi si aquest ve null
			Integer codiPressupost = this.embedded.getCodi();
			if (codiPressupost==null) {
				this.embedded.setCodi(numeroPressupost);			
			}
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
	
//	public void updateIva(IvaEntity iva) {
//		this.iva = iva;
//		if (iva != null) {
//			this.ivaCodi = iva.getEmbedded().getCodi();
//		}
//	}
	
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
	
	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
		if (operari != null) {
			this.operariCodi = operari.getEmbedded().getCodi();
		}
	}
	
//	public static class PressupostEntityListener {
//		@PrePersist
//		public void calcular(PressupostEntity pressupost) {
//			int num = EntityListenerUtil.getSeguentNumComptador(
//					pressupost.getIdentificador().getId(),
//					"TCOM_PRE");
//			pressupost.getEmbedded().setNumero(num);	
//			
//			// Assignació del numero de pressupost al codi si aquest ve null
//			Integer codiPressupost = pressupost.getId().getCodi();
//			if (codiPressupost==null) {
//				pressupost.getId().setCodi(num);
//				pressupost.getEmbedded().setCodi(num);
//			}
//		
//		}
//	}

}
