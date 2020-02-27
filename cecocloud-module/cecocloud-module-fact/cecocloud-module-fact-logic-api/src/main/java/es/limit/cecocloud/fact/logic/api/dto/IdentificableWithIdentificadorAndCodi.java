/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Interfície pels DTOs amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableWithIdentificadorAndCodi<ID extends Serializable> extends IdentificableWithIdentificador<WithIdentificadorAndCodiPk<ID>> {

	public ID getCodi();

	@NoArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	@MappedSuperclass
	@ToString
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
