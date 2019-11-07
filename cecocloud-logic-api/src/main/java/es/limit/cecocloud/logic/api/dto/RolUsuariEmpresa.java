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
import es.limit.cecocloud.logic.api.dto.RolUsuariEmpresa.RolUsuariEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO amb informació d'una relació grup - usuariEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "rol"
)
public class RolUsuariEmpresa extends AbstractIdentificableWithCompositePk<RolUsuariEmpresaPk> {

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
	private GenericReference<Rol, Long> rol;

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@SuppressWarnings("serial")
	public static class RolUsuariEmpresaPk implements Serializable {
		private Long usuariId;
		private Long empresaId;
		private Long rolId;
	}

}