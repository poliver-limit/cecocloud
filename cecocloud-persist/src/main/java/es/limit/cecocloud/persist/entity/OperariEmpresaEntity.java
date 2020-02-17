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

import org.hibernate.annotations.Formula;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Entitat del model que representa una relacio operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "operari_empresa",
		uniqueConstraints = {
				@UniqueConstraint(name = "operariemp_uk", columnNames = {"operari_id", "empresa_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.actiu", column = @Column(name = "actiu", nullable = false))
})
public class OperariEmpresaEntity extends AbstractAuditableVersionableEntity<OperariEmpresa, Long> {

	@Embedded
	protected OperariEmpresa embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "operari_id",
			foreignKey = @ForeignKey(name = "operariemp_operari_fk"))
	protected OperariEntity operari;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "empresa_id",
			foreignKey = @ForeignKey(name = "operariemp_empresa_fk"))
	protected EmpresaEntity empresa;

	@Formula(value="(select ope.codi from operari ope where ope.id = operari_id)")
	private String operariCodi;
	@Formula(value="(select ('[' || ope.codi || '] ' || usu.nom || ' ' || usu.llinatges) from operari ope, usuari usu where ope.id = operari_id and usu.id = ope.usuari_id)")
	private String description;
	
	@Builder
	public OperariEmpresaEntity(
			OperariEmpresa embedded,
			OperariEntity operari,
			EmpresaEntity empresa) {
		this.embedded = embedded;
		this.operari = operari;
		this.empresa = empresa;
	}

	@Override
	public void update(OperariEmpresa embedded) {
		this.embedded = embedded;
	}
	public void updateOperari(OperariEntity operari) {
		this.operari = operari;
	}
	public void updateEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

}