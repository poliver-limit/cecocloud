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

import es.limit.cecocloud.facturacio.logic.api.dto.Article;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_art",
		indexes = {
				@Index(name = "iges_art_idf_fk", columnList = "art_idf_cod"),
				@Index(name = "irges_art_pk", columnList = "art_idf_cod,art_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "art_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "art_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "art_cod", length = 15, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "art_des", length = 2000, nullable = false)),
	@AttributeOverride(name = "embedded.pvp", column = @Column(name = "art_pvp", nullable = false, precision = 17, scale = 5)),
	@AttributeOverride(name = "embedded.factorConversioEntrada", column = @Column(name = "art_fce", nullable = false, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.factorConversioSortida", column = @Column(name = "art_fcs", nullable = false, precision = 15, scale = 3)),
	@AttributeOverride(name = "embedded.decimalsPreu", column = @Column(name = "art_decpru", nullable = false, precision = 1, scale = 0)),
	@AttributeOverride(name = "embedded.bloquejat", column = @Column(name = "art_blo", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.compost", column = @Column(name = "art_cst", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.controlStock", column = @Column(name = "art_sto", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.crearReferencies", column = @Column(name = "art_creref", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.descripcioCurta", column = @Column(name = "art_descur", length = 60)),
	@AttributeOverride(name = "embedded.alies", column = @Column(name = "art_ali", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "art_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "art_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "art_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "art_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "art_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_idf_fk"))
})
public class ArticleEntity extends AbstractWithIdentificadorEntity<Article, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Article embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_far_fk"))	
	private ArticleFamiliaEntity familia;
	@Column(name = "art_far_cod", length = 6, nullable = false)
	private String familiaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_iva_fk"))
	private IvaEntity iva;
	@Column(name = "art_iva_cod", length = 4, nullable = false)
	private String ivaCodi;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mod_cod", referencedColumnName = "mod_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_mod_fk"))			
	private ArticleModelEntity model;	
	@Column(name = "art_mod_cod", length = 6, nullable = false)
	private String modelCodi;
	
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "gma_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_gma_cod", referencedColumnName = "gma_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_gma_fk"))		
	private ArticleGammaEntity gamma;	
	@Column(name = "art_gma_cod", length = 6)
	private String gammaCodi;
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mca_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mca_cod", referencedColumnName = "mca_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_mca_fk"))		
	private ArticleMarcaEntity marca;
	@Column(name = "art_mca_cod", length = 6)
	private String marcaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_emp_fk"))			
	private EmpresaEntity empresa;
	@Column(name = "art_emp_cod", length = 4)
	private String empresaCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_art_fk"))
	private ArticleEntity alternatiu;	
	@Column(name = "art_art_cod", length = 15)
	private String alternatiuCodi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_art_cod02", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_art_cod02_fk"))
	private ArticleEntity alternatiu2;	
	@Column(name = "art_art_cod02", length = 15)
	private String alternatiu2Codi;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_codrae", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_articleRaee_fk"))
	private ArticleEntity articleRaee;	
	@Column(name = "art_codrae", length = 15)
	private String articleRaeeCodi;
	
	@Builder
	public ArticleEntity(			
			WithIdentificadorAndCodiPk<String> pk,
			Article embedded,
			IdentificadorEntity identificador,
			ArticleEntity alternatiu,
			ArticleEntity alternatiu2,	
			ArticleEntity articleRaee,
			ArticleFamiliaEntity familia,
			ArticleGammaEntity gamma,
			ArticleMarcaEntity marca,
			ArticleModelEntity model,			
			EmpresaEntity empresa,			
			IvaEntity iva) {
		
		setId(pk);		
		
		this.embedded = embedded;
		this.identificador = identificador;		
		this.familia = familia;		
		this.iva = iva;		
		this.model = model;		
		this.gamma = gamma;	
		this.marca = marca;		
		this.empresa = empresa;		
		this.alternatiu = alternatiu;		
		this.alternatiu2 = alternatiu2;		
		this.articleRaee = articleRaee;
		
//		this.setEmbeddedCodis();
		this.familiaCodi = familia.getEmbedded().getCodi();
		this.ivaCodi = iva.getEmbedded().getCodi();
		this.modelCodi = model.getEmbedded().getCodi();
		
		if (gamma!=null) {
			this.gammaCodi = gamma.getEmbedded().getCodi();
		}
		if (marca!=null) {
			this.marcaCodi = marca.getEmbedded().getCodi();
		}
		if (empresa!=null) {
			this.empresaCodi = empresa.getEmbedded().getCodi();
		}
		if (alternatiu!=null) {
			this.alternatiuCodi = alternatiu.getEmbedded().getCodi();
		}
		if (alternatiu2!=null) {
			this.alternatiu2Codi = alternatiu2.getEmbedded().getCodi();
		}
		if (articleRaee!=null) {
			this.articleRaeeCodi = articleRaee.getEmbedded().getCodi();
		}
	}

	@Override
	public void update(Article embedded) {
		this.embedded = embedded;		
//		this.setEmbeddedCodis();
	}
	
	public void updateFamilia(ArticleFamiliaEntity familia) {
		this.familiaCodi = familia.getEmbedded().getCodi();
	}
	
	public void updateIva(IvaEntity iva) {
		this.ivaCodi = iva.getEmbedded().getCodi();
	}
	
	public void updateModel(ArticleModelEntity model) {
		this.modelCodi = model.getEmbedded().getCodi();
	}
	
	public void updateGamma(ArticleGammaEntity gamma) {
		if (gamma!=null) {
			this.gammaCodi = gamma.getEmbedded().getCodi();
		}
	}
	
	public void updateMarca(ArticleMarcaEntity marca) {
		if (marca!=null) {
			this.marcaCodi = marca.getEmbedded().getCodi();
		}
	}
	
	public void updateEmpresa(EmpresaEntity empresa) {
		if (empresa!=null) {
			this.empresaCodi = empresa.getEmbedded().getCodi();
		}
	}
	
	public void updateAlternatiu(ArticleEntity alternatiu) {
		if (alternatiu!=null) {
			this.alternatiuCodi = alternatiu.getEmbedded().getCodi();
		}
	}
	
	public void updateAlternatiu2(ArticleEntity alternatiu2) {
		if (alternatiu2!=null) {
			this.alternatiu2Codi = alternatiu2.getEmbedded().getCodi();
		}
	}
	
	public void updateArticleRaee(ArticleEntity articleRaee) {
		if (articleRaee!=null) {
			this.articleRaeeCodi = articleRaee.getEmbedded().getCodi();
		}
	}
	
//	private void setEmbeddedCodis () {		
//		
//		// Referencies sobre camps obligatoris
//		this.familiaCodi = embedded.getFamilia().getPk().getCodi();
//		this.ivaCodi = embedded.getIva().getPk().getCodi();
//		this.modelCodi = embedded.getModel().getPk().getCodi();
//		
//		// Referencies sobre camps no obligastoris		
//		if (embedded.getGamma() != null) {
//			this.gammaCodi = embedded.getGamma().getPk().getCodi();
//		}		
//		if (embedded.getMarca() != null) {
//			this.marcaCodi = embedded.getMarca().getPk().getCodi();
//		}		
//		if (embedded.getEmpresa() != null) {
//			this.empresaCodi = embedded.getEmpresa().getPk().getCodi();
//		}		
//		if (embedded.getAlternatiu() != null) {
//			this.alternatiuCodi = embedded.getAlternatiu().getPk().getCodi();
//		}		
//		if (embedded.getAlternatiu2() != null) {
//			this.alternatiu2Codi = embedded.getAlternatiu2().getPk().getCodi();
//		}		
//		if (embedded.getArticleRaee() != null) {
//			this.articleRaeeCodi = embedded.getArticleRaee().getPk().getCodi();
//		}
//		
//	}

}
