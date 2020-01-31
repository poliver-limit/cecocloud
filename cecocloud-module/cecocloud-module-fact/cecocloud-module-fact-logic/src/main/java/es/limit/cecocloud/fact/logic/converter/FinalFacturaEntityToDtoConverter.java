/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.FinalFactura;
import es.limit.cecocloud.fact.persist.entity.FinalFacturaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus de FinalFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FinalFacturaEntityToDtoConverter extends AbstractEntityToDtoConverter<FinalFacturaEntity, FinalFactura> {

}

