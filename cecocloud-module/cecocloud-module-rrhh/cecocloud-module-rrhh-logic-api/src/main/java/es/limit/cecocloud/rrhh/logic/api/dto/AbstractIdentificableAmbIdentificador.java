/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorPk;
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
public abstract class AbstractIdentificableAmbIdentificador<PK extends AmbIdentificadorPk> extends AbstractIdentificableWithCompositePk<PK> implements IdentificableAmbIdentificador<PK> {

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
	public static class AmbIdentificadorPk implements Serializable {
		private String identificadorCodi;
	}

	@NoArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	@MappedSuperclass
	public static class AmbIdentificadorICodiPk<C> extends AmbIdentificadorPk {
		private C codi;
		public AmbIdentificadorICodiPk(
				String identificadorCodi,
				C codi) {
			super(identificadorCodi);
			this.codi = codi;
		}
	}

}
