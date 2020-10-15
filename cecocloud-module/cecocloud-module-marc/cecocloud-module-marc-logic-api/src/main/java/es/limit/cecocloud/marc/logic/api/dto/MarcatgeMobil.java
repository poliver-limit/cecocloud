/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import es.limit.cecocloud.marc.logic.api.validation.MarcatgeMobilData;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació d'un marcatge per a l'app mòbil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@MarcatgeMobilData
public class MarcatgeMobil {

	@NotNull
	private String identificadorCodi;
	@NotNull
	private String empresaCodi;
	@NotNull
	private Date data;
	private Date dataCreacio;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private BigDecimal precisio;
	private boolean offline;
	private boolean llocFeinaFora;
	private boolean validat;
	private BigDecimal intervalDuracio;
	private boolean intervalObert;
	private boolean intervalFinal;

}
