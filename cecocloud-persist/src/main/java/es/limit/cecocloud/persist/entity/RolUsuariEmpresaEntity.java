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
import es.limit.cecocloud.logic.api.dto.RolUsuariEmpresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació de la relació entre un usuari-empresa i el grups.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tcom_rol_usuariempresa")
public class RolUsuariEmpresaEntity extends AbstractEntity<RolUsuariEmpresa, Long> {

	@Embedded
	protected RolUsuariEmpresa embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuariempresa_id",
			foreignKey = @ForeignKey(name = "rolusuemp_usuemp_fk"))
	protected UsuariEmpresaEntity usuariEmpresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "rol_id",
			foreignKey = @ForeignKey(name = "rolusuemp_rol_fk"))
	protected RolEntity rol;
	
	@Builder
	public RolUsuariEmpresaEntity(
			RolUsuariEmpresa embedded,
			UsuariEmpresaEntity usuariEmpresa,
			RolEntity rol) {
		this.embedded = embedded;
		this.usuariEmpresa = usuariEmpresa;
		this.rol = rol;
	}

	@Override
	public void update(RolUsuariEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updateUsuariEmpresa(UsuariEmpresaEntity usuariEmpresa) {
		this.usuariEmpresa = usuariEmpresa;
	}
	public void updateRol(RolEntity rol) {
		this.rol = rol;
	}
	
}
