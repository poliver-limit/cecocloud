/**
 * 
 */
package es.limit.cecocloud.logic.api.generic.dto;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.IdentificableWithCompositePk;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.generic.dto.CompositePkAmbIdentificador.AmbIdentificadorPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Interfície que han d'implementar tots els DTOs amb clau composta i identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CompositePkAmbIdentificador<PK extends AmbIdentificadorPk> extends IdentificableWithCompositePk<PK> {

	public GenericReference<Identificador, Long> getIdentificador();
	public void setIdentificador(GenericReference<Identificador, Long> identificador);
	
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
