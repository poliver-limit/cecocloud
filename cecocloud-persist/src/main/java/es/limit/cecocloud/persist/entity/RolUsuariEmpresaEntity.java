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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.cecocloud.logic.api.dto.RolUsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.RolUsuariEmpresa.RolUsuariEmpresaPk;
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
@Table(name = "rol_usuariempresa")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id")),
	@AttributeOverride(name = "id.rolId", column = @Column(name = "rol_id"))
})
public class RolUsuariEmpresaEntity extends AbstractCompositePkEntity<RolUsuariEmpresa, RolUsuariEmpresaPk> {

	@Embedded
	protected RolUsuariEmpresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "rolusuemp_rol_fk"), insertable = false, updatable = false)
	protected RolEntity rol;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "usuari_id", insertable = false, updatable = false),
					@JoinColumn(name = "empresa_id", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rolusuemp_usuemp_fk")
	)
	protected UsuariEmpresaEntity usuariEmpresa;

	@Builder
	public RolUsuariEmpresaEntity(
			RolUsuariEmpresa embedded,
			RolEntity rol,
			UsuariEmpresaEntity usuariEmpresa) {
		this.embedded = embedded;
		this.rol = rol;
		this.usuariEmpresa = usuariEmpresa;
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
