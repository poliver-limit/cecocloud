/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'una consulta de marcatges des de mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MarcatgeMobilConsulta {

	@NotNull
	private String identificadorCodi;
	@NotNull
	private String empresaCodi;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;

}
