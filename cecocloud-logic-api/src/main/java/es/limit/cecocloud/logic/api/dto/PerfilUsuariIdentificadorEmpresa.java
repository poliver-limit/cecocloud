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
import es.limit.cecocloud.logic.api.dto.PerfilUsuariIdentificadorEmpresa.PerfilUsuariIdentificadorEmpresaPk;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificadorEmpresa.UsuariIdentificadorEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'una relació perfil-(usuari-identificador-empresa).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class PerfilUsuariIdentificadorEmpresa extends AbstractIdentificableWithCompositePk<PerfilUsuariIdentificadorEmpresaPk> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForUpdate = true,
			includeInQuickFilter = true)
	private GenericReference<Perfil, Long> perfil;
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
		if (perfil != null || usuariIdentificadorEmpresa != null) {
			return ((perfil != null) ? perfil.getDescription() : "") + " - " + ((usuariIdentificadorEmpresa != null) ? usuariIdentificadorEmpresa.getDescription() : "");
		} else {
			return null;
		}
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper = true)
	@Getter
	@SuppressWarnings("serial")
	public static class PerfilUsuariIdentificadorEmpresaPk extends UsuariIdentificadorEmpresaPk {
		private Long perfilId;
		public PerfilUsuariIdentificadorEmpresaPk(
				Long perfilId,
				Long usuariId,
				Long identificadorId,
				Long empresaId) {
			super(usuariId, identificadorId, empresaId);
			this.perfilId = perfilId;
		}
	}

}
