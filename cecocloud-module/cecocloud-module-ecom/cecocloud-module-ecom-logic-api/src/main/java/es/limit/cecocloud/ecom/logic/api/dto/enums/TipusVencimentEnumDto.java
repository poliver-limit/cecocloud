/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum TipusVencimentEnumDto implements ConvertedEnumInterface<String> {
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