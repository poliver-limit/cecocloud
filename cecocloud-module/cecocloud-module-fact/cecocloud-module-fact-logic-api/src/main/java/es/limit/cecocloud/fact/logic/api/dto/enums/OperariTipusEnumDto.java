/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum OperariTipusEnumDto implements ConvertedEnumInterface<String>{

	RESPONSABLE("RES"),
	CAPGRUP("CGR"),
	ENCARREGAT("ENC"),
	ADMINISTRATIU("ADM");

	private final String dbValue;

	private OperariTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}

}
