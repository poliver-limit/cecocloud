/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificableChild;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class Marcatge extends AbstractIdentificableChild<Long, Long> {

	@NotNull
	private Date data;
	@NotNull
	private Date dataActual;

}
