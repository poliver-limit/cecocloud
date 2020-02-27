/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

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

import es.limit.cecocloud.fact.logic.api.dto.ArticleModel;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
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
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "mod_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_mod_idf_fk"))
})
public class ArticleModelEntity extends AbstractWithIdentificadorAuditableEntity<ArticleModel, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleModel embedded;

	@Builder
	public ArticleModelEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleModel embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(ArticleModel embedded) {
		this.embedded = embedded;
	}

}
