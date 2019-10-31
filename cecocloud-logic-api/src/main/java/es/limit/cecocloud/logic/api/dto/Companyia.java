/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom")
public class Companyia extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 30)
	@RestapiField(
			disabledForCreate = true, 
			disabledForUpdate = true, 
			includeInQuickFilter = true)
	private String codi;
	@NotNull
	@Size(max = 30)
	@RestapiField(
			disabledForCreate = true, 
			includeInQuickFilter = true)
	private String nom;
	@Size(max = 60)
	@RestapiField(
			disabledForCreate = true, 
			hiddenInGrid = true, 
			hiddenInLov = true, 
			includeInQuickFilter = true)
	private String telefon;
	@NotNull
	@Size(max = 60)
	@RestapiField(
			disabledForCreate = true, 
			hiddenInGrid = true, 
			hiddenInLov = true, 
			includeInQuickFilter = true)
	private String email;
	@NotNull(groups = {OnCreate.class})
	@Size(max = 2000)
	@RestapiField(
			type = RestapiFieldType.TEXTAREA, 
			disabledForUpdate = true, 
			disabledForCreate = true, 
			hiddenInGrid = true, 
			hiddenInLov = true)
	private String llicenciaKey;
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV, 
			lovWithDescriptionInput = true, 
			hiddenInGrid = true, 
			hiddenInLov = true, 
			hiddenInForm = true)
	private Llicencia llicencia;

}
