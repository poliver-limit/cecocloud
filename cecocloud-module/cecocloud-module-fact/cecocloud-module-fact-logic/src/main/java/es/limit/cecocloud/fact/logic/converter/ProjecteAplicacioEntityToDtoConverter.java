/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio;
import es.limit.cecocloud.fact.persist.entity.ProjecteAplicacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ProjecteAplicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProjecteAplicacioEntityToDtoConverter extends AbstractEntityToDtoConverter<ProjecteAplicacioEntity, ProjecteAplicacio> {

}