/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor;
import es.limit.cecocloud.fact.persist.entity.ProjecteTarifaProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ProjecteTarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProjecteTarifaProveidorEntityToDtoConverter extends AbstractEntityToDtoConverter<ProjecteTarifaProveidorEntity, ProjecteTarifaProveidor> {

}