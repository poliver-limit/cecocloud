/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioComercial;
import es.limit.cecocloud.facturacio.persist.entity.SituacioComercialEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SituacioComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SituacioComercialEntityToDtoConverter extends AbstractEntityToDtoConverter<SituacioComercialEntity, SituacioComercial> {

}