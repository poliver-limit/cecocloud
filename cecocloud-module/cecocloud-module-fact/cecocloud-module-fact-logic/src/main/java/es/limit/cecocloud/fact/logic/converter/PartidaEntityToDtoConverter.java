/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Partida;
import es.limit.cecocloud.fact.persist.entity.PartidaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Partida.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PartidaEntityToDtoConverter extends AbstractEntityToDtoConverter<PartidaEntity, Partida> {

}