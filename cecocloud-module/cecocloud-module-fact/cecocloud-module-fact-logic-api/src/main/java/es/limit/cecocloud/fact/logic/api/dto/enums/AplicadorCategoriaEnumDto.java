/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

/**
 * DTO enumerat amb les possibles categories de Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public enum AplicadorCategoriaEnumDto implements ConvertedEnumInterface<String> {
	
	BASICO("B"),	
	CUALIFICADO("C"),
	FUMIGADOR("F"),
	PILOTO("P"),
	OTROS("O");

	private final String dbValue;

	private AplicadorCategoriaEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}

}
