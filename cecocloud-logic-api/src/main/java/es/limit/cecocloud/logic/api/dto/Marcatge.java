/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import es.limit.cecocloud.logic.api.annotation.RestapiField;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.validation.MarcatgeData;
import es.limit.cecocloud.logic.api.validation.MarcatgeOperariValid;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@MarcatgeOperariValid
@MarcatgeData
@RestapiResource(
		authoritiesWithCreatePermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithReadPermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithUpdatePermission = { Rol.ADMIN },
		authoritiesWithDeletePermission = { Rol.ADMIN })
public class Marcatge extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private Operari operari;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATETIME)
	private Date data;
	@NotNull
	@RestapiField(
			hiddenInForm = true,
			disabledForCreate = true,
			disabledForUpdate = true)
	private MarcatgeOrigen origen;

}
