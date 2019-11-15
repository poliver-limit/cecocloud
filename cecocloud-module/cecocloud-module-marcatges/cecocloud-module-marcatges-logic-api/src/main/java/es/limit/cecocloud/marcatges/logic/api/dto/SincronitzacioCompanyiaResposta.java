/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Resposta de la sincronització d'una companyia de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class SincronitzacioCompanyiaResposta {

	private SincronitzacioResposta identificadorsResposta;
	private SincronitzacioResposta empresesResposta;
	private SincronitzacioResposta operarisResposta;

}
