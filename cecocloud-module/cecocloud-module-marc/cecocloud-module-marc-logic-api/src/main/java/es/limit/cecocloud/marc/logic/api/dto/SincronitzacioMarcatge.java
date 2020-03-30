/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge per a enviar cap a CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatge {

	private Long id;
	@NotNull
	@NotEmpty
	private String empresaCodi;
	@NotNull
	@NotEmpty
	private String operariCodi;
	@NotNull
	private Date data;
	private Date dataCreacio;
	private BigDecimal latitud;
	private BigDecimal longitud;

}
