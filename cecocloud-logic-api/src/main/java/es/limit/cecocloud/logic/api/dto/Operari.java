/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;

import es.limit.base.boot.logic.api.annotation.RestapiField;
import es.limit.base.boot.logic.api.annotation.RestapiResource;
import es.limit.base.boot.logic.api.dto.ProfileResourceField.RestapiFieldType;
import es.limit.base.boot.logic.api.dto.Rol;
import es.limit.base.boot.logic.api.dto.Usuari;
import es.limit.base.boot.logic.api.dto.util.AbstractIdentificable;
import es.limit.base.boot.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(
		descriptionField = "descripcio",
		authoritiesWithCreatePermission = { Rol.ADMIN },
		authoritiesWithReadPermission = { Rol.ADMIN, Rol.MARCA },
		authoritiesWithUpdatePermission = { Rol.ADMIN },
		authoritiesWithDeletePermission = { Rol.ADMIN })
public class Operari extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 6)
	@RestapiField(includeInQuickFilter = true, hiddenInLov = true)
	private String codi;
	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true, hiddenInLov = true)
	private GenericReference<Empresa, Long> empresa;
	@RestapiField(hiddenInGrid = true, hiddenInForm = true)
	@Formula("'('||codi||') '|| (select emp.nom from empresa emp where emp.id=empresa_id)")
	private String descripcio;
	@NotNull
	@Transient
	@RestapiField(includeInQuickFilter = true)
	private GenericReference<Usuari, Long> usuari;
	@NotNull
	@RestapiField(
			type = RestapiFieldType.DATE,
			hiddenInLov = true)
	private Date dataInici;
	@RestapiField(
			type = RestapiFieldType.DATE,
			hiddenInLov = true)
	private Date dataFi;

}
