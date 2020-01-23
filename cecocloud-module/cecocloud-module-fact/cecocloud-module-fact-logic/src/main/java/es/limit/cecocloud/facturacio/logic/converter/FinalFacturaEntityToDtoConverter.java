package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.FinalFactura;
import es.limit.cecocloud.facturacio.persist.entity.FinalFacturaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus de FinalFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FinalFacturaEntityToDtoConverter extends AbstractEntityToDtoConverter<FinalFacturaEntity, FinalFactura> {

}

