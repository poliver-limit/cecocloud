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
import es.limit.cecocloud.facturacio.logic.api.dto.UbicacioArticle;
import es.limit.cecocloud.facturacio.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una ubicacioArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_uba",
		indexes = {
				@Index(name = "iges_uba_idf_fk", columnList = "uba_idf_cod"),
				@Index(name = "irges_uba_pk", columnList = "uba_idf_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "uba_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.articleCodi", column = @Column(name = "uba_art_cod", length = 6)),
	@AttributeOverride(name = "id.magatzemCodi", column = @Column(name = "uba_mag_cod", length = 6)),
	
	@AttributeOverride(name = "embedded.unitat", column = @Column(name = "uba_uni", length = 22)),	
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "uba_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "uba_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "uba_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "uba_datmod"))
})
public class UbicacioArticleEntity extends AbstractAuditableCompositePkEntity<UbicacioArticle, UbicacioArticlePk> {

	@Embedded
	protected UbicacioArticle embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "uba_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_uba_idf_fk"))
	protected IdentificadorEntity identificador;	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "uba_idf_cod", referencedColumnName = "art_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uba_art_cod", referencedColumnName = "art_cod", insertable = false, updatable = false),
			},
			foreignKey = @ForeignKey(name = "rges_uba_art_fk"))
	protected ArticleEntity article;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {	
					@JoinColumn(name = "uba_idf_cod", referencedColumnName = "ubi_idf_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uba_ubi_cod", referencedColumnName = "ubi_cod", insertable = false, updatable = false),
					@JoinColumn(name = "uba_mag_cod", referencedColumnName = "ubi_mag_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_uba_ubi_fk"))
	protected UbicacioEntity ubicacio;

	@Builder
	public UbicacioArticleEntity(
			UbicacioArticlePk pk,
			UbicacioArticle embedded,
			IdentificadorEntity identificador,			
			ArticleEntity article,
			UbicacioEntity ubicacio) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
		this.article = article;
		this.ubicacio = ubicacio;
	}

	@Override
	public void update(UbicacioArticle embedded) {
		this.embedded = embedded;
	}

}
