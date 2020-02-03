/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.fact.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus NaturalesaPagamentCobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class NaturalesaPagamentCobramentEntityToDtoConverter extends AbstractEntityToDtoConverter<NaturalesaPagamentCobramentEntity, NaturalesaPagamentCobrament> {

}