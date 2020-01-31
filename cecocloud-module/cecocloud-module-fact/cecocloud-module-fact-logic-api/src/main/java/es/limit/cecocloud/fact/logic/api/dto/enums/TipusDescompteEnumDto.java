/**
 * 
 */
package es.limit.cecocloud.fact.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de descompte.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els
 * datatables, i en els selects, cal que es defineixi un missatge multiidioma al
 * fitxer messages.properties per a cada element de l'enumerat, de la forma:
 * enum.ClasseEnumerat.CodiElementEnumerat ex.
 * enum.TipusDescompteEnumDto.PRIMER_DESCOMPTE
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

public enum TipusDescompteEnumDto {

	/** Primer descompte = 1 */
	PRIMER_DESCOMPTE(1),
	/** Segon descompte = 2 */
	SEGON_DESCOMPTE(2),
	/** Tercer descompte = 3 */
	TERCER_DESCOMPTE(3),
	/** Quart descompte = 4 */
	QUART_DESCOMPTE(4),
	/** Quint descompte = 5 */
	QUINT_DESCOMPTE(5);

	private final Integer dbValue;

	private TipusDescompteEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
