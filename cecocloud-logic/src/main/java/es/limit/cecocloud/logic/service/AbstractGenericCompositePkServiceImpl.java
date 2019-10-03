/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.io.Serializable;

import es.limit.cecocloud.logic.api.dto.util.IdentificableWithCompositePk;
import es.limit.cecocloud.persist.entity.AbstractCompositePkEntity;

/**
 * Implementació base del servei de gestió d'entitats que depenen d'una
 * clau primària composta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractGenericCompositePkServiceImpl<D extends IdentificableWithCompositePk<PK>, E extends AbstractCompositePkEntity<D, PK>, PK extends Serializable> extends AbstractGenericServiceImpl<D, String, E, PK> {

	@Override
	protected abstract PK getPkFromDto(D dto);

}
