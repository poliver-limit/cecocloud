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
			SincronitzacioResposta usuaris,
			SincronitzacioResposta operaris) {
		super(createCount, updateCount, deleteCount, errorCount);
		this.usuaris = usuaris;
		this.operaris = operaris;
	}

	private SincronitzacioResposta usuaris;
	private SincronitzacioResposta operaris;

}
