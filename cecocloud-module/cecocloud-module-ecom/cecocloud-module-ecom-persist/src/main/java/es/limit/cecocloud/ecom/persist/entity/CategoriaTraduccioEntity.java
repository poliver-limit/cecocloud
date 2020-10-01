/**
 * 
 */
package es.limit.cecocloud.ecom.persist.entity;

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

import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio.CategoriaTraduccioPk;
import es.limit.cecocloud.ecom.persist.entity.CategoriaTraduccioEntity.CategoriaTraduccioEntityListener;
import es.limit.cecocloud.ecom.persist.listener.EntityListenerUtil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una CategoriaTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomCategoriaTraduccioEntity")
@Table(
		name = "tcom_did",
		indexes = {
				@Index(name = "ircom_did_pk", columnList = "did_idf_cod, did_seq", unique = true),
				@Index(name = "icom_did_idf_fk", columnList = "did_idf_cod"),
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "did_idf_cod", length = 4)),
	@AttributeOverride(name = "id.sequencia", column = @Column(name = "did_seq", length = 22, precision = 10)),	
	
	@AttributeOverride(name = "embedded.sequencia", column = @Column(name = "did_seq", length = 22, precision = 10, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "did_des", length = 2000, nullable = false)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "did_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "did_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "did_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "did_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "did_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_did_idf_fk"))
})
@EntityListeners({CategoriaTraduccioEntityListener.class})
public class CategoriaTraduccioEntity extends AbstractWithIdentificadorAuditableEntity<CategoriaTraduccio, CategoriaTraduccioPk> {

	@Embedded
	protected CategoriaTraduccio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "did_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "did_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_did_idi_fk"))
	protected IdiomaEntity idioma;
	@Column(name = "did_idi_cod", length = 4)
	private String idiomaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "did_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "did_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_did_far_fk"))
	protected ArticleFamiliaEntity familia;
	@Column(name = "did_far_cod", length = 6)
	private String familiaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "did_idf_cod", referencedColumnName = "gma_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "did_gma_cod", referencedColumnName = "gma_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_did_gma_fk"))
	protected ArticleGammaEntity gamma;
	@Column(name = "did_gma_cod", length = 6)
	private String gammaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "did_idf_cod", referencedColumnName = "mod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "did_mod_cod", referencedColumnName = "mod_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_did_mod_fk"))
	protected ArticleModelEntity model;
	@Column(name = "did_mod_cod", length = 6)
	private String modelCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "did_idf_cod", referencedColumnName = "mca_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "did_mca_cod", referencedColumnName = "mca_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rcom_did_mca_fk"))
	protected ArticleMarcaEntity marca;
	@Column(name = "did_mca_cod", length = 6)
	private String marcaCodi;
	
	@Builder
	public CategoriaTraduccioEntity(
			CategoriaTraduccioPk pk,
			CategoriaTraduccio embedded,
			IdentificadorEntity identificador,
			IdiomaEntity idioma,
			ArticleFamiliaEntity familia,
			ArticleGammaEntity gamma,
			ArticleModelEntity model,
			ArticleMarcaEntity marca) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.idioma = idioma;
		this.familia = familia;
		this.gamma = gamma;
		this.model = model;
		this.marca = marca;
		
		this.updateFamilia (familia);
		this.updateGamma (gamma);
		this.updateModel (model);
		this.updateMarca (marca);
		this.updateIdioma (idioma);
	}

	@Override
	public void update(CategoriaTraduccio embedded) {		
		this.embedded = embedded;
	}
	
	
	public void updateFamilia(ArticleFamiliaEntity familia) {
		this.familia = familia;
		if (familia != null) {
			this.familiaCodi = familia.getEmbedded().getCodi();
		}
	}
	
	public void updateGamma(ArticleGammaEntity gamma) {
		this.gamma = gamma;
		if (gamma != null) {
			this.gammaCodi = gamma.getEmbedded().getCodi();
		}
	}
	
	public void updateModel(ArticleModelEntity model) {
		this.model = model;
		if (model != null) {
			this.modelCodi = model.getEmbedded().getCodi();
		}
	}
	
	public void updateMarca(ArticleMarcaEntity marca) {
		this.marca = marca;
		if (marca != null) {
			this.marcaCodi = marca.getEmbedded().getCodi();
		}
	}
	
	public void updateIdioma(IdiomaEntity idioma) {
		this.idioma = idioma;
		if (idioma != null) {
			this.idiomaCodi = idioma.getEmbedded().getCodi();
		}
	}
	
	// Generem un comptador diferent per a cada traduccio
	public static class CategoriaTraduccioEntityListener {
		@PrePersist
		public void calcular(CategoriaTraduccioEntity traduccio) {
			int seq = EntityListenerUtil.getSeguentNumComptador(
					traduccio.getIdentificador().getId(),
					"TCOM_DID");
			traduccio.getEmbedded().setSequencia(seq);
			traduccio.getId().setSequencia(seq);
		}
	}

}
