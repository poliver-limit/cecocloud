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
import es.limit.cecocloud.logic.api.dto.Perfil;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat del model de dades que conté la informació d'un perfil d'usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "perfil",
		uniqueConstraints = {
				@UniqueConstraint(name = "perfil_uk", columnNames = {"companyia_id", "codi"})
		}
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 30, nullable = false)),
    @AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 255, nullable = false))
})
public class PerfilEntity extends AbstractEntity<Perfil, Long> {

	@Embedded
	protected Perfil embedded;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "companyia_id",
			foreignKey = @ForeignKey(name = "perfil_companyia_fk"))
	protected CompanyiaEntity companyia;

	@Builder
	public PerfilEntity(
			Perfil embedded,
			CompanyiaEntity companyia) {
		this.embedded = embedded;
		this.companyia = companyia;
	}

	@Override
	public void update(Perfil embedded) {
		this.embedded = embedded;
	}
	public void updateCompanyia(CompanyiaEntity companyia) {
		this.companyia = companyia;
	}

}
