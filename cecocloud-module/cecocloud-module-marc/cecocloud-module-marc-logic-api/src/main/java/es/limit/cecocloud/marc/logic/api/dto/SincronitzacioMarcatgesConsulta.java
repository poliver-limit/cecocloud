/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació per a consultar els marcatges des de CECOGEST.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class SincronitzacioMarcatgesConsulta {

	@NotNull
	@Size(max = 4)
	private String identificadorCodi;
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataInici;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataFi;

}
