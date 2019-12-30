/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

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

import es.limit.cecocloud.facturacio.logic.api.dto.Departament;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament.DepartamentPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'un Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tges_dep",
		indexes = {
				@Index(name = "iges_dep_idf_fk", columnList = "dep_idf_cod"),
				@Index(name = "irges_dep_pk", columnList = "dep_idf_cod,dep_cod", unique = true)
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "id.identificadorCodi", column = @Column(name = "dep_idf_cod", length = 4)),
	@AttributeOverride(name = "id.empresaCodi", column = @Column(name = "dep_emp_cod", length = 4)),
	@AttributeOverride(name = "id.codi", column = @Column(name = "dep_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "dep_cod", length = 4, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "dep_des", length = 60, nullable = false)),
	@AttributeOverride(name = "embedded.observacions", column = @Column(name = "dep_obs", length = 1000)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "dep_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "dep_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "dep_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "dep_datmod"))
})
@AssociationOverrides({
	@AssociationOverride(
			name = "identificador",
			joinColumns = {
					@JoinColumn(name = "dep_idf_cod", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rges_dep_idf_fk"))
})
public class DepartamentEntity extends AbstractWithIdentificadorEntity<Departament, DepartamentPk> {

	@Embedded
	protected Departament embedded;

	@Builder
	public DepartamentEntity(
			DepartamentPk pk,
			Departament embedded,
			IdentificadorEntity identificador) {
		setId(pk);
		this.embedded = embedded;
		this.identificador = identificador;		
	}

	@Override
	public void update(Departament embedded) {
		this.embedded = embedded;
	}

}
