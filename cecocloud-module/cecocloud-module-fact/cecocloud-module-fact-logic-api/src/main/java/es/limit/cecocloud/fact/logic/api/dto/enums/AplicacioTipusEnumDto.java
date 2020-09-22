/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum AplicacioTipusEnumDto implements ConvertedEnumInterface<Integer>{
	
	APL0(0),
	APL1(1),
	APL2(2),
	APL3(3),
	APL4(4),
	APL5(5),
	APL6(6);
	
	
	private final Integer dbValue;

	private AplicacioTipusEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
