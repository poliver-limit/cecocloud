/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus OperariRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("rrhhOperariEntityToDtoConverter")
public class OperariEntityToDtoConverter extends AbstractEntityToDtoConverter<OperariEntity, Operari> {

}