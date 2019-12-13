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
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Caracteristica;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una caracteristica.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "caracteristica",
		uniqueConstraints = {
				@UniqueConstraint(name = "caracteristica_uk", columnNames = {"codi", "modul"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 4, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.modul", column = @Column(name = "modul", length = 4, nullable = false)),
})
public class CaracteristicaEntity extends AbstractAuditableVersionableEntity<Caracteristica, Long> {

	@Embedded
	protected Caracteristica embedded;

	@Builder
    public CaracteristicaEntity(
    		Caracteristica embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(Caracteristica embedded) {
		this.embedded = embedded;
	}

}
