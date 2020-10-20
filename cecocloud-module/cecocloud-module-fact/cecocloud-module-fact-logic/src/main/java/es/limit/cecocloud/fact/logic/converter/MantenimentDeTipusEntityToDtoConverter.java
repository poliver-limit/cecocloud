/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.MantenimentDeTipus;
import es.limit.cecocloud.fact.persist.entity.MantenimentDeTipusEntity;

/**
 * Conversor cap a DTO de les entitats de tipus MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factMantenimentDeTipusEntityToDtoConverter")
public class MantenimentDeTipusEntityToDtoConverter extends AbstractEntityToDtoConverter<MantenimentDeTipusEntity, MantenimentDeTipus> {

}