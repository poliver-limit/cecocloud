/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * IResposta de la sincronització una companyia de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class SincronitzacioResposta {

	private int createCount;
	private int updateCount;
	private int deleteCount;

}
