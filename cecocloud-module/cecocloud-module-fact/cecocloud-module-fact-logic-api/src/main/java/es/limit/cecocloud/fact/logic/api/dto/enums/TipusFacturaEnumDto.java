/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de factura.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els
 * datatables, i en els selects, cal que es defineixi un missatge multiidioma al
 * fitxer messages.properties per a cada element de l'enumerat, de la forma:
 * enum.ClasseEnumerat.CodiElementEnumerat ex. enum.TipusFacturaEnumDto.GENERAL
 * 
 * Conversió
 * --------------------------------------------------------------------------------------
 * Aquest enumerat està preparat per a ser convertit al obtenir-lo de, i
 * desar-lo a BBDD.
 * 
 * Per tal de fer-lo convertible, implementa la interfície
 * ConvertedEnumInterface, indicant el tipus de dada a BBDD.
 * 
 * Per implementar la interfície, cada element de l'enumerat reb un paràmetre
 * que correspon al valor que ha de tenir a BBDD, i implementa la funció
 * toDbValue, que retorna el valor d'un enumerat a BBDD
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public enum TipusFacturaEnumDto {

	/** General = 1 */
	GENERAL(1),
	/** Subclient = 2 */
	SUBCLIENT(2),
	/** Domicili Comercial = 3 */
	DOMICILI_COMERCIAL(3),
	/** Referència albarà = 4 */
	REFERENCIA_ALBARA(4),
	/** Individual albarà = 5 */
	INDIVIDUAL_ALBARA(5);

	private final Integer dbValue;

	private TipusFacturaEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
