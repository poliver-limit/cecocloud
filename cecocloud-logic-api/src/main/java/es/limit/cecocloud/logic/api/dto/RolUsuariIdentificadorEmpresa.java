/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.logic.api.dto.RolUsuariIdentificadorEmpresa.RolUsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'una relació rol-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class RolUsuariIdentificadorEmpresa extends AbstractIdentificableWithCompositePk<RolUsuariIdentificadorEmpresaPk> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Rol, Long> rol;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReferenceWithCompositePk<UsuariIdentificadorEmpresa, UsuariIdentificadorEmpresaPk> usuariIdentificadorEmpresa;
	@Transient
	@RestapiField(
			hiddenInGrid = true,
			hiddenInForm = true,
			hiddenInLov = true)
	private String description;

	public String getDescription() {
		if (rol != null || usuariIdentificadorEmpresa != null) {
			return ((rol != null) ? rol.getDescription() : "") + " - " + ((usuariIdentificadorEmpresa != null) ? usuariIdentificadorEmpresa.getDescription() : "");
		} else {
			return null;
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class RolUsuariIdentificadorEmpresaPk extends UsuariIdentificadorEmpresaPk {
		private Long rolId;
		public RolUsuariIdentificadorEmpresaPk(
				Long rolId,
				Long usuariId,
				Long identificadorId,
				Long empresaId) {
			super(usuariId, identificadorId, empresaId);
			this.rolId = rolId;
		}
	}

}
