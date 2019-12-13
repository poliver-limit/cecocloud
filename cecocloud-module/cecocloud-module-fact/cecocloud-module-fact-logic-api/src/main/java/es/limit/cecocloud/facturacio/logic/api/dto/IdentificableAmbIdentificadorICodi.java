/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;

/**
 * Interfície pels DTOs amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificadorICodi<ID extends Serializable> extends IdentificableAmbIdentificador<AmbIdentificadorICodiPk<ID>> {

	public ID getCodi();

}
