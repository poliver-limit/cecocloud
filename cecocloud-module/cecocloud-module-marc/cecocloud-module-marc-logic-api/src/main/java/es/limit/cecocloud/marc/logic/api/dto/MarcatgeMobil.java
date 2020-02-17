/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
public class MarcatgeMobil {

	@NotNull
	private String identificadorCodi;
	@NotNull
	private String empresaCodi;
	@NotNull
	private Date data;
	private Date dataCreacio;
	private Double latitud;
	private Double longitud;

}
