/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum PressupostEstatEnumDto implements ConvertedEnumInterface<String> {
	
	PENDENT("P"),
	ACCEPTAT("A"),
	TANCAT("C"),
	AJORNAT("Z");
	
	private final String dbValue;

	private PressupostEstatEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}