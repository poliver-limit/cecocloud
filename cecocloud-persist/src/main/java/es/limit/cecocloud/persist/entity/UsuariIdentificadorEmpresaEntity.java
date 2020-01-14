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
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
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
@Table(name = "usuari_ident_empresa")
@AttributeOverrides({
	@AttributeOverride(name = "id.usuariId", column = @Column(name = "usuari_id")),
	@AttributeOverride(name = "id.identificadorId", column = @Column(name = "identificador_id")),
	@AttributeOverride(name = "id.empresaId", column = @Column(name = "empresa_id"))
})
public class UsuariIdentificadorEmpresaEntity extends AbstractAuditableVersionableCompositePkEntity<UsuariIdentificadorEmpresa, UsuariIdentificadorEmpresaPk> {

	@Embedded
	protected UsuariIdentificadorEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumns(
			value = {
					@JoinColumn(name = "usuari_id", referencedColumnName = "usuari_id", insertable = false, updatable = false),
					@JoinColumn(name = "identificador_id", referencedColumnName = "identificador_id", insertable = false, updatable = false)
			},
			foreignKey = @ForeignKey(name = "usuidfemp_usuidf_fk")
	)
	protected UsuariIdentificadorEntity usuariIdentificador;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "usuidfemp_empresa_fk"))
	protected EmpresaEntity empresa;

	@Builder
	public UsuariIdentificadorEmpresaEntity(
			UsuariIdentificadorEmpresaPk pk,
			UsuariIdentificadorEmpresa embedded,
			UsuariIdentificadorEntity usuariIdentificador,
			EmpresaEntity empresa) {
		setId(pk);
		this.embedded = embedded;
		this.usuariIdentificador = usuariIdentificador;
		this.empresa = empresa;
	}

	@Override
	public void update(UsuariIdentificadorEmpresa embedded) {
		this.embedded = embedded;
	}

}