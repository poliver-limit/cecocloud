/**
 * 
 */
package es.limit.cecocloud.back.session;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació de sessió d'usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class UserSession {

	private Long companyia;
	private Long empresa;

}