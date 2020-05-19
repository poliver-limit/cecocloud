/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.PaisNif;
import es.limit.cecocloud.ecom.persist.entity.PaisNifEntity;

/**
 * Conversor cap a DTO de les entitats de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomPaisNifEntityToDtoConverter")
public class PaisNifEntityToDtoConverter extends AbstractEntityToDtoConverter<PaisNifEntity, PaisNif> {

}
