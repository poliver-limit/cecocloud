/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.ecom.persist.entity.PressupostLiniaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomPressupostLiniaEntityToDtoConverter")
public class PressupostLiniaEntityToDtoConverter extends AbstractEntityToDtoConverter<PressupostLiniaEntity, PressupostLinia> {

}