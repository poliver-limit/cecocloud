/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una posició geogràfica.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public class GeoPosition {

	private Double latitude;
	private Double longitude;

}
