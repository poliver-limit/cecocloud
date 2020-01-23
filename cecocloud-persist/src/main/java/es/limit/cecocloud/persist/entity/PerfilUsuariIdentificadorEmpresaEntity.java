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
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relació perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "perfil_usuidentemp",
		uniqueConstraints = {
				@UniqueConstraint(name = "perfusuidentemp_uk", columnNames = {"perfil_id", "usuidentemp_id"})
		}
)
public class PerfilUsuariIdentificadorEmpresaEntity extends AbstractAuditableVersionableEntity<PerfilUsuariIdentificadorEmpresa, Long> {

	@Embedded
	protected PerfilUsuariIdentificadorEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "perfil_id",
			foreignKey = @ForeignKey(name = "perfusuidentemp_perfil_fk"))
	protected PerfilEntity perfil;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuidentemp_id",
			foreignKey = @ForeignKey(name = "perfusuidentemp_usuidentemp_fk"))
	protected UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa;

	@Builder
	public PerfilUsuariIdentificadorEmpresaEntity(
			PerfilUsuariIdentificadorEmpresa embedded,
			PerfilEntity perfil,
			UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa) {
		this.embedded = embedded;
		this.perfil = perfil;
		this.usuariIdentificadorEmpresa = usuariIdentificadorEmpresa;
	}

	@Override
	public void update(PerfilUsuariIdentificadorEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updatePerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}
	public void updateUsuariIdentificadorEmpresa(UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa) {
		this.usuariIdentificadorEmpresa = usuariIdentificadorEmpresa;
	}

}
