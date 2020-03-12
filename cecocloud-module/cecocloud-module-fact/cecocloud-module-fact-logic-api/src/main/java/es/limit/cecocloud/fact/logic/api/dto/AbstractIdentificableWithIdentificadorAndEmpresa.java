/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndEmpresa.WithIdentificadorAndEmpresaPk;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO abstracte amb identificador i empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithIdentificadorAndEmpresa<PK extends WithIdentificadorAndEmpresaPk> extends AbstractIdentificableWithIdentificador<PK> implements IdentificableWithIdentificadorAndEmpresa<PK> {

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private GenericReference<Empresa, String> empresa;

}
