/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.generic.dto.AbstractIdentificableAmbIdentificador;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio"
)
public class RolFuncionalitat extends AbstractIdentificableAmbIdentificador<Long> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Rol, Long> rol;
	@NotNull
	@RestapiField(hiddenInGrid = true)
	private Long funcionalitatId;

	private boolean accessGranted;
	private boolean readGranted;
	private boolean writeGranted;
	private boolean deleteGranted;
	private boolean executeGranted;
	private boolean printGranted;
	private boolean adminGranted;

}
