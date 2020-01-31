/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusComissio;
import es.limit.cecocloud.fact.persist.entity.TipusComissioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusComissioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusComissioEntity, TipusComissio> {

}