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

import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio.ArticleTraduccioPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article traduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleTraduccioEntity")
@Table(
		name = "tcom_dar",
		indexes = {
				@Index(name = "icom_dar_idf_fk", columnList = "dar_idf_cod"),
				@Index(name = "ircom_dar_pk", columnList = "dar_idf_cod, dar_art_cod, dar_idi_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dar_idf_cod", length = 4)),
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "dar_art_cod", length = 15)),
	@AttributeOverride(name = "id.idiomaCodi", column = @Column(name = "dar_idi_cod", length = 4)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "dar_des", length = 2000, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "dar_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dar_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dar_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dar_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "dar_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_dar_idf_fk"))
})
public class ArticleTraduccioEntity extends AbstractWithIdentificadorAuditableEntity<ArticleTraduccio, ArticleTraduccioPk> {

	@Embedded
	protected ArticleTraduccio embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "dar_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "dar_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_dar_art_fk"))			
	protected ArticleEntity article;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
				value = {
						@JoinColumn(name = "dar_idf_cod", referencedColumnName = "idi_idf_cod", insertable = false, updatable = false),
						@JoinColumn(name = "dar_idi_cod", referencedColumnName = "idi_cod", insertable = false, updatable = false)
				},
				foreignKey = @ForeignKey(name = "rcom_dar_idi_fk"))
	protected IdiomaEntity idioma;
	
	@Builder
	public ArticleTraduccioEntity(
			ArticleTraduccioPk pk,			
			IdentificadorEntity identificador,
			ArticleTraduccio embedded,
			ArticleEntity article,
			IdiomaEntity idioma) {
		
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		this.article = article;
		this.idioma = idioma;		

	}

	@Override
	public void update(ArticleTraduccio embedded) {
		this.embedded = embedded;
	}


}
