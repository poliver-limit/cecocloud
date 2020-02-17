/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Resposta genèrica de sincronització.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioEmpresesResposta extends SincronitzacioResposta {

	public SincronitzacioEmpresesResposta(
			int createCount,
			int updateCount,
			int deleteCount,
			int errorCount,
			SincronitzacioResposta operaris) {
		super(createCount, updateCount, deleteCount, errorCount);
		this.operaris = operaris;
	}

	private SincronitzacioResposta operaris;

}
