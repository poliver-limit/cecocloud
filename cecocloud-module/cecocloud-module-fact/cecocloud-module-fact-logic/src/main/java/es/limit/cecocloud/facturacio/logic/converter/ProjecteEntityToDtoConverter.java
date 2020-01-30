/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProjecteEntityToDtoConverter extends AbstractEntityToDtoConverter<ProjecteEntity, Projecte> {

}
