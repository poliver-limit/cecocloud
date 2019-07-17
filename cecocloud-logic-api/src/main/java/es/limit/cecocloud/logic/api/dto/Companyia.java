/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificable;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Companyia extends AbstractIdentificable<Long> {

	@NotNull
	@Size(max = 30)
	private String codi;
	@NotNull
	@Size(max = 30)
	private String nom;

}
