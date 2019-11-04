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
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa.PerfilUsuariEmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació d'una relació perfil - usuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "perfil_usuariempresa")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id")),
	@AttributeOverride(name = "id.perfilId", column = @Column(name = "perfil_id"))
})
public class PerfilUsuariEmpresaEntity extends AbstractCompositePkEntity<PerfilUsuariEmpresa, PerfilUsuariEmpresaPk> {

	@Embedded
	protected PerfilUsuariEmpresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", foreignKey = @ForeignKey(name = "perfilusuemp_perfil_fk"), insertable = false, updatable = false)
	protected PerfilEntity perfil;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "usuari_id", foreignKey = @ForeignKey(name = "perfilusuemp_usuemp_fk"), insertable = false, updatable = false),
		@JoinColumn(name = "empresa_id", foreignKey = @ForeignKey(name = "perfilusuemp_usuemp_fk"), insertable = false, updatable = false)
	})
	protected UsuariEmpresaEntity usuariEmpresa;

	@Builder
	public PerfilUsuariEmpresaEntity(
			PerfilUsuariEmpresa embedded,
			PerfilEntity perfil,
			UsuariEmpresaEntity usuariEmpresa) {
		this.embedded = embedded;
		this.perfil = perfil;
		this.usuariEmpresa = usuariEmpresa;
	}

	@Override
	public void update(PerfilUsuariEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updateUsuariEmpresa(UsuariEmpresaEntity usuariEmpresa) {
		this.usuariEmpresa = usuariEmpresa;
	}
	public void updatePerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

}
