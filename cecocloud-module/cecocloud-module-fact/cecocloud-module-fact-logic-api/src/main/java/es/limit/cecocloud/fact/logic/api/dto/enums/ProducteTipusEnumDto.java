/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum ProducteTipusEnumDto implements ConvertedEnumInterface<String>{

	PRODUCTE("1"),
	APLICACIO("2");

	private final String dbValue;

	private ProducteTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}

}