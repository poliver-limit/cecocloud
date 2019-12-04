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
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleModel;
import es.limit.cecocloud.facturacio.logic.api.dto.ArticleModel.ArticleModelPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article model
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_mod",
		indexes = {
				@Index(name = "iges_mod_idf_fk", columnList = "mod_idf_cod"),
				@Index(name = "irges_mod_pk", columnList = "mod_idf_cod,mod_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "mod_idf_cod", length = 4)),	
	@AttributeOverride(name = "id.codi", column = @Column(name = "mod_cod", length = 4)),
	
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "mod_cod", length = 4, insertable = false, updatable = false)),	
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "mod_des", length = 30, nullable = false)),	
	@AttributeOverride(name = "embedded.control", column = @Column(name = "mod_nounitra", length = 1)),
	
	@AttributeOverride(name = "createdBy", column = @Column(name = "mod_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "mod_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "mod_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "mod_datmod"))
})
public class ArticleModelEntity extends AbstractAuditableCompositePkEntity<ArticleModel, ArticleModelPk> {

	@Embedded
	protected ArticleModel embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "mod_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_mod_idf_fk"))
	protected IdentificadorEntity identificador;	

	@Builder
	public ArticleModelEntity(
			ArticleModelPk pk,
			ArticleModel embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleModel embedded) {
		this.embedded = embedded;
	}

}
