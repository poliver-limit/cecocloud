package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

public enum ComptabilitzacioTipusEnumDto implements ConvertedEnumInterface<String> {
	/** Comptabilitzar = S */
	COMPTABILITZAR("S"),
	/** Nomes venciment = N */
	NOMES_VENCIMENT("N"),
	/** Comptabilitzar + Venciment = A */
	COMPTABILITZAR_MES_VENCIMENT("A");

	private final String dbValue;

	private ComptabilitzacioTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}

}

