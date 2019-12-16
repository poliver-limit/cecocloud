/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;

/**
 * Interfície pels DTOs amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificadorICodi<ID extends Serializable> extends IdentificableAmbIdentificador<AmbIdentificadorICodiPk<ID>> {

	public ID getCodi();

}
