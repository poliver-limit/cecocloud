/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.persist.entity.CategoriaTraduccioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus CategoriaTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomCategoriaTraduccioEntityToDtoConverter")
public class CategoriaTraduccioEntityToDtoConverter extends AbstractEntityToDtoConverter<CategoriaTraduccioEntity, CategoriaTraduccio> {

}