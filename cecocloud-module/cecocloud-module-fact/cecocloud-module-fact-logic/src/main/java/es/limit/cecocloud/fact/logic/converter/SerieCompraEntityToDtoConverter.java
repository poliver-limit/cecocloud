/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.SerieCompra;
import es.limit.cecocloud.fact.persist.entity.SerieCompraEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SerieCompraEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieCompraEntity, SerieCompra> {

}