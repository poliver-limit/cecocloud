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
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleMagatzem;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleMagatzem.ArticleMagatzemPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una article magatzem
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleMagatzemEntity")
@Table(
		name = "tcom_arm",
		indexes = {
				@Index(name = "icom_arm_idf_fk", columnList = "arm_idf_cod"),
				@Index(name = "ircom_arm_pk", columnList = "arm_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "arm_idf_cod", length = 4)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "arm_art_cod", length = 4)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "arm_mag_cod", length = 4)),
	@AttributeOverride(name = "embedded.stock", column = @Column(name = "arm_stk")),
	@AttributeOverride(name = "createdBy", column = @Column(name = "arm_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "arm_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "arm_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "arm_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "arm_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_arm_idf_fk"))
})
public class ArticleMagatzemEntity extends AbstractWithIdentificadorAuditableEntity<ArticleMagatzem, ArticleMagatzemPk> {

	@Embedded
	protected ArticleMagatzem embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "arm_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "arm_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_arm_art_fk"))			
	protected ArticleEntity article;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "arm_idf_cod", referencedColumnName = "mag_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "arm_mag_cod", referencedColumnName = "mag_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_arm_mag_fk"))
	protected MagatzemEntity magatzem;
	
	@Builder
	public ArticleMagatzemEntity(
			ArticleMagatzemPk pk,			
			IdentificadorEntity identificador,
			ArticleMagatzem embedded,
			ArticleEntity article,
			MagatzemEntity magatzem) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.article = article;
		this.magatzem = magatzem;		

	}

	@Override
	public void update(ArticleMagatzem embedded) {
		this.embedded = embedded;
	}


}
