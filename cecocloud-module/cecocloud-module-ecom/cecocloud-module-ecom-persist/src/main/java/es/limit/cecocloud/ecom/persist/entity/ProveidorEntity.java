/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.Proveidor;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ProveidorEntity.ProveidorEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil.PkBuilder;
import es.limit.cecocloud.ecom.persist.repository.ProveidorRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un proveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomProveidorEntity")
@Table(
		name = "tcom_pro",
		indexes = {
				@Index(name = "icom_pro_idf_fk", columnList = "pro_idf_cod"),
				@Index(name = "ircom_pro_pk", columnList = "pro_idf_cod,pro_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pro_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pro_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pro_cod", length = 6, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "pro_nomcom", length = 40, nullable = false)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "pro_nomfis", length = 40, nullable = false)),	
	@AttributeOverride(name = "embedded.bloquetjat", column = @Column(name = "pro_blo", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.subcontratista", column = @Column(name = "pro_scn", length = 1, nullable = false)),	
	@AttributeOverride(name = "embedded.dhm", column = @Column(name = "pro_dhm", length = 1, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "pro_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "pro_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "pro_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "pro_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "pro_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_idf_fk"))
})
@EntityListeners({ProveidorEntityListener.class})
public class ProveidorEntity extends AbstractWithIdentificadorAuditableEntity<Proveidor, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Proveidor embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_rgi_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "pro_rgi_cod", length = 2, nullable = false)
	private String regimIvaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "pro_cpo_cod", length = 8, nullable = false)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_tve_fk"))
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "pro_tve_cod", length = 4, nullable = false)
	private String tipusVencimentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "pro_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;	
	@Column(name = "pro_dpg_cod", length = 4, nullable = false)
	private String documentPagamentCobramentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "fpr_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_fpr_cod", referencedColumnName = "fpr_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_pro_fpr_fk"))
	private FamiliaProveidorEntity familiaProveidor;
	@Column(name = "pro_fpr_cod", length = 4, nullable = false)
	private String familiaProveidorCodi;

	@Builder
	public ProveidorEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Proveidor embedded,
			IdentificadorEntity identificador,
			RegimIvaEntity regimIva,
			CodiPostalEntity codiPostal,			
			DivisaEntity divisa,
			DocumentPagamentCobramentEntity documentPagamentCobrament,
			FamiliaProveidorEntity familiaProveidor,
			TipusVencimentEntity tipusVenciment) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
		this.updateRegimIva(regimIva);		
		this.updateCodiPostal(codiPostal);		
		this.updateTipusVenciment(tipusVenciment);		
		this.updateDivisa(divisa);		
		this.updateDocumentPagamentCobrament(documentPagamentCobrament);	
		this.updateFamiliaProveidor(familiaProveidor);		
	}

	@Override
	public void update(Proveidor embedded) {
		this.embedded = embedded;
	}
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIva = regimIva;
		this.regimIvaCodi = regimIva.getEmbedded().getCodi();
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostal = codiPostal;
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
	}
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVenciment = tipusVenciment;
		this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisa = divisa;
		this.divisaCodi = divisa.getEmbedded().getCodi();
	}
	
	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobrament = documentPagamentCobrament;
		this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
	}
	
	public void updateFamiliaProveidor(FamiliaProveidorEntity familiaProveidor) {
		this.familiaProveidor = familiaProveidor;
		this.familiaProveidorCodi = familiaProveidor.getEmbedded().getCodi();
	}
	
	public static class ProveidorEntityListener {
		@PrePersist
		public void calcular(ProveidorEntity proveidor) {
			String codi = proveidor.getEmbedded().getCodi();
			if (codi == null || codi.isEmpty()) {
				int seq = EntityListenerUtil.getSeguentNumComptadorComprovantPk(
						proveidor.getId().getIdentificadorCodi(),
						"TCOM_PRO",
						new PkBuilder<WithIdentificadorAndCodiPk<String>>() {
							@Override
							public WithIdentificadorAndCodiPk<String> build(int seq) {
								return new WithIdentificadorAndCodiPk<String>(proveidor.getId().getIdentificadorCodi(), Integer.toString(seq));
							}
						},
						EntityListenerUtil.getBean(ProveidorRepository.class));
				String seqST = addZeros(seq, 6);
				proveidor.getEmbedded().setCodi(seqST);
				proveidor.getId().setCodi(seqST);
			} else {
				if (isNumeric(codi)) {					
					codi = addZeros(Integer.parseInt(codi), 6);
					proveidor.getEmbedded().setCodi(codi);
					proveidor.getId().setCodi(codi);
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
		String codiSt = String.format("%06d",codi).toString();
		return codiSt;
	}

}
