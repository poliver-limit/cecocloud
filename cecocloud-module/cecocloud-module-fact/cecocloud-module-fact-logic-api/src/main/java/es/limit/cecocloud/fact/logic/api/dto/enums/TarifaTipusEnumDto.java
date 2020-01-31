/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de tarifes.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.TarifaTipusEnumDto.C
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
public enum TarifaTipusEnumDto {
	/** Tarifa % sobre cost = C*/
	TARIFA_GENERAL_SOBRE_COST("C"),
	/** Tarifa % sobre pvp = G*/
	TARIFA_GENERAL_SOBRE_PVP("G"),
	/** Tarifa particular % sobre cost = P*/
	TARIFA_PARTICULAR_SOBRE_COST("P"),
	/** Tarifa particular % sobre pvp = Q*/
	TARIFA_PARTICULAR_SOBRE_PVP("Q");
	
	private final String dbValue;

	private TarifaTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
}