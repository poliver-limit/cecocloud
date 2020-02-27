/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

public enum RegistreComercialMitjaEnumDto {
	
	WEB("W"),
	CERCADOR("B"),
	CONEGUT("K"),
	FIRA("F"),
	PUBLICITAT("P"),
	CONEIX_EMPRESA("C"),	
	VISITA_COMERCIAL("V"),
	REUNIO_DE_TREBALL("J"),
	FORMACIO("L"),
	ALTRES("O")
	;
	
	private final String dbValue;

	private RegistreComercialMitjaEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}
	
	public String toDbValue() {
		return dbValue;
	}
}