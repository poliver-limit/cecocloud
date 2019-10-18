/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Set;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.limit.cecocloud.logic.api.annotation.RestapiField;
import es.limit.cecocloud.logic.api.annotation.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.validation.UsuariEmailNotExists;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@UsuariEmailNotExists
@RestapiResource(
		descriptionField = "nom",
		authoritiesWithCreatePermission = { Rol.ADMIN },
		authoritiesWithReadPermission = { Rol.ADMIN },
		authoritiesWithUpdatePermission = { Rol.ADMIN },
		authoritiesWithDeletePermission = { Rol.ADMIN })
public class Usuari extends AbstractIdentificable<Long> {

	@NotEmpty
	@Size(max = 100)
	@RestapiField(includeInQuickFilter = true)
	private String codi;
	@NotEmpty
	@Size(max = 100)
	@RestapiField(includeInQuickFilter = true)
	private String nom;
	@NotEmpty
	@Size(max = 100)
	@Email
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String email;
	@Size(max = 255)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String imatgeUrl;
	@Size(max = 105)
	@JsonIgnore
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String contrasenya;
	@Transient
	@RestapiField(hiddenInLov = true)
	private Set<Rol> rols;
	private boolean validat;
	private boolean actiu;

}
