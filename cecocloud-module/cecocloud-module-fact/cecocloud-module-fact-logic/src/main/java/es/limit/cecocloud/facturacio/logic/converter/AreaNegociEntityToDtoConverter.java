package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci;
import es.limit.cecocloud.facturacio.persist.entity.AreaNegociEntity;

/**
 * Conversor cap a DTO de les entitats de tipus AreaNegoci.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AreaNegociEntityToDtoConverter extends AbstractEntityToDtoConverter<AreaNegociEntity, AreaNegoci> {

}
