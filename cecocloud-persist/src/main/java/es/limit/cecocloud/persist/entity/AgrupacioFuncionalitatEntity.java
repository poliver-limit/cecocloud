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
import es.limit.cecocloud.logic.api.dto.AgrupacioFuncionalitat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model que representa una relació identificador-agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "agrupacio_funcionalitat",
		uniqueConstraints = {
				@UniqueConstraint(name = "agrupfunc_uk", columnNames = {"agrupacio_id", "funcionalitat_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.obligatoria", column = @Column(name = "obligatoria", nullable = false))
})
public class AgrupacioFuncionalitatEntity extends AbstractAuditableVersionableEntity<AgrupacioFuncionalitat, Long> {

	@Embedded
	protected AgrupacioFuncionalitat embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "funcionalitat_id",
			foreignKey = @ForeignKey(name = "agrupfunc_funcionalitat_fk"))
	protected FuncionalitatEntity funcionalitat;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "agrupacio_id",
			foreignKey = @ForeignKey(name = "agrupfunc_agrupacio_fk"))
	protected AgrupacioEntity agrupacio;

	@Builder
    public AgrupacioFuncionalitatEntity(
    		AgrupacioFuncionalitat embedded,
    		FuncionalitatEntity funcionalitat,
    		AgrupacioEntity agrupacio) {
        this.embedded = embedded;
        this.funcionalitat = funcionalitat;
        this.agrupacio = agrupacio;
    }

	@Override
	public void update(AgrupacioFuncionalitat embedded) {
		this.embedded = embedded;
	}
	public void updateFuncionalitat(FuncionalitatEntity funcionalitat) {
		this.funcionalitat = funcionalitat;
	}
	public void updateAgrupacio(AgrupacioEntity agrupacio) {
		this.agrupacio = agrupacio;
	}

}