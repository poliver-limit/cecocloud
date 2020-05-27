/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia;
import es.limit.cecocloud.ecom.persist.entity.AlbaraLiniaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomAlbaraLiniaEntityToDtoConverter")
public class AlbaraLiniaEntityToDtoConverter extends AbstractEntityToDtoConverter<AlbaraLiniaEntity, AlbaraLinia> {

}