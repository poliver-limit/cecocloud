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
import es.limit.cecocloud.logic.api.dto.UsuariCompanyia.UsuariCompanyiaPk;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * DTO amb informació d'una relacio usuari-companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "description")
public class UsuariCompanyia extends AbstractIdentificableWithCompositePk<UsuariCompanyiaPk> {

	@NotNull(groups = {OnCreate.class})
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true,
			hiddenInGrid = true)
	private GenericReference<Usuari, Long> usuari;
	@NotNull(groups = {OnCreate.class})
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			lovWithDescriptionInput = true,
			disabledForUpdate=true,
			includeInQuickFilter = true)
	private GenericReference<Companyia, Long> companyia;

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@SuppressWarnings("serial")
	public static class UsuariCompanyiaPk implements Serializable {
		private Long usuariId;
		private Long companyiaId;
	}
	
	@Transient
	private String description;
	
	public String getDescription() {
		return usuari.getDescription() + " - " + companyia.getDescription();
	}

}

