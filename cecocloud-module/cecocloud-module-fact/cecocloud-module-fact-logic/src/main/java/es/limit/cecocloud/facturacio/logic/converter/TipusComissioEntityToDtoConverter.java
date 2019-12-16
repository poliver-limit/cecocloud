/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusComissio;
import es.limit.cecocloud.facturacio.persist.entity.TipusComissioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusComissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusComissioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusComissioEntity, TipusComissio> {

}