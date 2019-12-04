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
 *    		enum.ArticleFamiliaTipusEnumDto.IMPORT
 *    
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum ArticleFamiliaTipusEnumDto {
	/** Material = M*/
	MATERIAL("M"),
	/** Ma d'obra = O*/
	MA_OBRA("O");
	
	private final String dbValue;

	private ArticleFamiliaTipusEnumDto(String dbValue) {
		this.dbValue = dbValue;
	}

	public String toDbValue() {
		return dbValue;
	}
}
