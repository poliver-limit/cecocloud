/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.limit.base.boot.persist.entity.AbstractAuditableEntity;
import es.limit.cecocloud.fact.logic.api.dto.PaisNif;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factPaisNifEntity")
@Table(
		name = "tlim_pni",
		uniqueConstraints = {
		@UniqueConstraint(name = "rlim_pni_pk", columnNames = "pni_cod")
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id.codi", column = @Column(name = "pni_cod")),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "pni_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "pni_nom", length = 40)),
	@AttributeOverride(name = "embedded.tipusNif", column = @Column(name = "pni_tipnif", length = 1, nullable = false)),
	@AttributeOverride(name = "embedded.tamanyNif", column = @Column(name = "pni_tamnif", length = 15))
	
})

public class PaisNifEntity extends AbstractAuditableEntity<PaisNif, String>{

	@Embedded
	protected PaisNif embedded;

	@Builder
	public PaisNifEntity(
			PaisNif embedded) {		
		this.embedded = embedded;
	}

	@Override
	public void update(PaisNif embedded) {
		this.embedded = embedded;
	}
}
