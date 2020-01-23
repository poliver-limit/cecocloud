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
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.FuncionalitatPerfil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relacio funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "funcionalitat_perfil",
		uniqueConstraints = {
				@UniqueConstraint(name = "funcperf_uk", columnNames = {"funcionalitat_id", "perfil_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.permis", column = @Column(name = "permis", length = 20, nullable = false))
})
public class FuncionalitatPerfilEntity extends AbstractAuditableVersionableEntity<FuncionalitatPerfil, Long> {

	@Embedded
	protected FuncionalitatPerfil embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "funcionalitat_id",
			foreignKey = @ForeignKey(name = "funcperf_funcionalitat_fk"))
	protected FuncionalitatEntity funcionalitat;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "perfil_id",
			foreignKey = @ForeignKey(name = "funcperf_perfil_fk"))
	protected PerfilEntity perfil;

	@Builder
    public FuncionalitatPerfilEntity(
    		FuncionalitatPerfil embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(FuncionalitatPerfil embedded) {
		this.embedded = embedded;
	}
	public void updateFuncionalitat(FuncionalitatEntity funcionalitat) {
		this.funcionalitat = funcionalitat;
	}
	public void updatePerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

}
