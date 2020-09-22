/**
 * 
 */
package es.limit.cecocloud.fact.persist.entity;

import javax.persistence.ConstraintMode;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.limit.base.boot.persist.entity.AbstractAuditableOnCreateCompositePkEntity;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import lombok.Getter;

/**
 * Entitat de base de dades amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractWithIdentificadorAuditableOnCreateEntity<D, PK extends WithIdentificadorPk> extends AbstractAuditableOnCreateCompositePkEntity<D, PK> {

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "xxx_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	protected IdentificadorEntity identificador;	

}
