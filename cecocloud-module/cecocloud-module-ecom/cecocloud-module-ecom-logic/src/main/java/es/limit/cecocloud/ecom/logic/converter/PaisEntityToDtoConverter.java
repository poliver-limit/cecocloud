/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Pais;
import es.limit.cecocloud.ecom.persist.entity.PaisEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomPaisEntityToDtoConverter")
public class PaisEntityToDtoConverter extends AbstractEntityToDtoConverter<PaisEntity, Pais> {

}