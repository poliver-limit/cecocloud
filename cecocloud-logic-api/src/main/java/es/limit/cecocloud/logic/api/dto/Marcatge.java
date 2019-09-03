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
@RestapiResource(
		authoritiesWithCreatePermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithReadPermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithUpdatePermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithDeletePermission = { Rol.ADMIN, Rol.MARCA })
public class Marcatge extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	//private GenericReference<Operari, Long> operari;
	private Operari operari;
	@NotNull
	@RestapiField(type = RestapiFieldType.DATETIME)
	private Date data;

}
