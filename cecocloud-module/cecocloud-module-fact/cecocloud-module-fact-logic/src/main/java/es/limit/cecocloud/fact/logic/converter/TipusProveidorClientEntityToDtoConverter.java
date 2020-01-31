/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusProveidorClient;
import es.limit.cecocloud.fact.persist.entity.TipusProveidorClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusProveidorClientEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusProveidorClientEntity, TipusProveidorClient> {

}