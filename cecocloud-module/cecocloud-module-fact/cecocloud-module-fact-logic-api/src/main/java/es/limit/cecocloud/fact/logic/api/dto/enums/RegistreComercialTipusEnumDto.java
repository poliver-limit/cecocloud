/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum RegistreComercialTipusEnumDto implements ConvertedEnumInterface<String>{
	
	CRIDADA("C"),
	CORREU("M"),
	VISITA_PRESENCIAL("V")	
	;
	
	private final String dbValue;

	private RegistreComercialTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}