/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

/**
 * Implementació per defecte de la interfície IdentificableWithCompositePk.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractIdentificableWithCompositePk<PK extends Serializable> extends AbstractIdentificable<String> implements IdentificableWithCompositePk<PK> {

}
