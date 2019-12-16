/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Subvencio;
import es.limit.cecocloud.facturacio.persist.entity.SubvencioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Subvencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SubvencioEntityToDtoConverter extends AbstractEntityToDtoConverter<SubvencioEntity, Subvencio> {

}