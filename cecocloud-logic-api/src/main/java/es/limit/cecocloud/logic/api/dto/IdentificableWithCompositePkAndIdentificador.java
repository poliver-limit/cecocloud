/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.io.Serializable;

import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.IdentificableWithCompositePk;

/**
 * Interfície pels DTOs amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableWithCompositePkAndIdentificador<PK extends Serializable> extends IdentificableWithCompositePk<PK> {

	public GenericReference<Identificador, Long> getIdentificador();
	public void setIdentificador(GenericReference<Identificador, Long> identificador);

}
