/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithIdentificador<ID extends Serializable> extends AbstractIdentificable<ID> implements IdentificableWithIdentificador<ID> {

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,			
			hiddenInGrid = true,			
			hiddenInForm = true,			
			hiddenInLov = true)
	protected GenericReference<Identificador, Long> identificador;

}
