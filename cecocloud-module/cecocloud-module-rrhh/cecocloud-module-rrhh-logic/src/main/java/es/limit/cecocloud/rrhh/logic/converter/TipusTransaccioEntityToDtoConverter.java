/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import es.limit.cecocloud.rrhh.persist.entity.TipusTransaccioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class TipusTransaccioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusTransaccioEntity, TipusTransaccio> {

}