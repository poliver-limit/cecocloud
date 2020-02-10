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
import es.limit.cecocloud.logic.api.dto.FuncionalitatIdentificadorPerfil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relacio funcionalitatIdentificador-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "funcionalitat_ident_perfil",
		uniqueConstraints = {
				@UniqueConstraint(name = "funcidfperf_uk", columnNames = {"funcionalitat_identificador_id", "perfil_id", "permis"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.permis", column = @Column(name = "permis", length = 20, nullable = false))
})
public class FuncionalitatIdentificadorPerfilEntity extends AbstractAuditableVersionableEntity<FuncionalitatIdentificadorPerfil, Long> {

	@Embedded
	protected FuncionalitatIdentificadorPerfil embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "funcionalitat_identificador_id",
			foreignKey = @ForeignKey(name = "funcidfperf_funcidf_fk"))
	protected FuncionalitatIdentificadorEntity funcionalitatIdentificador;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "perfil_id",
			foreignKey = @ForeignKey(name = "funcidfperf_perfil_fk"))
	protected PerfilEntity perfil;

	@Builder
    public FuncionalitatIdentificadorPerfilEntity(
    		FuncionalitatIdentificadorPerfil embedded,
    		FuncionalitatIdentificadorEntity funcionalitatIdentificador,
    		PerfilEntity perfil) {
        this.embedded = embedded;
        this.funcionalitatIdentificador = funcionalitatIdentificador;
        this.perfil = perfil;
    }

	@Override
	public void update(FuncionalitatIdentificadorPerfil embedded) {
		this.embedded = embedded;
	}
	public void updateFuncionalitatIdentificador(FuncionalitatIdentificadorEntity funcionalitatIdentificador) {
		this.funcionalitatIdentificador = funcionalitatIdentificador;
	}
	public void updatePerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}
	
}
