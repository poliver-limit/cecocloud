/**
 * 
 */
package es.limit.cecocloud.logic.api.generic.dto;

import java.io.Serializable;

/**
 * Interfície que han d'implementar tots els DTOs identificables amb clau
 * primària composta i identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificadorWithCompositePk<PK extends Serializable> extends IdentificableAmbIdentificador<String> {

}
