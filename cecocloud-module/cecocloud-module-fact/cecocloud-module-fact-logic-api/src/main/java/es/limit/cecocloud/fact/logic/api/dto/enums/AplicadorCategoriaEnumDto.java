/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

/**
 * DTO enumerat amb les possibles categories de Aplicador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public enum AplicadorCategoriaEnumDto {

	
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
