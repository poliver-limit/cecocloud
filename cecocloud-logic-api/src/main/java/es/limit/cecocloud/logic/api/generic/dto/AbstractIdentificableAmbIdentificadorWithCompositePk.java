/**
 * 
 */
package es.limit.cecocloud.logic.api.generic.dto;

import java.io.Serializable;

/**
 * Implementació per defecte de la interfície IdentificableAmbIdentificadorWithCompositePk.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public abstract class AbstractIdentificableAmbIdentificadorWithCompositePk<PK extends Serializable> extends AbstractIdentificableAmbIdentificador<String> implements IdentificableAmbIdentificadorWithCompositePk<PK> {

}
