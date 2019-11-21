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

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableCompositePkEntity;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
import es.limit.cecocloud.logic.api.dto.PerfilRol.PerfilRolPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació de la relació entre perfil i grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "perfil_rol")
@AttributeOverrides({
	@AttributeOverride(name = "id.perfilId", column = @Column(name = "perfil_id")),
	@AttributeOverride(name = "id.rolId", column = @Column(name = "rol_id")),
})
public class PerfilRolEntity extends AbstractAuditableVersionableCompositePkEntity<PerfilRol, PerfilRolPk> {

	@Embedded
	protected PerfilRol embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", foreignKey = @ForeignKey(name = "perfilrol_perfil_fk"), insertable = false, updatable = false)
	protected PerfilEntity perfil;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "perfilrol_rol_fk"), insertable = false, updatable = false)
	protected RolEntity rol;

	@Builder
	public PerfilRolEntity(
			PerfilRolPk pk,
			PerfilRol embedded,
			PerfilEntity perfil,
			RolEntity rol) {
		setId(pk);
		this.embedded = embedded;
		this.perfil = perfil;
		this.rol = rol;
	}

	@Override
	public void update(PerfilRol embedded) {
		this.embedded = embedded;
	}

}
