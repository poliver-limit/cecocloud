/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum FormaPagamentEnumDto implements ConvertedEnumInterface<String> {
	
	COMPTAT("C"),	
	AJORNAMENT("P");
	
	private final String dbValue;

	private FormaPagamentEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}