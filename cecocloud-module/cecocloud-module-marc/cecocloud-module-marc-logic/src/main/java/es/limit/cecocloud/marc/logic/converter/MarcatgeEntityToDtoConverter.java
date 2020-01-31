/**
 * 
 */
package es.limit.cecocloud.marc.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marc.logic.api.dto.Marcatge;
import es.limit.cecocloud.marc.persist.entity.MarcatgeEntity;

/**
 * Conversor cap a DTO de les entitats de tipus marcatge.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class MarcatgeEntityToDtoConverter extends AbstractEntityToDtoConverter<MarcatgeEntity, Marcatge> {

}