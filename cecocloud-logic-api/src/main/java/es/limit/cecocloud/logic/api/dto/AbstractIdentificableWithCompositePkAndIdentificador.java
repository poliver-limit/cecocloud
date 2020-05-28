/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import es.limit.base.boot.logic.api.dto.CompositePk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithCompositePkAndIdentificador<PK extends CompositePk> extends AbstractIdentificableWithIdentificador<String> implements IdentificableWithCompositePkAndIdentificador<PK> {

}
