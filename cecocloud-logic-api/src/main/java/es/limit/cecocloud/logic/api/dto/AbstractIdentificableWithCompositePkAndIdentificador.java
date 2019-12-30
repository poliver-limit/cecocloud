/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithCompositePkAndIdentificador<PK extends Serializable> extends AbstractIdentificableWithIdentificador<String> implements IdentificableWithCompositePkAndIdentificador<PK> {

}
