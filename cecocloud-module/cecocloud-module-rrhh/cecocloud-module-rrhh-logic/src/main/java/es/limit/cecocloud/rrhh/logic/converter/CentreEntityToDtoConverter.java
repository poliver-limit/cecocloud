/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Centre;
import es.limit.cecocloud.rrhh.persist.entity.CentreEntity;

/**
 * Conversor cap a DTO de les entitats de tipus torn.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CentreEntityToDtoConverter extends AbstractEntityToDtoConverter<CentreEntity, Centre> {

}
