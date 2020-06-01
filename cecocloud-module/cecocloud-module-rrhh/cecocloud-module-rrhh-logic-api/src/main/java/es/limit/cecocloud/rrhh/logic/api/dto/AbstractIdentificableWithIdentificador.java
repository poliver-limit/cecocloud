/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.dto.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.CompositePk;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificador.WithIdentificadorPk;
//import es.limit.cecocloud.rrhh.logic.api.dto.IdentificableAmbIdentificador.AmbIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO abstracte amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithIdentificador<PK extends WithIdentificadorPk> extends AbstractIdentificableWithCompositePk<PK> implements IdentificableWithIdentificador<PK> {

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,			
			hiddenInForm = true,			
			hiddenInLov = true)
	private GenericReference<Identificador, String> identificador;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	@MappedSuperclass
	public static class WithIdentificadorPk implements CompositePk {
		private String identificadorCodi;
	}

}
