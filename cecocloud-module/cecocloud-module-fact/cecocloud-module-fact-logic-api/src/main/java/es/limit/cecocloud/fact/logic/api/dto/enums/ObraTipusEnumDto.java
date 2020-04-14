/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum ObraTipusEnumDto implements ConvertedEnumInterface<Integer> {

	URBANIZACION_TERRENOS(1),
	CONTRUCCION_EDIFICACIONES(2),
	REHABILITACION_EDIFICACIONES(3),
	OTROS(4);

	private final Integer dbValue;

	private ObraTipusEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
