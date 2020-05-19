/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Provincia;
import es.limit.cecocloud.ecom.persist.entity.ProvinciaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Provincia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomProvinciaEntityToDtoConverter")
public class ProvinciaEntityToDtoConverter extends AbstractEntityToDtoConverter<ProvinciaEntity, Provincia> {

}