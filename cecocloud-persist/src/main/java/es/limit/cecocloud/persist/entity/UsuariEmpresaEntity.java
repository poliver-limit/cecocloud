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

import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Entitat del model de dades que conté la informació d'una relacio usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "usuari_empresa")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id")),
})
public class UsuariEmpresaEntity extends AbstractCompositePkEntity<UsuariEmpresa, UsuariEmpresaPk> {

	@Embedded
	protected UsuariEmpresa embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuari_id", foreignKey = @ForeignKey(name = "usuemp_usuari_fk"), insertable = false, updatable = false)
	protected UsuariEntity usuari;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id", foreignKey = @ForeignKey(name = "usuemp_empresa_fk"), insertable = false, updatable = false)
	protected EmpresaEntity empresa;

	@Builder
	public UsuariEmpresaEntity(
			UsuariEmpresaPk pk,
			UsuariEmpresa embedded,
			UsuariEntity usuari,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.usuari = usuari;
		this.empresa = empresa;
	}

	@Override
	public void update(UsuariEmpresa embedded) {
	}

}