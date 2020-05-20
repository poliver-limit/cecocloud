/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

import java.util.Formatter;
import java.util.regex.Pattern;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import es.limit.cecocloud.ecom.persist.repository.ClientRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ClientEntity.ClientEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
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
@Entity(name = "ecomClientEntity")
@Table(name = "tcom_cli", indexes = { @Index(name = "icom_cli_idf_fk", columnList = "cli_idf_cod"),
		@Index(name = "ircom_cli_pk", columnList = "cli_idf_cod,cli_cod", unique = true) })
@AttributeOverrides({
		@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "cli_idf_cod", length = 4)), // hauria de ser 6
		@AttributeOverride(name = "id.codi", column = @Column(name = "cli_cod", length = 6)),
		@AttributeOverride(name = "embedded.codi", column = @Column(name = "cli_cod", length = 6, insertable = false, updatable = false)),
		@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "cli_nomfis", length = 40, nullable = false)),
		@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "cli_nomcom", length = 40, nullable = false)),
		@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "cli_tipnif", length = 1)),	
		@AttributeOverride(name = "embedded.nif", column = @Column(name = "cli_nif", length = 12)),
		@AttributeOverride(name = "embedded.nomDomicili", column = @Column(name = "cli_nomdom", length = 30)),
		@AttributeOverride(name = "embedded.numeroDomicili", column = @Column(name = "cli_numdom", length = 5)),
		@AttributeOverride(name = "embedded.escalaDomicili", column = @Column(name = "cli_escdom", length = 2)),
		@AttributeOverride(name = "embedded.pisDomicili", column = @Column(name = "cli_pisdom", length = 2)),
		@AttributeOverride(name = "embedded.portaDomicili", column = @Column(name = "cli_pordom", length = 2)),
		@AttributeOverride(name = "embedded.domiciliFiscal", column = @Column(name = "cli_domfis", length = 60)),
		@AttributeOverride(name = "embedded.telefon", column = @Column(name = "cli_tel", length = 60)),
		@AttributeOverride(name = "embedded.email", column = @Column(name = "cli_eml", length = 60)),
		@AttributeOverride(name = "embedded.emailFactura", column = @Column(name = "cli_emlfac", length = 100)),		
	
		@AttributeOverride(name = "createdBy", column = @Column(name = "cli_usucre")),
		@AttributeOverride(name = "createdDate", column = @Column(name = "cli_datcre")),
		@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "cli_usumod")),
		@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "cli_datmod")) 
})
		@AssociationOverrides({ 
				@AssociationOverride(
						name = "identificador", joinColumns = {
								@JoinColumn(name = "cli_idf_cod", insertable = false, updatable = false) }, 
						foreignKey = @ForeignKey(name = "rcom_cli_idf_fk")) 
})
@EntityListeners({ClientEntityListener.class})
public class ClientEntity extends AbstractWithIdentificadorAuditableEntity<Client, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Client embedded;

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
						@JoinColumn(name = "cli_sgl", referencedColumnName = "tad_cod", insertable = false, updatable = false)
			},		
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@NotFound(action = NotFoundAction.IGNORE)
	private TipusAdresaEntity tipusAdresa;
	@Column(name = "cli_sgl", length = 4)
	private String tipusAdresaCodi;
	
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
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "fmc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_fmc_cod", referencedColumnName = "fmc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_fmc_cod_fk"))
	private FamiliaClientEntity familiaClient;
	@Column(name = "cli_fmc_cod", length = 4, nullable = false)
	private String familiaClientCodi;
	
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
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_iva_cod_fk"))
	private IvaEntity iva;
	@Column(name = "cli_iva_cod", length = 4)
	private String ivaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_rgi_cod_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "cli_rgi_cod", length = 2, nullable = false)
	private String regimIvaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tfc_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tfc_cod", referencedColumnName = "tfc_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "cli_tfc_cod_fk"))
	private TipusFacturacioEntity tipusFacturacio;
	@Column(name = "cli_tfc_cod", length = 4, nullable = false)
	private String tipusFacturacioCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
