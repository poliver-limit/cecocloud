/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
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
@Table(name = "tcom_perfil_rol")
public class PerfilRolEntity extends AbstractEntity<PerfilRol, Long> {
	
	@Embedded
	protected PerfilRol embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "perfil_id",
			foreignKey = @ForeignKey(name = "perfil_companyia_fk"))
	protected PerfilEntity perfil;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "rol_id",
			foreignKey = @ForeignKey(name = "perfil_companyia_fk"))
	protected RolEntity rol;
	
	@Builder
	public PerfilRolEntity(
			PerfilRol embedded,
			PerfilEntity perfil,
			RolEntity rol) {
		this.embedded = embedded;
		this.perfil = perfil;
		this.rol = rol;
	}

	@Override
	public void update(PerfilRol embedded) {
		this.embedded = embedded;
	}
	public void updatePerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}
	public void updateRol(RolEntity rol) {
		this.rol = rol;
	}
}
