/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació sobre un grid del formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class ProfileResourceGrid {

	private String name;
	private String translateKey;
	private String resourceName;

}
