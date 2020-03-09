/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "idf_nom", length = 40, nullable = false)),
	@AttributeOverride(name = "createdBy", column = @Column(name = "idf_usucre")),
	@AttributeOverride(name = "createdDate", column = @Column(name = "idf_datcre")),
	@AttributeOverride(name = "lastModifiedBy", column = @Column(name = "idf_usumod")),
	@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "idf_datmod"))
})

public class IdentificadorEntity extends AbstractAuditableEntity<Identificador, String> {

	@Embedded
	protected Identificador embedded;

	@OneToMany(mappedBy = "identificador", cascade = CascadeType.ALL)
	protected Set<ComptadorEntity> comptadors;

	@Builder
	public IdentificadorEntity(
			String id,
			Identificador embedded) {		
		setId(id);
		this.embedded = embedded;
	}

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}

}
