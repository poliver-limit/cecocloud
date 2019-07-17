/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Set;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Usuari extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 100)
	private String codi;
	@NotNull
	@Size(max = 100)
	private String nom;
	@NotNull
	@Size(max = 100)
	private String email;
	@Size(max = 255)
	private String imatgeUrl;
	@Size(max = 50)
	private String proveidorAuth;
	@Size(max = 255)
	private String contrasenya;
	@Transient
	private Set<Rol> rols;

}
