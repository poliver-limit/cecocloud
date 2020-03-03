/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Producte;
import es.limit.cecocloud.fact.persist.entity.ProducteEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Producte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ProducteEntityToDtoConverter extends AbstractEntityToDtoConverter<ProducteEntity, Producte> {

}