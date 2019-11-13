package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.Authorities;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@RestapiResource(
		descriptionField = "nom",
		authoritiesWithCreatePermission = { Authorities.ADMIN },
		authoritiesWithReadPermission = { Authorities.ADMIN },
		authoritiesWithUpdatePermission = { Authorities.ADMIN },
		authoritiesWithDeletePermission = { Authorities.ADMIN })
public class Identificador extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 4)
	@RestapiField(
			disabledForUpdate = true,
			toUpperCase=true,
			includeInQuickFilter = true)
	protected String codi;
	@NotNull
	@Size(max = 40)
	@RestapiField(
			includeInQuickFilter = true)
	protected String nom;
	@NotNull
	@Transient
	@RestapiField(
			type = RestapiFieldType.LOV,
			disabledForCreate = true,
			disabledForUpdate = true,
			//hiddenInGrid = true,
			hiddenInForm = true)
	private GenericReference<Companyia, Long> companyia;

}
