/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiSort;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació operari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description",
		sortFields = {
			@RestapiSort(field = "operari.codi"),
			@RestapiSort(field = "operari.usuari.nom"),
			@RestapiSort(field = "operari.usuari.llinatges")
		}
)
public class OperariEmpresa extends AbstractIdentificable<Long> {

	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	public static final String FILTER_MARC_ALLOWED = "marc-allowed";

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Operari, Long> operari;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Empresa, Long> empresa;
	private boolean actiu = true;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String description;

}
