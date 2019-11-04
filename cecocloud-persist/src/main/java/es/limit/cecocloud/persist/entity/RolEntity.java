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

import es.limit.base.boot.persist.entity.AbstractEntity;
import es.limit.cecocloud.logic.api.dto.Rol;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació d'un rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "rol",
		uniqueConstraints = {
				@UniqueConstraint(name = "rol_uk", columnNames = {"companyia_id", "codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 30, nullable = false)),
    @AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 255, nullable = false))
})
public class RolEntity extends AbstractEntity<Rol, Long> {

	@Embedded
	protected Rol embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "companyia_id",
			foreignKey = @ForeignKey(name = "rol_companyia_fk"))
	protected CompanyiaEntity companyia;

	@Builder
	public RolEntity(
			Rol embedded,
			CompanyiaEntity companyia) {
		this.embedded = embedded;
		this.companyia = companyia;
	}

	@Override
	public void update(Rol embedded) {
		this.embedded = embedded;
	}
	public void updateCompanyia(CompanyiaEntity companyia) {
		this.companyia = companyia;
	}

}
