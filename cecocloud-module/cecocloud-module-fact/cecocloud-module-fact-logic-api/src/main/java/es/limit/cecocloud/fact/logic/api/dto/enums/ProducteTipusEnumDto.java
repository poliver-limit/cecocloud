/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum ProducteTipusEnumDto implements ConvertedEnumInterface<String>{
	
	APLICACIO("A"),
	PRODUCTE("P")	
	;
	
	private final String dbValue;

	private ProducteTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}