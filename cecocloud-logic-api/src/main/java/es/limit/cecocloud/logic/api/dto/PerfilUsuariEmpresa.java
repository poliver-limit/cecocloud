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
import es.limit.base.boot.logic.api.dto.util.GenericReferenceWithCompositePk;
import es.limit.cecocloud.logic.api.dto.PerfilUsuariEmpresa.PerfilUsuariEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una relació Perfil - UsuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class PerfilUsuariEmpresa extends AbstractIdentificableWithCompositePk<PerfilUsuariEmpresaPk> {

	@NotNull(groups = {OnCreate.class})
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private GenericReferenceWithCompositePk<UsuariEmpresa> usuariEmpresa;
	@NotNull(groups = {OnCreate.class})
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true)
	private GenericReference<Perfil, Long> perfil;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class PerfilUsuariEmpresaPk implements Serializable {
		private Long usuariId;
		private Long empresaId;
		private Long perfilId;
	}

	@Transient
	private String description;
	
	public String getDescription() {
		return usuariEmpresa.getDescription() + " - " + perfil.getDescription();
	}
}
