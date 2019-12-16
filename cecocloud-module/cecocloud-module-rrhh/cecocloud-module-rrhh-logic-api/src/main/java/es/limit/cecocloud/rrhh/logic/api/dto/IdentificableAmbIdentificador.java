/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.IdentificableWithCompositePk;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;

/**
 * Interfície pels DTOs amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificador<PK extends AmbIdentificadorPk> extends IdentificableWithCompositePk<PK> {

	public GenericReference<Identificador, String> getIdentificador();

	public void setIdentificador(GenericReference<Identificador, String> identificador);

}
