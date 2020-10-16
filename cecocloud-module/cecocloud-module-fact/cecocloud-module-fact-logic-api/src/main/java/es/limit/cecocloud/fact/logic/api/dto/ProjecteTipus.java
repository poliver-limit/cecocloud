/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO amb informació d'un ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@RestapiResource(descriptionField = "nom")
public class ProjecteTipus extends AbstractIdentificableWithIdentificadorAndCodi<String> {

	@NotNull(groups = { OnCreate.class })
	@Size(max = 6)
	@RestapiField(disabledForUpdate = true, toUpperCase = true, includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 30)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	@Size(max = 30)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String descripcio;
	
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true)
	private String descNomCodi;
}
