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

import es.limit.cecocloud.fact.logic.api.dto.BusinessGroup;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity that shows information about business groups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_grp",
		indexes = {
				@Index(name = "iges_grp_idf_fk", columnList = "grp_idf_cod"),
				@Index(name = "irges_grp_pk", columnList = "grp_idf_cod,grp_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "grp_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "grp_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "grp_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "grp_nom", length = 30)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "grp_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "grp_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "grp_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "grp_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "grp_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_grp_idf_fk"))
})
public class BusinessGroupEntity extends AbstractWithIdentificadorAuditableEntity<BusinessGroup, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected BusinessGroup embedded;

	@Builder
	public BusinessGroupEntity(
			WithIdentificadorAndCodiPk<String> pk,
			BusinessGroup embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(BusinessGroup embedded) {
		this.embedded = embedded;
	}

}
