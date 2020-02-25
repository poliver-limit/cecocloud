/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Perfil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa un perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "perfil",
		uniqueConstraints = {
				@UniqueConstraint(name = "perfil_uk", columnNames = {"identificador_id", "codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 10, nullable = false)),
    @AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100, nullable = false))
})
public class PerfilEntity extends AbstractAuditableVersionableEntity<Perfil, Long> {

	@Embedded
	protected Perfil embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "identificador_id",
			foreignKey = @ForeignKey(name = "perfil_identificador_fk"))
	protected IdentificadorEntity identificador;

	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
	protected List<PerfilUsuariIdentificadorEmpresaEntity> perfilsUsuarisIdentificadorsEmpreses;

	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
	protected List<FuncionalitatIdentificadorPerfilEntity> funcionalitatsIdentificadorsPerfils;

	@Builder
	public PerfilEntity(
			Perfil embedded,
			IdentificadorEntity identificador) {
		this.embedded = embedded;
		this.identificador = identificador;
	}

	@Override
	public void update(Perfil embedded) {
		this.embedded = embedded;
	}
	public void updateIdentificador(IdentificadorEntity identificador) {
		this.identificador = identificador;
	}

}
