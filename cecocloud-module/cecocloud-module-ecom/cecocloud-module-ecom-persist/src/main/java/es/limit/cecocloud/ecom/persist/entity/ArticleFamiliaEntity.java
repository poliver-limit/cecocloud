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

import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un article familia
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "ecomArticleFamiliaEntity")
@Table(
		name = "tcom_far",
		indexes = {
				@Index(name = "icom_far_idf_fk", columnList = "far_idf_cod"),
				@Index(name = "ircom_far_pk", columnList = "far_idf_cod,far_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "far_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "far_cod", length = 6)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "far_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "far_des", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.artExportables", column = @Column(name = "far_pda", length = 1)),

	@AttributeOverride(name = "createdBy", column = @Column(name = "far_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "far_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "far_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "far_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "far_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rcom_far_idf_fk"))
})
public class ArticleFamiliaEntity extends AbstractWithIdentificadorAuditableEntity<ArticleFamilia, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected ArticleFamilia embedded;

	@Builder
	public ArticleFamiliaEntity(
			WithIdentificadorAndCodiPk<String> pk,
			ArticleFamilia embedded,
			IdentificadorEntity identificador
			) {
		setId(pk);
		
		this.embedded = embedded;
		this.identificador = identificador;
		
	}

	@Override
	public void update(ArticleFamilia embedded) {
		this.embedded = embedded;
	}

}
