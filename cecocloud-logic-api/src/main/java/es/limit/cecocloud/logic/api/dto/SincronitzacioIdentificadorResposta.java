/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Resposta del procés de sincronització d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class SincronitzacioIdentificadorResposta {

	private SincronitzacioResposta operarisResposta;
	private SincronitzacioResposta empresesResposta;

}
