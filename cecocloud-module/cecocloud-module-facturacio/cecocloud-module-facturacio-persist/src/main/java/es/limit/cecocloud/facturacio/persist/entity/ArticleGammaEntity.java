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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleGamma;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleGamma.ArticleGammaPk;
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
@Entity
@Table(
		name = "tges_gma",
		indexes = {
				@Index(name = "iges_gma_idf_fk", columnList = "gma_idf_cod"),
				@Index(name = "irges_gma_pk", columnList = "gma_idf_cod,gma_cod", unique = true)
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
public class ArticleGammaEntity extends AbstractAuditableCompositePkEntity<ArticleGamma, ArticleGammaPk> {

	@Embedded
	protected ArticleGamma embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "gma_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_gma_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public ArticleGammaEntity(
			ArticleGammaPk pk,
			ArticleGamma embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleGamma embedded) {
		this.embedded = embedded;
	}

}
