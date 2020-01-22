package es.limit.cecocloud.facturacio.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de projecte d'un albarà de client.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els
 * datatables, i en els selects, cal que es defineixi un missatge multiidioma al
 * fitxer messages.properties per a cada element de l'enumerat, de la forma:
 * enum.ClasseEnumerat.CodiElementEnumerat ex.
 * enum.AlbaraClientProjecteTipusEnumDto.PRESSUPOST
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

public enum AlbaraClientProjecteTipusEnumDto {

	/** Pressupost = 1 */
	PRESSUPOST(1),
	/** Administracií = 2 */
	ADMINISTRACIO(2),
	/** Medició = 3 */
	MEDICIO(3);

	private final Integer dbValue;

	private AlbaraClientProjecteTipusEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
