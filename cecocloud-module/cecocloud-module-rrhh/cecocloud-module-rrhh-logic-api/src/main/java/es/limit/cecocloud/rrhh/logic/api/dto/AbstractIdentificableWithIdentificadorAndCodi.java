/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.api.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO abstracte amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public abstract class AbstractIdentificableWithIdentificadorAndCodi<ID extends Serializable> extends AbstractIdentificableWithIdentificador<WithIdentificadorAndCodiPk<ID>> implements IdentificableWithIdentificadorAndCodi<ID> {

	public abstract ID getCodi();

	@NoArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	@MappedSuperclass
	public static class WithIdentificadorAndCodiPk<C> extends WithIdentificadorPk {
		private C codi;
		public WithIdentificadorAndCodiPk(
				String identificadorCodi,
				C codi) {
			super(identificadorCodi);
			this.codi = codi;
		}
	}

}
