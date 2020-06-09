/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta;
import es.limit.cecocloud.ecom.persist.entity.BestretaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Bestreta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomBestretaEntityToDtoConverter")
public class BestretaEntityToDtoConverter extends AbstractEntityToDtoConverter<BestretaEntity, Bestreta> {

}