//			foreignKey = @ForeignKey(name = "cli_tve_cod_fk"))
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	@NotFound(action = NotFoundAction.IGNORE)
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "cli_tve_cod", length = 4, nullable = false)
	private String tipusVencimentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
						@JoinColumn(name = "cli_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "cli_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false) 
			},
			foreignKey = @ForeignKey(name = "cli_dpg_cod_fk"))
	private DocumentPagamentCobramentEntity documentPagament;
	@Column(name = "cli_dpg_cod", length = 4, nullable = false)
	private String documentPagamentCodi;	
	
	@Builder
	public ClientEntity(
			WithIdentificadorAndCodiPk<String> pk, 
			Client embedded, 
			IdentificadorEntity identificador,
			PaisNifEntity paisNif, 
			TipusAdresaEntity tipusAdresa,
			CodiPostalEntity codiPostal,
			FamiliaClientEntity familiaClient, 
			IdiomaEntity idioma,
			IvaEntity iva,
			RegimIvaEntity regimIva,	
			TipusFacturacioEntity tipusFacturacio,			
			TipusVencimentEntity tipusVenciment,	
			DocumentPagamentCobramentEntity documentPagament			
		) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;		
		
		updatePaisNif(paisNif);
		updateTipusAdresa(tipusAdresa);
		updateCodiPostal(codiPostal);
		updateFamiliaClient(familiaClient);
		updateIdioma(idioma);
		updateIva(iva);
		updateRegimIva(regimIva);
		updateTipusFacturacio(tipusFacturacio);		
		updateTipusVenciment(tipusVenciment);				
		updateDocumentPagament(documentPagament);		
		
	}

	@Override
	public void update(Client embedded) {
		this.embedded = embedded;
	}

	public void updatePaisNif(PaisNifEntity paisNif) {
		this.paisNif = paisNif;
		if (paisNif != null) {
			this.paisNifCodi = paisNif.getId();
		}
	}

	public void updateTipusAdresa(TipusAdresaEntity tipusAdresa) {
		this.tipusAdresa = tipusAdresa;
		if (tipusAdresa != null) {
			this.tipusAdresaCodi = tipusAdresa.getEmbedded().getCodi();
		}
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		if (codiPostal != null) {
			this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		}
	}
	
	public void updateFamiliaClient(FamiliaClientEntity familiaClient) {
		this.familiaClient = familiaClient;
		if (familiaClient != null) {
			this.familiaClientCodi = familiaClient.getEmbedded().getCodi();
		}
	}
	
	public void updateIdioma(IdiomaEntity idioma) {
		this.idioma = idioma;
		if (idioma != null) {
			this.idiomaCodi = idioma.getEmbedded().getCodi();
		}
	}	

	public void updateIva(IvaEntity iva) {
		this.iva = iva;
		if (iva != null) {
			this.ivaCodi = iva.getEmbedded().getCodi();
		}
	}
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		if (regimIva != null) {
			this.regimIvaCodi = regimIva.getEmbedded().getCodi();
		}
	}
	
	public void updateTipusFacturacio(TipusFacturacioEntity tipusFacturacio) {
		this.tipusFacturacio = tipusFacturacio;
		if (tipusFacturacio != null) {
			this.tipusFacturacioCodi = tipusFacturacio.getEmbedded().getCodi();
		}
	}	
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		if (tipusVenciment != null) {
			this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
		}
	}

	public void updateDocumentPagament(DocumentPagamentCobramentEntity documentPagament) {
		this.documentPagament = documentPagament;
		if (documentPagament != null) {
			this.documentPagamentCodi = documentPagament.getEmbedded().getCodi();
		}
	}
	
	public static class ClientEntityListener {
		@PrePersist
		public void calcular(ClientEntity client) {
			String codi = client.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						client.getId().getIdentificadorCodi(),
						"TCOM_CLI",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(client.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ClientRepository.class));
				String seqST = addZeros(seq, 6);
				client.getEmbedded().setCodi(seqST);
				client.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					client.getEmbedded().setCodi(codi);
					client.getId().setCodi(codi);
				}
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
	
	public static String addZeros(int codi, int tamanyCodi) {
		Formatter fmt = new Formatter();
		String codiSt = fmt.format("%06d",codi).toString();	
		return codiSt;
	}
	
}
