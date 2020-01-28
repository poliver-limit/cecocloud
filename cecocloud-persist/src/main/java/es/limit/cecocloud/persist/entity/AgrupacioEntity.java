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
import es.limit.cecocloud.logic.api.dto.Agrupacio;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "agrupacio",
		uniqueConstraints = {
				@UniqueConstraint(name = "agrupacio_uk", columnNames = {"codi", "modul"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 8, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 100, nullable = false)),
	@AttributeOverride(name = "embedded.modul", column = @Column(name = "modul", length = 4, nullable = false))
})
public class AgrupacioEntity extends AbstractAuditableVersionableEntity<Agrupacio, Long> {

	@Embedded
	protected Agrupacio embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "pare_id",
			foreignKey = @ForeignKey(name = "agrupacio_pare_fk"))
	protected AgrupacioEntity pare;

	@Builder
    public AgrupacioEntity(
    		Agrupacio embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(Agrupacio embedded) {
		this.embedded = embedded;
	}
	public void updatePare(AgrupacioEntity pare) {
		this.pare = pare;
	}

}
