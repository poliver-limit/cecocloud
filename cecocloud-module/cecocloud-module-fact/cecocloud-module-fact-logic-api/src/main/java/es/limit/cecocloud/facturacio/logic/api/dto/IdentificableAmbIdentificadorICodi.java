/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificador.AmbIdentificadorPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi.AmbIdentificadorICodiPk;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Interfície pels DTOs amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificadorICodi<ID extends Serializable> extends IdentificableAmbIdentificador<AmbIdentificadorICodiPk<ID>> {

	public ID getCodi();

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
