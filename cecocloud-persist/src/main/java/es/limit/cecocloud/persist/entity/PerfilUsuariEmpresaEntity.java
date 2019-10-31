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
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació d'una relació Perfil - usuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tcom_perfil_usuariempresa")
public class PerfilUsuariEmpresaEntity extends AbstractEntity<PerfilUsuariEmpresa, Long> {

	@Embedded
	protected PerfilUsuariEmpresa embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuariempresa_id",
			foreignKey = @ForeignKey(name = "perfilusuemp_usuemp_fk"))
	protected UsuariEmpresaEntity usuariEmpresa;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "perfil_id",
			foreignKey = @ForeignKey(name = "perfilusuemp_rol_fk"))
	protected PerfilEntity perfil;
	
	@Builder
	public PerfilUsuariEmpresaEntity(
			PerfilUsuariEmpresa embedded,
			UsuariEmpresaEntity usuariEmpresa,
			PerfilEntity perfil) {
		this.embedded = embedded;
		this.usuariEmpresa = usuariEmpresa;
		this.perfil = perfil;
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
