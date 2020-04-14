package es.limit.cecocloud.fact.logic.api.converter;

import javax.persistence.AttributeConverter;

import es.limit.cecocloud.fact.logic.api.dto.enums.ObraTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;

//@Converter(autoApply = true)
public class ObraTipusConverter extends AbstractEnumConverter<ObraTipusEnumDto, Integer> implements AttributeConverter<ObraTipusEnumDto, Integer> {

	public ObraTipusConverter() {
		super(ObraTipusEnumDto.class);
	}

}
