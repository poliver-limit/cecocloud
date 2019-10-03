/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import java.io.Serializable;

/**
 * Interfície que han d'implementar tots els DTOs identificables amb clau
 * primària composta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableWithCompositePk<PK extends Serializable> extends Identificable<String> {

}
