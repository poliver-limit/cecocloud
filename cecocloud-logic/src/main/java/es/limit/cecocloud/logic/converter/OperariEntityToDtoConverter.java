/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class OperariEntityToDtoConverter extends AbstractEntityToDtoConverter<OperariEntity, Operari> {

}