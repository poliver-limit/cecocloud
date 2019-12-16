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
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa.PerfilUsuariIdentificadorEmpresaPk;
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
@Table(name = "perfil_usuidfemp")
@AttributeOverrides({
	@AttributeOverride(name = "id.perfilId", column = @Column(name = "perfil_id")),
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.identificadorId", column = @Column(name = "identificador_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id"))
})
public class PerfilUsuariIdentificadorEmpresaEntity extends AbstractAuditableVersionableCompositePkEntity<PerfilUsuariIdentificadorEmpresa, PerfilUsuariIdentificadorEmpresaPk> {

	@Embedded
	protected PerfilUsuariIdentificadorEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", foreignKey = @ForeignKey(name = "perusuidfemp_perfil_fk"), insertable = false, updatable = false)
	protected PerfilEntity perfil;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "usuari_id", referencedColumnName = "usuari_id", insertable = false, updatable = false),
					@JoinColumn(name = "identificador_id", referencedColumnName = "identificador_id", insertable = false, updatable = false),
					@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "perusuidfemp_usuidfemp_fk")
	)
	protected UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa;

	@Builder
	public PerfilUsuariIdentificadorEmpresaEntity(
			PerfilUsuariIdentificadorEmpresaPk pk,
			PerfilUsuariIdentificadorEmpresa embedded,
			PerfilEntity perfil,
			UsuariIdentificadorEmpresaEntity usuariIdentificadorEmpresa) {
		setId(pk);
		this.embedded = embedded;
		this.perfil = perfil;
		this.usuariIdentificadorEmpresa = usuariIdentificadorEmpresa;
	}

	@Override
	public void update(PerfilUsuariIdentificadorEmpresa embedded) {
		this.embedded = embedded;
	}

}
