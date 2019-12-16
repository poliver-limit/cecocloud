/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.entity;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
import lombok.Getter;

/**
 * Entitat de base de dades amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@MappedSuperclass
public abstract class AbstractAmbIdentificadorEntity<D, PK extends AmbIdentificadorPk> extends AbstractAuditableCompositePkEntity<D, PK> {

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(
			name = "xxx_idf_cod",
			insertable = false,
			updatable = false,
			foreignKey = @ForeignKey(name = "rrhu_xxx_idf_fk"))
	protected IdentificadorEntity identificador;	

}
