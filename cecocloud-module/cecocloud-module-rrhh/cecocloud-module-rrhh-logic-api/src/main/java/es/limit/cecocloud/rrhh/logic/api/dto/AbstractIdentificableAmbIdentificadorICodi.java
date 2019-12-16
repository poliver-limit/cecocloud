/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableAmbIdentificadorICodi<ID extends Serializable> extends AbstractIdentificableAmbIdentificador<AmbIdentificadorICodiPk<ID>> implements IdentificableAmbIdentificadorICodi<ID> {

	public abstract ID getCodi();

}
