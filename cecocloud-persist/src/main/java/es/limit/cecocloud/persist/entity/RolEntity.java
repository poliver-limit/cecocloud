/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Rol;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa un rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "rol",
		uniqueConstraints = {
				@UniqueConstraint(name = "rol_uk", columnNames = {"identificador_id", "codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 10, nullable = false)),
    @AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100, nullable = false))
})
public class RolEntity extends AbstractAuditableVersionableEntity<Rol, Long> {

	@Embedded
	protected Rol embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "rol_identificador_fk"))
	protected IdentificadorEntity identificador;

	@Builder
	public RolEntity(
			Rol embedded,
			IdentificadorEntity identificador) {
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Rol embedded) {
		this.embedded = embedded;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}

}
