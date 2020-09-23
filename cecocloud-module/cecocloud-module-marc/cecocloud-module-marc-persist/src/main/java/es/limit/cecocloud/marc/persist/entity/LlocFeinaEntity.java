/**
 * 
 */
package es.limit.cecocloud.marc.persist.entity;

import java.util.Set;

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

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.marc.logic.api.dto.LlocFeina;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un lloc de feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "tmar_lloc_feina")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.adressa", column = @Column(name = "adressa", length = 200, nullable = false)),
	@AttributeOverride(name = "embedded.adrecesIpPermeses", column = @Column(name = "adrsip_perm", length = 200)),
	@AttributeOverride(name = "embedded.latitud", column = @Column(name = "latitud", precision = 12, scale = 8)),
	@AttributeOverride(name = "embedded.longitud", column = @Column(name = "longitud", precision = 12, scale = 8)),
	@AttributeOverride(name = "embedded.distanciaMaxima", column = @Column(name = "distancia_max", nullable = false))
})
public class LlocFeinaEntity extends AbstractAuditableVersionableEntity<LlocFeina, Long> {

	@Embedded
	protected LlocFeina embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "rmar_lloc_feina_empresa_fk"))
	protected EmpresaEntity empresa;
	@OneToMany(mappedBy = "llocFeina", cascade = CascadeType.ALL)
	protected Set<OperariEmpresaLlocFeinaEntity> operariEmpresaLlocsFeina;

	@Builder
	public LlocFeinaEntity(
			LlocFeina embedded,
			EmpresaEntity empresa) {
		this.embedded = embedded;
		this.empresa = empresa;
	}

	@Override
	public void update(LlocFeina embedded) {
		this.embedded = embedded;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}
