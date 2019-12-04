/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto.enums;

public enum TipusRegimEnumDto {
	/** General = 1*/
	GENERAL(1),
	/** intracomunitari = 2*/
	INTRACOMUNITARI_O_INV_SUBJ_PASSIU(2),
	/** agrari = 3*/
	AGRARI(3);
	
	private final Integer dbValue;

	private TipusRegimEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}
}