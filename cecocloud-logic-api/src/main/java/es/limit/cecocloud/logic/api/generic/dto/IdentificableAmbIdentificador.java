/**
 * 
 */
package es.limit.cecocloud.logic.api.generic.dto;

import java.io.Serializable;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.Identificable;
import es.limit.cecocloud.logic.api.dto.Identificador;

/**
 * Interfície pels DTOs amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificador<ID extends Serializable> extends Identificable<ID> {

	public GenericReference<Identificador, Long> getIdentificador();
	public void setIdentificador(GenericReference<Identificador, Long> identificador);

}
