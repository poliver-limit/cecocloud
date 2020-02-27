/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

/**
 * DTO enumerat amb els possibles tipus de ?.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.TipusComptabilitatClientEnumDto.ALTA
 * 
 * Conversió
 * --------------------------------------------------------------------------------------
 * Aquest enumerat està preparat per a ser convertit al obtenir-lo de, i desar-lo a BBDD.
 * 
 * Per tal de fer-lo convertible, implementa la interfície ConvertedEnumInterface, indicant 
 * el tipus de dada a BBDD.
 * 
 * Per implementar la interfície, cada element de l'enumerat reb un paràmetre que correspon
 * al valor que ha de tenir a BBDD, i implementa la funció toDbValue, que retorna el valor
 * d'un enumerat a BBDD
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum TipusComptabilitatClientEnumDto implements ConvertedEnumInterface<String> {
	/** no tractar = 0*/
	NO_TRACTAR("0"),
	/** alta = 2*/
	ALTA("1"),
	/** alta i modificacio = 2*/
	ALTA_MODIFICACIO("2"),
	/** tractar en traspassos factura = 4*/
	TRACTAR_EN_TRASPASSOS_FACTURA("3");
	
	private final String dbValue;

	private TipusComptabilitatClientEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
}