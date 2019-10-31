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
import es.limit.base.boot.persist.entity.UsuariEntity;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa;
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
@Table(name = "tcom_usuari_empresa")
public class UsuariEmpresaEntity extends AbstractEntity<UsuariEmpresa ,Long> {
	
	@Embedded
	protected UsuariEmpresa embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuari_id",
			foreignKey = @ForeignKey(name = "usuemp_usuari_fk"))
	protected UsuariEntity usuari;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "usuemp_empresa_fk"))
	protected EmpresaEntity empresa;
	
	@Builder
	public UsuariEmpresaEntity(
			UsuariEmpresa embedded,
			UsuariEntity usuari,
			EmpresaEntity empresa) {
		this.embedded = embedded;
		this.usuari = usuari;
		this.empresa = empresa;
	}

	@Override
	public void update(UsuariEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updateUsuari(UsuariEntity usuari) {
		this.usuari = usuari;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}
	
}