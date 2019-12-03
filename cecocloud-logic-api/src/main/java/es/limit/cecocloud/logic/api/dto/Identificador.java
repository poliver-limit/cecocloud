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
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "nom")
public class Identificador extends AbstractIdentificable<String> {

	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReference<Companyia, Long> companyia;
	@Transient
	@RestapiField(
			disabledForUpdate = true,
			disabledForCreate = true,
			toUpperCase=true,
			includeInQuickFilter = true, 
			gridPercentWidth = 15)
	protected String codi;
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	protected String nom;
	@RestapiField(hiddenInLov = true)
	private boolean actiu = true;

	public String getCodi() {
		return this.id;
	}

}
