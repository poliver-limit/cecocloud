/**
 * 
 */
package es.limit.cecocloud.lici.persist.entity;

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

import es.limit.base.boot.persist.entity.AbstractAuditableVersionableEntity;
import es.limit.cecocloud.lici.logic.api.dto.Cpv;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de model de dades que conté la informació d'un CPV.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
		name = "tlic_cpv"
)
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "codi", length = 10, nullable = false)),
	@AttributeOverride(name = "embedded.descripcio", column = @Column(name = "descripcio", length = 255, nullable = false))
})
public class CpvEntity extends AbstractAuditableVersionableEntity<Cpv, Long> {

	@Embedded
	protected Cpv embedded;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "licitacio_id",
			foreignKey = @ForeignKey(name = "cpv_licitacio_fk"))
	private LicitacioEntity licitacio;

	@Builder
    public CpvEntity(
    		Cpv embedded,
    		LicitacioEntity licitacio) {
        this.embedded = embedded;
        this.licitacio = licitacio;
    }

	@Override
	public void update(Cpv embedded) {
		this.embedded = embedded;
	}
	public void updateLicitacio(LicitacioEntity licitacio) {
		this.licitacio = licitacio;
	}

}
