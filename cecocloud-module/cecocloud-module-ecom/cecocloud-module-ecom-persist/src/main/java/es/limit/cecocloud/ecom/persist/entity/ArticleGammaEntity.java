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
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article gamma
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleGammaEntity")
@Table(
		name = "tcom_gma",
		indexes = {
				@Index(name = "icom_gma_idf_fk", columnList = "gma_idf_cod"),
				@Index(name = "ircom_gma_pk", columnList = "gma_idf_cod,gma_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gma_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gma_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gma_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "gma_des", length = 30, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "gma_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gma_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gma_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gma_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gma_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_gma_idf_fk"))
})
public class ArticleGammaEntity extends AbstractWithIdentificadorAuditableEntity<ArticleGamma, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleGamma embedded;

	@Builder
	public ArticleGammaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleGamma embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleGamma embedded) {
		this.embedded = embedded;
	}

}
