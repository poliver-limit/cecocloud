package es.limit.cecocloud.fact.logic.api.converter;

import javax.persistence.AttributeConverter;

import es.limit.cecocloud.fact.logic.api.dto.enums.InversioTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;

//@Converter(autoApply = true)
public class InversioTipusConverter extends AbstractEnumConverter<InversioTipusEnumDto, String> implements AttributeConverter<InversioTipusEnumDto, String>{

	public InversioTipusConverter() {
		super(InversioTipusEnumDto.class);
	}
}
