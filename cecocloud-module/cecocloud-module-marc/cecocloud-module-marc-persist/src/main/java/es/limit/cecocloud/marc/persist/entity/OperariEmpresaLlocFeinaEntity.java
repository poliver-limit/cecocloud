/**
 * 
 */
package es.limit.cecocloud.marc.persist.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.marc.logic.api.dto.OperariEmpresaLlocFeina;
import es.limit.cecocloud.persist.entity.OperariEmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relació (operari-empresa)-(lloc de feina).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tmar_operariemp_llocfeina",
		uniqueConstraints = {
				@UniqueConstraint(name = "rmar_opeempllocf_uk", columnNames = {"operari_empresa_id", "lloc_feina_id"})
		}
)
public class OperariEmpresaLlocFeinaEntity extends AbstractAuditableVersionableEntity<OperariEmpresaLlocFeina, Long> {

	@Embedded
	protected OperariEmpresaLlocFeina embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "operari_empresa_id",
			foreignKey = @ForeignKey(name = "rmar_opeempllocf_opeemp_fk"))
	protected OperariEmpresaEntity operariEmpresa;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "lloc_feina_id",
			foreignKey = @ForeignKey(name = "rmar_opeempllocf_llocfeina_fk"))
	protected LlocFeinaEntity llocFeina;

	@Builder
	public OperariEmpresaLlocFeinaEntity(
			OperariEmpresaLlocFeina embedded,
			OperariEmpresaEntity operariEmpresa,
			LlocFeinaEntity llocFeina) {
		this.embedded = embedded;
		this.operariEmpresa = operariEmpresa;
		this.llocFeina = llocFeina;
	}

	@Override
	public void update(OperariEmpresaLlocFeina embedded) {
		this.embedded = embedded;
	}
	public void updateOperariEmpresa(OperariEmpresaEntity operariEmpresa) {
		this.operariEmpresa = operariEmpresa;
	}
	public void updateLlocFeina(LlocFeinaEntity llocFeina) {
		this.llocFeina = llocFeina;
	}

}
