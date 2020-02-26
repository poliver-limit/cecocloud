/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

public enum RegistreComercialTipusEnumDto {
	
	CRIDADA("C"),
	CORREU("M"),
	VISITA("V"),
	PRESENCIAL("P"),
	INTERMEDIARI("I")
	;
	
	private final String dbValue;

	private RegistreComercialTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}