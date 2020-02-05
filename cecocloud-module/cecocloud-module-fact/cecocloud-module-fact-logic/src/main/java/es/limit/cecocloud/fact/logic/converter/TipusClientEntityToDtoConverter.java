/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.TipusClient;
import es.limit.cecocloud.fact.persist.entity.TipusClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusClientEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusClientEntity, TipusClient> {

}