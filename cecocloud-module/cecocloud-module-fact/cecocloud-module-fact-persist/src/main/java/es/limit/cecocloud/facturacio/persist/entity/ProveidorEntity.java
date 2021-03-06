/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor;
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
@Entity
@Table(
		name = "tges_pro",
		indexes = {
				@Index(name = "iges_pro_idf_fk", columnList = "pro_idf_cod"),
				@Index(name = "irges_pro_pk", columnList = "pro_idf_cod,pro_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "pro_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "pro_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pro_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nomComercial", column = @Column(name = "pro_nomcom", length = 30)),
	@AttributeOverride(name = "embedded.nomFiscal", column = @Column(name = "pro_nomfis", length = 1000)),
	@AttributeOverride(name = "embedded.bloquetjat", column = @Column(name = "pro_blo", length = 1)),
	@AttributeOverride(name = "embedded.subcontratista", column = @Column(name = "pro_scn", length = 1)),
	@AttributeOverride(name = "embedded.dhm", column = @Column(name = "pro_dhm", length = 1)),
//	@AttributeOverride(name = "embedded.regimIvaCodi", column = @Column(name = "pro_rgi_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.codiPostalCodi", column = @Column(name = "pro_cpo_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.tipusVencimentCodi", column = @Column(name = "pro_tve_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.divisaCodi", column = @Column(name = "pro_div_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.documentPagamentCobramentCodi", column = @Column(name = "pro_dpg_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.familiaProveidorCodi", column = @Column(name = "pro_fpr_cod", length = 4, nullable = false)),
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
			foreignKey = @ForeignKey(name = "rges_pro_idf_fk"))
})
public class ProveidorEntity extends AbstractWithIdentificadorEntity<Proveidor, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Proveidor embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "rgi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_rgi_cod", referencedColumnName = "rgi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_rgi_fk"))
	private RegimIvaEntity regimIva;
	@Column(name = "pro_rgi_cod", length = 4, nullable = false)
	private String regimIvaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "cpo_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_cpo_cod", referencedColumnName = "cpo_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_cpo_fk"))
	private CodiPostalEntity codiPostal;
	@Column(name = "pro_cpo_cod", length = 4, nullable = false)
	private String codiPostalCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "tve_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_tve_cod", referencedColumnName = "tve_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_tve_fk"))
	private TipusVencimentEntity tipusVenciment;
	@Column(name = "pro_tve_cod", length = 4, nullable = false)
	private String tipusVencimentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "div_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_div_cod", referencedColumnName = "div_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_div_fk"))
	private DivisaEntity divisa;
	@Column(name = "pro_div_cod", length = 4, nullable = false)
	private String divisaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "dpg_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_dpg_cod", referencedColumnName = "dpg_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_dpg_fk"))
	private DocumentPagamentCobramentEntity documentPagamentCobrament;	
	@Column(name = "pro_dpg_cod", length = 4, nullable = false)
	private String documentPagamentCobramentCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "pro_idf_cod", referencedColumnName = "fpr_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "pro_fpr_cod", referencedColumnName = "fpr_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_pro_fpr_fk"))
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
		this.regimIva = regimIva;
		this.codiPostal = codiPostal;
		this.tipusVenciment = tipusVenciment;
		this.divisa = divisa;
		this.documentPagamentCobrament = documentPagamentCobrament;
		this.familiaProveidor = familiaProveidor;
		
		this.regimIvaCodi = regimIva.getEmbedded().getCodi();
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
		this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
		this.divisaCodi = divisa.getEmbedded().getCodi();
		this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
		this.familiaProveidorCodi = familiaProveidor.getEmbedded().getCodi();
	}

	@Override
	public void update(Proveidor embedded) {
		this.embedded = embedded;
	}
	
	public void updateRegimIva(RegimIvaEntity regimIva) {
		this.regimIvaCodi = regimIva.getEmbedded().getCodi();
	}
	
	public void updateCodiPostal(CodiPostalEntity codiPostal) {
		this.codiPostalCodi = codiPostal.getEmbedded().getCodi();
	}
	
	public void updateTipusVenciment(TipusVencimentEntity tipusVenciment) {
		this.tipusVencimentCodi = tipusVenciment.getEmbedded().getCodi();
	}
	
	public void updateDivisa(DivisaEntity divisa) {
		this.divisaCodi = divisa.getEmbedded().getCodi();
	}
	
	public void updateDocumentPagamentCobrament(DocumentPagamentCobramentEntity documentPagamentCobrament) {
		this.documentPagamentCobramentCodi = documentPagamentCobrament.getEmbedded().getCodi();
	}
	
	public void updateFamiliaProveidor(FamiliaProveidorEntity familiaProveidor) {
		this.familiaProveidorCodi = familiaProveidor.getEmbedded().getCodi();
	}

}
