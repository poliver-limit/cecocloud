/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Informació de sessió d'usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@ToString
@AllArgsConstructor
public class UserSession {

	private Long i; // Id de l'identificador
	private Long e; // Id de l'empresa

}