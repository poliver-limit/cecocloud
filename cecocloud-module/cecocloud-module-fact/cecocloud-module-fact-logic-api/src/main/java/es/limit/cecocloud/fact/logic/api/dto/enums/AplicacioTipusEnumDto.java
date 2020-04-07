/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum AplicacioTipusEnumDto implements ConvertedEnumInterface<Integer>{
	
	APL1(0),
	APL2(1),
	APL3(2);
	
	private final Integer dbValue;

	private AplicacioTipusEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
