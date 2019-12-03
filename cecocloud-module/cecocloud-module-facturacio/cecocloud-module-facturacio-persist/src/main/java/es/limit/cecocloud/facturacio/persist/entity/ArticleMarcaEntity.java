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
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleMarca;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleMarca.ArticleMarcaPk;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_mca",
		indexes = {
				@Index(name = "iges_mca_idf_fk", columnList = "mca_idf_cod"),
				@Index(name = "irges_mca_pk", columnList = "mca_idf_cod,mca_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mca_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "mca_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mca_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mca_des", length = 30, nullable = false)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mca_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mca_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mca_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mca_datmod"))
})
public class ArticleMarcaEntity extends AbstractAuditableCompositePkEntity<ArticleMarca, ArticleMarcaPk> {

	@Embedded
	protected ArticleMarca embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "mca_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_mca_idf_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public ArticleMarcaEntity(
			ArticleMarcaPk pk,
			ArticleMarca embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleMarca embedded) {
		this.embedded = embedded;
	}

}