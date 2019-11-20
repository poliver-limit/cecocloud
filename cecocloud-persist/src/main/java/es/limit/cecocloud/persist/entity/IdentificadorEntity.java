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

import es.limit.base.boot.persist.entity.AbstractVersionableEntity;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.exception.OperationDeniedException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entitat de base de dades que representa un identificador (IDF).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter(value = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "identificador")
@AttributeOverrides({
	@AttributeOverride(name = "embedded.codi", column = @Column(name = "id", length = 4, nullable = false, insertable = false, updatable = false)),
	@AttributeOverride(name = "embedded.nom", column = @Column(name = "nom", length = 40, nullable = false))
})
public class IdentificadorEntity extends AbstractVersionableEntity<Identificador, String> {

	@Embedded
	protected Identificador embedded;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "companyia_id",
			foreignKey = @ForeignKey(name = "identificador_companyia_fk"))
	protected CompanyiaEntity companyia;

	@Builder
    public IdentificadorEntity(
    		Identificador embedded,
    		CompanyiaEntity companyia) {
        this.embedded = embedded;
        this.companyia = companyia;
	}

	@Override
	public void update(Identificador embedded) {
		this.embedded = embedded;
	}
	public void updateCompanyia(CompanyiaEntity companyia) {
		this.companyia = companyia;
	}
	public void setCodi(String id) {
		if (this.isNew()) {
			this.setId(id);
		} else {
			throw new OperationDeniedException("Modificar ID de Identificador.");
		}
	}

}
