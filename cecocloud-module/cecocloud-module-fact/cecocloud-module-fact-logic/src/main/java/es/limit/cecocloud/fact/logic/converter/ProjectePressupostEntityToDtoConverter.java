/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost;
import es.limit.cecocloud.fact.persist.entity.ProjectePressupostEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ProjectePressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProjectePressupostEntityToDtoConverter extends AbstractEntityToDtoConverter<ProjectePressupostEntity, ProjectePressupost> {

}