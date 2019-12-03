/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.Identificador;
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
@Entity
@Table(
		name = "tges_idf",
		indexes = {
//				@Index(name = "iges_idf_idf_fk", columnList = "idf_idf_cod"),
//				@Index(name = "irges_idf_pk", columnList = "idf_idf_cod,idf_cod", unique = true)
		}
)

@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "idf_cod", length = 4, nullable = false)),
//	@AttributeOverride(name = "embedded.nom", column = @Column(name = "idf_nom", length = 40, nullable = false))
})

public class IdentificadorEntity extends AbstractAuditableCompositePkEntity<Identificador, String> {

	@Embedded
	protected Identificador embedded;

	@Builder
	public IdentificadorEntity(
			Identificador embedded
			) {		
		this.embedded = embedded;
	}

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}
	public void setCodi(String id) {
		if (this.isNew()) {
			this.setId(id);
		} else {
//			throw new OperationDeniedException("Modificar ID de Identificador.");
		}
	}

}
