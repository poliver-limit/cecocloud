/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.ecom.persist.entity.FamiliaProveidorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FamiliaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomFamiliaProveidorEntityToDtoConverter")
public class FamiliaProveidorEntityToDtoConverter extends AbstractEntityToDtoConverter<FamiliaProveidorEntity, FamiliaProveidor> {

}