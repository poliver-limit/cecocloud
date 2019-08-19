/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.annotations.RestapiResource;
import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import es.limit.cecocloud.logic.api.dto.util.GenericReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@RestapiResource(descriptionField = "nom")
public class Empresa extends AbstractIdentificable<Long> {

	@NotNull
	@Transient
	private GenericReference<Companyia, Long> companyia;
	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	@NotNull
	@Size(max = 4)
	private String codi;
	@NotNull
	@Size(max = 40)
	private String nom;
	@NotNull
	@Size(max = 12)
	private String nif;
	private boolean activa;

}
