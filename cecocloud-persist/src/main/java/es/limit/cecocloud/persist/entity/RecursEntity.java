/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Recurs;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "recurs"
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.className", column = @Column(name = "class_name", length = 1024, nullable = false, unique = true))
})
public class RecursEntity extends AbstractAuditableVersionableEntity<Recurs, Long> {

	@Embedded
	protected Recurs embedded;

	@Builder
    public RecursEntity(
    		Recurs embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(Recurs embedded) {
		this.embedded = embedded;
	}

}
