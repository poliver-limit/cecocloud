/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieCompra;
import es.limit.cecocloud.facturacio.persist.entity.SerieCompraEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SerieCompraEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieCompraEntity, SerieCompra> {

}