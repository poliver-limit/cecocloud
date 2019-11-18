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

import es.limit.base.boot.persist.entity.AbstractVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Companyia;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa una companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "companyia",
		uniqueConstraints = {
				@UniqueConstraint(name = "companyia_codi_uk", columnNames = {"codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 30, nullable = false)),
	@AttributeOverride(name = "embedded.telefon", column = @Column(name = "telefon", length = 16)),
	@AttributeOverride(name = "embedded.email", column = @Column(name = "email", length = 120)),
	@AttributeOverride(name = "embedded.llicenciaKey", column = @Column(name = "llicencia", length = 2000))
})
public class CompanyiaEntity extends AbstractVersionableEntity<Companyia, Long> {

	@Embedded
	protected Companyia embedded;

	@Builder
    public CompanyiaEntity(Companyia embedded) {
        this.embedded = embedded;
    }

	@Override
	public void update(Companyia embedded) {
		this.embedded = embedded;
	}

}
