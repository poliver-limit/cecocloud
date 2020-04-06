package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.CodiPostal;
import es.limit.cecocloud.rrhh.persist.entity.CodiPostalEntity;

/**
 * Conversor cap a DTO de les entitats de tipus CodiPostal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CodiPostalEntityToDtoConverter extends AbstractEntityToDtoConverter<CodiPostalEntity, CodiPostal> {

}
