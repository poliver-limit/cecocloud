/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Set;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.limit.cecocloud.logic.api.annotations.RestapiField;
import es.limit.cecocloud.logic.api.annotations.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "nom")
//@Embeddable
public class Usuari extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 100)
	private String codi;
	@NotNull
	@Size(max = 100)
	private String nom;
	@NotNull
	@Size(max = 100)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String email;
	@Size(max = 255)
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String imatgeUrl;
	@Size(max = 105)
	@JsonIgnore
	@RestapiField(hiddenInGrid = true, hiddenInLov = true)
	private String contrasenya;
	private boolean validat;
	private boolean actiu;
	@Transient
	@RestapiField(hiddenInLov = true)
	private Set<Rol> rols;

}
