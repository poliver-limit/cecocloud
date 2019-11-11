/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.PerfilRol.PerfilRolPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una relació Perfil - Grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class PerfilRol extends AbstractIdentificableWithCompositePk<PerfilRolPk> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true)
	private GenericReference<Perfil, Long> perfil;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true)
	private GenericReference<Rol, Long> rol;

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@SuppressWarnings("serial")
	public static class PerfilRolPk implements Serializable {
		private Long perfilId;
		private Long rolId;
	}

	@Transient
	private String description;
	
	public String getDescription() {
		return perfil.getDescription() + " - " + rol.getDescription();
	}
}
