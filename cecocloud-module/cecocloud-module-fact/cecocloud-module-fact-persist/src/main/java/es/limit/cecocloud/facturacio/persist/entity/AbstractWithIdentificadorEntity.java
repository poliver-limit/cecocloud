/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.entity;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import lombok.Getter;

/**
 * Entitat de base de dades amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractWithIdentificadorEntity<D, PK extends WithIdentificadorPk> extends AbstractAuditableCompositePkEntity<D, PK> {

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "xxx_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rges_xxx_idf_fk"))
	protected IdentificadorEntity identificador;	

}
