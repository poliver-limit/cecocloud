package es.limit.cecocloud.fact.logic.api.converter;

import javax.persistence.AttributeConverter;

import es.limit.cecocloud.fact.logic.api.dto.enums.AlbaraClientProjecteTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;

/** 
 * Conversor per a l'enumerat AlbaraClientProjecteTipusEnum
 * A BBDD es desa com a String
 * 
 * Per tal de utilitzar-ho, a la entitat hibernate allà on es defineixi un atribut de tipus
 * TipusPersonaEnum a convertir, se li ha d'afegir la anotació:
 * 
 * @Convert(converter = AlbaraClientProjecteTipusConverter.class)
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
public class AlbaraClientProjecteTipusConverter extends AbstractEnumConverter<AlbaraClientProjecteTipusEnumDto, Integer> implements AttributeConverter<AlbaraClientProjecteTipusEnumDto, Integer>{

	public AlbaraClientProjecteTipusConverter() {
		super(AlbaraClientProjecteTipusEnumDto.class);
	}
}
