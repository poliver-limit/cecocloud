/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PaisNif;
import es.limit.cecocloud.fact.persist.entity.PaisNifEntity;

/**
 * Conversor cap a DTO de les entitats de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factPaisNifEntityToDtoConverter")
public class PaisNifEntityToDtoConverter extends AbstractEntityToDtoConverter<PaisNifEntity, PaisNif> {

}
