/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

import es.limit.cecocloud.logic.api.converter.ConvertedEnumInterface;

/**
 * DTO enumerat amb els possibles tipus d'avís a l'albarà de client.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.ArticleFamiliaAvisAlbaraClientEnumDto.NO_AVISAR
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
public enum ArticleFamiliaAvisAlbaraClientEnumDto implements ConvertedEnumInterface<String>{

	/** No Avisar = 0*/
	NO_AVISAR("0"),
	/** Si es mes de lo pressupostat = 1*/
	SI_ES_MES_DE_LO_PRESSUPOSTAT("1"),
	/** Si no es lo pressupostat = 2*/
	SI_NO_ES_LO_PRESSUPOSTAT("2");
	
	private final String dbValue;

	private ArticleFamiliaAvisAlbaraClientEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
	
}