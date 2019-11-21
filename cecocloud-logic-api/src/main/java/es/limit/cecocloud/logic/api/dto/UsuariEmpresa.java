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
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificableWithCompositePk;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import es.limit.cecocloud.logic.api.dto.UsuariEmpresa.UsuariEmpresaPk;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Informació d'una relació usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description"
)
public class UsuariEmpresa extends AbstractIdentificableWithCompositePk<UsuariEmpresaPk> {

	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private GenericReference<Usuari, Long> usuari;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true)
	private GenericReference<Empresa, Long> empresa;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Getter
	@SuppressWarnings("serial")
	public static class UsuariEmpresaPk implements Serializable {
		private Long usuariId;
		private Long empresaId;
	}
	
	@Transient
	private String description;
	
	public String getDescription() {
		return usuari.getDescription() + " - " + empresa.getDescription();
	}

}
