/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Iva;
import es.limit.cecocloud.facturacio.persist.entity.IvaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IvaEntityToDtoConverter extends AbstractEntityToDtoConverter<IvaEntity, Iva> {

}