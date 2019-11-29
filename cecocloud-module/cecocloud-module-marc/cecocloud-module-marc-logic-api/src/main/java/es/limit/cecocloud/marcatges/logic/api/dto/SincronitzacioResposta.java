/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Resposta genèrica de sincronització.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class SincronitzacioResposta {

	private int createCount;
	private int updateCount;
	private int deleteCount;
	private int errorCount;

}
