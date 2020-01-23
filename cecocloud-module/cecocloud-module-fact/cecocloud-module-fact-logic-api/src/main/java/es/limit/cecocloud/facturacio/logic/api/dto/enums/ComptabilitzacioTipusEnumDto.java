/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de tarifes.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.ComptabilitzacioTipusEnumDto.S
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
public enum ComptabilitzacioTipusEnumDto {
	/** Comptabilitzar = S*/
	COMPTABILITZAR("S"),
	/** Nomes venciment = N*/
	NOMES_VENCIMENT("N"),
	/** Comptabilitzar + Venciment = A*/
	COMPTABILITZAR_MES_VENCIMENT("A");
	
	private final String dbValue;

	private ComptabilitzacioTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	/**
	 * Devuelve la enumeracion cuyo valor corresponde con el parametro introducido
	 * @param value, valor de la comptabilitzacio buscada
	 * @return ComptabilitzacioTipusEnumDto
	 */
	public static ComptabilitzacioTipusEnumDto parseValue(String value) {
		if (value != null) {
			for (ComptabilitzacioTipusEnumDto comptabilitzacio: ComptabilitzacioTipusEnumDto.values()) {
				if (comptabilitzacio.toDbValue().equals(value)) {
					return comptabilitzacio;
				}
			}
		}
		return null;
	}

	public String toDbValue() {
		return dbValue;
	}

}
