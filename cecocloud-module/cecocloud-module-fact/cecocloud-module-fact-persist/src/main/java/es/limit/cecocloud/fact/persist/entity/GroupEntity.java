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

import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.logic.api.dto.Group;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity in database that represents groups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_gru",
		indexes = {
				@Index(name = "iges_gru_idf_fk", columnList = "gru_idf_cod"),
				@Index(name = "irges_gru_pk", columnList = "gru_idf_cod,gru_cod", unique = true)
		}
		
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "gru_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "gru_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "gru_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "gru_nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.observations", column = @Column(name = "gru_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "gru_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "gru_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "gru_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "gru_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "gru_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_gru_idf_fk"))
})
public class GroupEntity extends AbstractWithIdentificadorAuditableEntity<Group, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Group embedded;

	@Builder
	public GroupEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Group embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Group embedded) {
		this.embedded = embedded;
	}
	
}
