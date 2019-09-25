/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

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

	@NotNull
	@NotEmpty
	private String empresaIdentificadorCodi;
	@NotNull
	@NotEmpty
	private String empresaCodi;
	@NotNull
	@NotEmpty
	private String operariCodi;
	@NotNull
	private Date data;
	private Date dataCreacio;
	private Double latitud;
	private Double longitud;

}
