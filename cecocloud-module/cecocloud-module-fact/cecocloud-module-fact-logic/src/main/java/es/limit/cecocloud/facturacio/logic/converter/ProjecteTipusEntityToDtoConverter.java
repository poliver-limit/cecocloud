package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.ProjecteTipus;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteTipusEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProjecteTipusEntityToDtoConverter extends AbstractEntityToDtoConverter<ProjecteTipusEntity, ProjecteTipus> {

}
