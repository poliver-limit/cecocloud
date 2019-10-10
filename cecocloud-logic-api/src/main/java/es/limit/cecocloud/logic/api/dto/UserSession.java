/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació de la sessió d'un usuari per a ser inclosa a dins el token JWT.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class UserSession {

	private Long companyia;
	private Long empresa;

}
