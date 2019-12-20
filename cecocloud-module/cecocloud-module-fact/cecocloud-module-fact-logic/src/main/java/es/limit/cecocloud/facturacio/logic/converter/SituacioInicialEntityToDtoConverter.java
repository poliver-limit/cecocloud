/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioInicial;
import es.limit.cecocloud.facturacio.persist.entity.SituacioInicialEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SituacioInicial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SituacioInicialEntityToDtoConverter extends AbstractEntityToDtoConverter<SituacioInicialEntity, SituacioInicial> {

}