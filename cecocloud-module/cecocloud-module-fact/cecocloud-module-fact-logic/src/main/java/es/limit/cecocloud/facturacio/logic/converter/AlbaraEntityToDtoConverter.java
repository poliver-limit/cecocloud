/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Albara;
import es.limit.cecocloud.facturacio.persist.entity.AlbaraEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Albara.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AlbaraEntityToDtoConverter extends AbstractEntityToDtoConverter<AlbaraEntity, Albara> {

}