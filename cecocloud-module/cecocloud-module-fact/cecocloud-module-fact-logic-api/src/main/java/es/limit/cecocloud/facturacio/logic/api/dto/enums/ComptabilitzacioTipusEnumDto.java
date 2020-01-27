/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto.enums;

public enum ComptabilitzacioTipusEnumDto {
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
