package es.limit.cecocloud.fact.logic.api.converter;

import javax.persistence.AttributeConverter;

import es.limit.cecocloud.fact.logic.api.dto.enums.TipusGestioEnumDto;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;

/** 
 * Conversor per a l'enumerat TipusExecucioEnum
 * A BBDD es desa com a String
 * 
 * Per tal de utilitzar-ho, a la entitat hibernate allà on es defineixi un atribut de tipus
 * TipusExecucioEnum a convertir, se li ha d'afegir la anotació:
 * 
 * @Convert(converter = TipusExecucioConverter.class)
 * 
 * És necessari que tot conversor d'enumerats per hibernate:
 *   - extengui de AbstractEnumConverter, indicant l'enumerat i el tipus d'aquest a BBDD
 *   - implementi AttributeConverter, indicant l'enumerat i el tipus d'aquest a BBDD
 *   - defineixi un contructor per defecte que cridi al super, indicant la classe de 
 *     l'enumerat que converteix
 *     
 * @author Limit Tecnologies
 *
 */
//@Converter(autoApply = true)
public class TipusGestioConverter extends AbstractEnumConverter<TipusGestioEnumDto, Integer> implements AttributeConverter<TipusGestioEnumDto, Integer> {
	
	public TipusGestioConverter() {
		super(TipusGestioEnumDto.class);
	}
}
