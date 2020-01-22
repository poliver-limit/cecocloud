package es.limit.cecocloud.facturacio.logic.api.dto.enums;

/**
 * DTO enumerat amb els possibles tipus de NIF.
 * 
 * Multiidioma
 * --------------------------------------------------------------------------------------
 * Si es vol que els valors de l'enumerat es mostrin en multiidioma a els
 * datatables, i en els selects, cal que es defineixi un missatge multiidioma al
 * fitxer messages.properties per a cada element de l'enumerat, de la forma:
 * enum.ClasseEnumerat.CodiElementEnumerat ex. enum.TipusNifEnumDto.NIF
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

public enum TipusNifEnumDto {

	/** Nif = 1 */
	NIF(1),
	/** Nif operador intracomunitari = 2 */
	NIF_OPERADOR_INTRACOMUNITARI(2),
	/** Passaport = 3 */
	PASSAPORT(3),
	/** Document oficial expedit país = 4 */
	DOCUMENT_OFICIAL_EXPEDIT_PAIS(4),
	/** Certificat residència fiscal = 5 */
	CERTIFICAT_RESIDENCIA_FISCAL(5),
	/** Altre document = 6 */
	ALTRE_DOCUMENT(6);

	private final Integer dbValue;

	private TipusNifEnumDto(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

}
