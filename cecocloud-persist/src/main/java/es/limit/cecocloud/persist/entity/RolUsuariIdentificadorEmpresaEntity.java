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

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableCompositePkEntity;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa.RolUsuariIdentificadorEmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relació rol-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "rol_usuidfemp")
@AttributeOverrides({
	@AttributeOverride(name = "id.rolId", column = @Column(name = "rol_id")),
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.identificadorId", column = @Column(name = "identificador_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id"))
})
public class RolUsuariIdentificadorEmpresaEntity extends AbstractAuditableVersionableCompositePkEntity<RolUsuariIdentificadorEmpresa, RolUsuariIdentificadorEmpresaPk> {

	@Embedded
	protected RolUsuariIdentificadorEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id", foreignKey = @ForeignKey(name = "rolusuidfemp_rol_fk"), insertable = false, updatable = false)
	protected RolEntity rol;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "usuari_id", referencedColumnName = "usuari_id", insertable = false, updatable = false),
					@JoinColumn(name = "identificador_id", referencedColumnName = "identificador_id", insertable = false, updatable = false),
					@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "rolusuidfemp_usuidfemp_fk")
	)
	protected UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa;

	@Builder
	public RolUsuariIdentificadorEmpresaEntity(
			RolUsuariIdentificadorEmpresaPk pk,
			RolUsuariIdentificadorEmpresa embedded,
			RolEntity rol,
			UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa) {
		setId(pk);
		this.embedded = embedded;
		this.rol = rol;
		this.usuariIdentificadorEmpresa = usuariIdentificadorEmpresa;
	}

	@Override
	public void update(RolUsuariIdentificadorEmpresa embedded) {
		this.embedded = embedded;
	}

}
