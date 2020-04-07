/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment;
import es.limit.cecocloud.fact.persist.entity.ProveidorVencimentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ProveidorVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProveidorVencimentEntityToDtoConverter extends AbstractEntityToDtoConverter<ProveidorVencimentEntity, ProveidorVenciment> {

}