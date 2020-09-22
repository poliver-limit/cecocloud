/**
 * 
 */
package es.limit.cecocloud.marc.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marc.logic.api.dto.LlocFeina;
import es.limit.cecocloud.marc.persist.entity.LlocFeinaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus configuracio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class LlocFeinaEntityToDtoConverter extends AbstractEntityToDtoConverter<LlocFeinaEntity, LlocFeina> {

}