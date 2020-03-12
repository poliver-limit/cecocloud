/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.MappedSuperclass;

import es.limit.base.boot.logic.api.dto.CompositePk;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.IdentificableWithCompositePk;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificador.WithIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Interfície pels DTOs amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableWithIdentificador<PK extends WithIdentificadorPk> extends IdentificableWithCompositePk<PK> {

	public GenericReference<Identificador, String> getIdentificador();
	public void setIdentificador(GenericReference<Identificador, String> identificador);

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@Setter
	@SuppressWarnings("serial")
	@MappedSuperclass
	@ToString
	public static class WithIdentificadorPk implements CompositePk {
		private String identificadorCodi;
	}

}
