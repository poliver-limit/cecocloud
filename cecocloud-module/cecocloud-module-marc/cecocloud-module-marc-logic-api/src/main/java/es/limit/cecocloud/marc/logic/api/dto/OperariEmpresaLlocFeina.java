/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.GenericReference;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.OperariEmpresa;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació (operari-empresa)-(lloc de feina).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class OperariEmpresaLlocFeina extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			includeInQuickFilter = true,
			lovNamedFilter = OperariEmpresa.FILTER_LLOC_FEINA_EMPRESA,
			filterAsSuggest = false)
	private GenericReference<OperariEmpresa, Long> operariEmpresa;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<LlocFeina, Long> llocFeina;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String descripcio;

	public String getDescripcio() {
		if (operariEmpresa != null) {
			return operariEmpresa.getDescription();
		} else {
			return null;
		}
	}

}

