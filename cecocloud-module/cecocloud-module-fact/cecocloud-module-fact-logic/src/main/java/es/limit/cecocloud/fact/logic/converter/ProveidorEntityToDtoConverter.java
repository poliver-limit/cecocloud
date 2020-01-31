/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Proveidor;
import es.limit.cecocloud.fact.persist.entity.ProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProveidorEntityToDtoConverter extends AbstractEntityToDtoConverter<ProveidorEntity, Proveidor> {

}