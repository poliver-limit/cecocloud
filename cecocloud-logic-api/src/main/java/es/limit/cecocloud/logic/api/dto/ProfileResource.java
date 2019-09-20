/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació sobre el formulari d'un recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class ProfileResource {

	private String name;
	private String translateKey;
	private String translateKeyPlural;
	private String descriptionField;
	private String lovDescriptionField;
	private boolean quickFilterAvailable;
	List<ProfileResourceField> fields;
	List<ProfileResourceGrid> grids;
	private boolean hasCreatePermission;
	private boolean hasReadPermission;
	private boolean hasUpdatePermission;
	private boolean hasDeletePermission;

}
