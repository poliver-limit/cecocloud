/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.limit.cecocloud.logic.api.dto.util.AbstractIdentificableChildChild;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una relació usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class UsuariEmpresa extends AbstractIdentificableChildChild<Long, Long, Long> {

	@NotNull
	@Size(max = 6)
	private String operariCodi;
	@NotNull
	private Date dataInici;
	@NotNull
	private Date dataFi;

}
