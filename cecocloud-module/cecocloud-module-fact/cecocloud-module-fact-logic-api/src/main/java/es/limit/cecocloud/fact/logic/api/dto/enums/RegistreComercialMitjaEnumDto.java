/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

public enum RegistreComercialMitjaEnumDto {
	
	TIPUS1("1"),
	TIPUS2("2"),
	TIPUS3("3"),
	TIPUS4("4")	
	;
	
	private final String dbValue;

	private RegistreComercialMitjaEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}