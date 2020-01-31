/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

public enum TipusVencimentEnumDto {
	/** import fixe = 1*/
	IMPORT_FIXE("1"),
	/** import porcentual = 2*/
	IMPORT_PORCENTUAL("2"),
	/** pagament a plaços = 3*/
	PAGAMENT_TERMINIS("3"),
	/** escalat = 4*/
	ESCALAT("4");
	
	private final String dbValue;

	private TipusVencimentEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}