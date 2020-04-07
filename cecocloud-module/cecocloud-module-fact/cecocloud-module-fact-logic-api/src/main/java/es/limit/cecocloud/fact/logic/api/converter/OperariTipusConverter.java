package es.limit.cecocloud.fact.logic.api.converter;

import javax.persistence.AttributeConverter;

import es.limit.cecocloud.fact.logic.api.dto.enums.OperariTipusEnumDto;
import es.limit.cecocloud.logic.api.converter.AbstractEnumConverter;

//@Converter(autoApply = true)
public class OperariTipusConverter extends AbstractEnumConverter<OperariTipusEnumDto, String> implements AttributeConverter<OperariTipusEnumDto, String>{

	public OperariTipusConverter() {
		super(OperariTipusEnumDto.class);
	}
}
