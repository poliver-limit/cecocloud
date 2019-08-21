/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import org.springframework.hateoas.alps.Alps;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació del profile.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Profile {

	private Alps alps;
	private ProfileResource resource;

}
