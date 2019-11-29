/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto.enums;

/**
 * DTO enumerat amb les possibles valoracions de inventari.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.ValoracioInventariTraspasEnumDto.PMCG
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
 * @author sion
 *
 */
public enum ValoracioInventariTraspasEnum {
	/**Precio medio coste global = 1*/
	PREU_MITJA_COST_GLOBAL("1"),
	/**Ultimo precio de coste = 2*/
	ULTIM_PREU_DE_COST("2"),
	/**Precio medio coste existencia = 3*/
	PREU_MITJA_COST_EXISTENCIA("3"),
	/**Precio compra teorico del articulo = 4*/
	PREU_COMPRA_TEORIC_DE_ARTICLE("4"),
	/**Precio coste teorico del articulo= 5*/
	PREU_COST_TEORIC_DE_ARTICLE("5");
	
	private final String dbValue;

	private ValoracioInventariTraspasEnum(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
}
