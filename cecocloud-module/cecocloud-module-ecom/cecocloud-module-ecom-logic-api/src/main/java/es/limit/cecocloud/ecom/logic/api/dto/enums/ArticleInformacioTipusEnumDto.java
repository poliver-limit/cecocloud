/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum ArticleInformacioTipusEnumDto implements ConvertedEnumInterface<Integer> {
	
	ARXIU(1),
	URL(2),
	IMATGE(3);


	private final Integer dbValue;

	private ArticleInformacioTipusEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
