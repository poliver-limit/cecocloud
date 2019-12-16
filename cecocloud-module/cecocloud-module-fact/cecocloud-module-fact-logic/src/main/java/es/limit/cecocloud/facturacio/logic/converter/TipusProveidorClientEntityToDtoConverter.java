/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusProveidorClient;
import es.limit.cecocloud.facturacio.persist.entity.TipusProveidorClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusProveidorClientEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusProveidorClientEntity, TipusProveidorClient> {

}