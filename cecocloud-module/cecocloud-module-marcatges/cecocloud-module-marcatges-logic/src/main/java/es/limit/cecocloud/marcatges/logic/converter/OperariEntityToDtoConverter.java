/**
 * 
 */
package es.limit.cecocloud.marcatges.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.marcatges.logic.api.dto.Operari;
import es.limit.cecocloud.marcatges.persist.entity.OperariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class OperariEntityToDtoConverter extends AbstractEntityToDtoConverter<OperariEntity, Operari> {

}