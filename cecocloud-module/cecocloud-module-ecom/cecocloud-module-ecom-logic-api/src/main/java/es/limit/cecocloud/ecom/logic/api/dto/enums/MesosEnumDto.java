/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum MesosEnumDto implements ConvertedEnumInterface<String> {
	/** Gener = 1*/
	GENER("1"),
	/** Febrer = 2*/
	FEBRER("2"),
	/** Març = 3*/
	MARÇ("3"),
	/** Abril = 4*/
	ABRIL("4"),
	/** Maig = 5*/
	MAIG("5"),
	/** Juny = 6*/
	JUNY("6"),
	/** Juliol =7*/
	JULIOL("7"),
	/** Agost = 8*/
	AGOST("8"),
	/** Setembre = 9*/
	SETEMBRE("9"),
	/** Octubre = 10*/
	OCTUBRE("10"),
	/** Novembre = 11*/
	NOVEMBRE("11"),
	/** Desembre = 12*/
	DESEMBRE("12");
	
	private final String dbValue;

	private MesosEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}