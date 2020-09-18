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
import es.limit.cecocloud.fact.logic.api.dto.Parameter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity in database that represents parameters.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_par",
		indexes = {
				@Index(name = "iges_par_idf_fk", columnList = "par_idf_cod"),
				@Index(name = "irges_par_pk", columnList = "par_idf_cod,par_cod", unique = true)
		}
		
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "par_idf_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "par_cod", length = 15)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "par_cod", length = 15, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.value", column = @Column(name = "par_val", length = 4000, nullable = false)),
	@AttributeOverride(name = "embedded.description", column = @Column(name = "par_des", length = 1000, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "par_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "par_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "par_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "par_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "par_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_par_idf_fk"))
})
public class ParameterEntity extends AbstractWithIdentificadorAuditableEntity<Parameter, WithIdentificadorAndCodiPk<String>> {

	@Embedded
	protected Parameter embedded;

	@Builder
	public ParameterEntity(
			WithIdentificadorAndCodiPk<String> pk,
			Parameter embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Parameter embedded) {
		this.embedded = embedded;
	}
	
}
