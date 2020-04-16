/**
 * 
 */
package es.limit.cecocloud.persist.entity;

import es.limit.base.boot.persist.entity.AbstractAuditableCompositePkEntity;
import es.limit.cecocloud.logic.api.dto.Comptador;
import es.limit.cecocloud.logic.api.dto.Comptador.ComptadorPk;

/**
 * Entitat base que conté la informació d'un comptador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractComptadorEntity extends AbstractAuditableCompositePkEntity<Comptador, ComptadorPk> {

	@Override
	public abstract void update(Comptador embedded);

}
