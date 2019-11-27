/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de família d'un article.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els datatables, i 
 * en els selects, cal que es defineixi un missatge multiidioma al fitxer messages.properties
 * per a cada element de l'enumerat, de la forma:  enum.ClasseEnumerat.CodiElementEnumerat
 *    ex. 
 *    		enum.ArticleFamiliaTipusServeiEnumDto.IMPORT
 *    
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum ArticleFamiliaTipusServeiEnumDto {
	/** OBRA/SERVEI = 1*/
	OBRA_SERVEI("1"),
	/** TALLER = 2*/
	TALLER("2");
	
	private final String dbValue;

	private ArticleFamiliaTipusServeiEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
}
