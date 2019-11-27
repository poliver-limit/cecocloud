/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.Article;
import es.limit.cecocloud.facturacio.logic.api.dto.Article.ArticlePk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
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
	@AttributeOverride(name = "embedded.familiaCodi", column = @Column(name = "art_far_cod", length = 6, nullable = false)),	
	@AttributeOverride(name = "embedded.ivaCodi", column = @Column(name = "art_iva_cod", length = 6, nullable = false)),	
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
	@AttributeOverride(name = "embedded.modelCodi", column = @Column(name = "art_mod_cod", length = 6, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "art_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "art_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "art_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "art_datmod"))
})
public class ArticleEntity extends AbstractAuditableCompositePkEntity<Article, ArticlePk> {

	@Embedded
	protected Article embedded;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "art_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_art_idf_fk"))
	protected IdentificadorEntity identificador;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "far_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_far_cod", referencedColumnName = "far_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_far_fk"))	
	protected ArticleFamiliaEntity familia;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "iva_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_iva_cod", referencedColumnName = "iva_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_iva_fk"))	
	protected IvaEntity iva;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mod_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mod_cod", referencedColumnName = "mod_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_mod_fk"))			
	protected ArticleModelEntity model;	
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "gma_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_gma_cod", referencedColumnName = "gma_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_gma_fk"))		
	protected ArticleGammaEntity gamma;	
	
	@ManyToOne(optional = true,	fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "mca_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_mca_cod", referencedColumnName = "mca_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_mca_fk"))		
	protected ArticleMarcaEntity marca;
		
//	@ManyToOne(optional = true, fetch = FetchType.LAZY)
//	@JoinColumns(
//			value = {
//					@JoinColumn(name = "art_idf_cod", referencedColumnName = "emp_idf_cod", insertable = false, updatable = false),
//					@JoinColumn(name = "art_emp_cod", referencedColumnName = "emp_cod", insertable = false, updatable = false)
//			},
//			foreignKey = @ForeignKey(name = "rges_art_emp_fk"))			
//	protected EmpresaEntity empresa;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_art_fk"))
	protected ArticleEntity alternatiu;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_art_cod02", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_art_cod02_fk"))
	protected ArticleEntity alternatiu2;	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "art_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "art_codrae", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_art_articleRaee_fk"))
	protected ArticleEntity articleRaee;	
	
	@Builder
	public ArticleEntity(
			ArticlePk pk,
			Article embedded,
			IdentificadorEntity identificador,
			ArticleFamiliaEntity familia,
			IvaEntity iva,
			ArticleModelEntity model,
			ArticleGammaEntity gamma,
			ArticleMarcaEntity marca,
//			EmpresaEntity empresa,
			ArticleEntity alternatiu,
			ArticleEntity alternatiu2,	
			ArticleEntity articleRaee			
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.familia = familia;	
		this.iva = iva;	
		this.model = model;	
		this.gamma = gamma;	
		this.marca = marca;	
//		this.empresa = empresa;	
		this.alternatiu = alternatiu;
		this.alternatiu2 = alternatiu2;	
		this.articleRaee = articleRaee;	
	}

	@Override
	public void update(Article embedded) {
		this.embedded = embedded;
	}

}
