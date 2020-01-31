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

import es.limit.base.boot.persist.entity.AbstractAuditableEntity;
import es.limit.cecocloud.fact.logic.api.dto.Identificador;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de model de dades que conté la informació d'una Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity(name = "factIdentificadorEntity")
@Table(name = "tges_idf")

@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "idf_cod", length = 4)),
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "idf_cod", insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "idf_nom", length = 40, nullable = false))
})

public class IdentificadorEntity extends AbstractAuditableEntity<Identificador, String> {

	@Embedded
	protected Identificador embedded;

	@Builder
	public IdentificadorEntity(
			Identificador embedded) {		
		this.embedded = embedded;
	}

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}

}
