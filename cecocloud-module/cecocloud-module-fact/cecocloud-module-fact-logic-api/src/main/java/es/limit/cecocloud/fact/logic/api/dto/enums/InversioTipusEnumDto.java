/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum InversioTipusEnumDto implements ConvertedEnumInterface<String>{

	NO_SUJETO_INVERSION("N"),
	PROMOTOR("P"),
	CONTRATISTA("C"),
	SUBCONTRATISTA("S"),
	ESBORRAR_DE_AQUI("1");

	private final String dbValue;

	private InversioTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}

}
