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

import org.hibernate.annotations.Formula;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Entitat del model que representa una relacio (usuari-identificador)-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "usuari_ident_empresa",
		uniqueConstraints = {
				@UniqueConstraint(name = "usuidentemp_uk", columnNames = {"usuident_id", "empresa_id"})
		}
)
public class UsuariIdentificadorEmpresaEntity extends AbstractAuditableVersionableEntity<UsuariIdentificadorEmpresa, Long> {

	@Embedded
	protected UsuariIdentificadorEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "usuident_id",
			foreignKey = @ForeignKey(name = "usuidentemp_usuidf_fk"))
	protected UsuariIdentificadorEntity usuariIdentificador;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "usuidentemp_empresa_fk"))
	protected EmpresaEntity empresa;

	@Formula(value="(select usu.codi from usuari_ident usi, usuari usu where usi.id = usuident_id and usu.id = usi.usuari_id)")
	private String usuariCodi;

	@Builder
	public UsuariIdentificadorEmpresaEntity(
			UsuariIdentificadorEmpresa embedded,
			UsuariIdentificadorEntity usuariIdentificador,
			EmpresaEntity empresa) {
		this.embedded = embedded;
		this.usuariIdentificador = usuariIdentificador;
		this.empresa = empresa;
	}

	@Override
	public void update(UsuariIdentificadorEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updateUsuariIdentificador(UsuariIdentificadorEntity usuariIdentificador) {
		this.usuariIdentificador = usuariIdentificador;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}