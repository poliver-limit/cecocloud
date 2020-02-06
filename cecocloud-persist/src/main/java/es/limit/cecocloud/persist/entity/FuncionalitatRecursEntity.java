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
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecurs;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una relacio funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "funcionalitat_recurs",
		uniqueConstraints = {
				@UniqueConstraint(name = "funcrecu_uk", columnNames = {"funcionalitat_id", "recurs_id"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.principal", column = @Column(name = "principal", nullable = false)),
	@AttributeOverride(name = "embedded.resourceClassName", column = @Column(name = "resource_classname", length = 100, nullable = false))
})
public class FuncionalitatRecursEntity extends AbstractAuditableVersionableEntity<FuncionalitatRecurs, Long> {

	@Embedded
	protected FuncionalitatRecurs embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "funcionalitat_id",
			foreignKey = @ForeignKey(name = "funcrecu_funcionalitat_fk"))
	protected FuncionalitatEntity funcionalitat;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "recurs_id",
			foreignKey = @ForeignKey(name = "funcrecu_recurs_fk"))
	protected RecursEntity recurs;

	@Formula(value="(select rec.class_name from recurs rec where rec.id = recurs_id)")
	private String recursClassName;

	@Builder
    public FuncionalitatRecursEntity(
    		FuncionalitatRecurs embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(FuncionalitatRecurs embedded) {
		this.embedded = embedded;
	}
	public void updateFuncionalitat(FuncionalitatEntity funcionalitat) {
		this.funcionalitat = funcionalitat;
	}
	public void updateRecurs(RecursEntity recurs) {
		this.recurs = recurs;
	}

}
