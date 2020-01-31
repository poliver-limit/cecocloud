/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.SituacioInicial;
import es.limit.cecocloud.fact.persist.entity.SituacioInicialEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SituacioInicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SituacioInicialEntityToDtoConverter extends AbstractEntityToDtoConverter<SituacioInicialEntity, SituacioInicial> {

}