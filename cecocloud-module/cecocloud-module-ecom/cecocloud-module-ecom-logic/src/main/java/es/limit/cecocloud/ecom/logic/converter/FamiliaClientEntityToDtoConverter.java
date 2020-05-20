/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.persist.entity.FamiliaClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FamiliaClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomFamiliaClientEntityToDtoConverter")
public class FamiliaClientEntityToDtoConverter extends AbstractEntityToDtoConverter<FamiliaClientEntity, FamiliaClient> {

}