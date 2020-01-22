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
import es.limit.cecocloud.logic.api.dto.RolFuncionalitat;
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
		name = "rol_funcionalitat",
		uniqueConstraints = {
				@UniqueConstraint(name = "rol_func_uk", columnNames = {"rol_id", "func_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.funcionalitatId", column = @Column(name = "func_id", nullable = false)),
    @AttributeOverride(name = "embedded.accessGranted", column = @Column(name = "access", nullable = false)),
	@AttributeOverride(name = "embedded.readGranted", column = @Column(name = "read", nullable = false)),
	@AttributeOverride(name = "embedded.writeGranted", column = @Column(name = "write", nullable = false)),
	@AttributeOverride(name = "embedded.deleteGranted", column = @Column(name = "delete", nullable = false)),
	@AttributeOverride(name = "embedded.executeGranted", column = @Column(name = "exec", nullable = false)),
	@AttributeOverride(name = "embedded.printGranted", column = @Column(name = "print", nullable = false)),
	@AttributeOverride(name = "embedded.adminGranted", column = @Column(name = "admin", nullable = false))
})
public class RolFuncionalitatEntity extends AbstractAuditableVersionableEntity<RolFuncionalitat, Long> {

	@Embedded
	protected RolFuncionalitat embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "perfilrol_rol_fk"), insertable = false, updatable = false)
	protected RolEntity rol;

	@Builder
	public RolFuncionalitatEntity(
			RolFuncionalitat embedded,
			RolEntity rol) {
		this.embedded = embedded;
		this.rol = rol;
	}

	@Override
	public void update(RolFuncionalitat embedded) {
		this.embedded = embedded;
	}
	public void updateRol(RolEntity rol) {
		this.rol = rol;
	}

}
