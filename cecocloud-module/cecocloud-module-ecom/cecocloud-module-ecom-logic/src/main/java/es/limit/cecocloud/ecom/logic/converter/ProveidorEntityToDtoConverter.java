/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Proveidor;
import es.limit.cecocloud.ecom.persist.entity.ProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomProveidorEntityToDtoConverter")
public class ProveidorEntityToDtoConverter extends AbstractEntityToDtoConverter<ProveidorEntity, Proveidor> {

}