/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Magatzem;
import es.limit.cecocloud.ecom.persist.entity.MagatzemEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomMagatzemEntityToDtoConverter")
public class MagatzemEntityToDtoConverter extends AbstractEntityToDtoConverter<MagatzemEntity, Magatzem> {

}