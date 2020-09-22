/**
 * 
 */
package es.limit.cecocloud.marc.logic.api.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Informació dels acumulats dels marcatges (valors en segons)
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter
@Setter
@AllArgsConstructor
public class AcumulatInfo {

	private BigDecimal acumulatAny;
	private BigDecimal acumulatMes;
	private BigDecimal acumulatDia;

}
