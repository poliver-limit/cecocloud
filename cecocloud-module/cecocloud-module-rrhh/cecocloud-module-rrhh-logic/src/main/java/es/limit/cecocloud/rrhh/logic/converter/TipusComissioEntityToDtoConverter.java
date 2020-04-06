/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusComissio;
import es.limit.cecocloud.rrhh.persist.entity.TipusComissioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("rrhhTipusComissioEntityToDtoConverter")
public class TipusComissioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusComissioEntity, TipusComissio> {

}
