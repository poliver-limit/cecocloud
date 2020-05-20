/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Divisa;
import es.limit.cecocloud.ecom.persist.entity.DivisaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomDivisaEntityToDtoConverter")
public class DivisaEntityToDtoConverter extends AbstractEntityToDtoConverter<DivisaEntity, Divisa> {

}