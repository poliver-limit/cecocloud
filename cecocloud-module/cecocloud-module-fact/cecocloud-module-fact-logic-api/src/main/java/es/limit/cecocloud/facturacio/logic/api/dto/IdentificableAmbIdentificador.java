/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.IdentificableWithCompositePk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificador.AmbIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Interfície pels DTOs amb identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdentificableAmbIdentificador<PK extends AmbIdentificadorPk> extends IdentificableWithCompositePk<PK> {

	public GenericReference<Identificador, String> getIdentificador();

	public void setIdentificador(GenericReference<Identificador, String> identificador);

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	@MappedSuperclass
	public static class AmbIdentificadorPk implements Serializable {
		private String identificadorCodi;
	}

}
