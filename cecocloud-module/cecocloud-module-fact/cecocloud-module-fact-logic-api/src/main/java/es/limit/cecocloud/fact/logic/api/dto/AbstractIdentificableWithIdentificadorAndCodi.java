/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.io.Serializable;

import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithIdentificadorAndCodi<ID extends Serializable> extends AbstractIdentificableWithIdentificador<WithIdentificadorAndCodiPk<ID>> implements IdentificableWithIdentificadorAndCodi<ID> {

	public abstract ID getCodi();

}
