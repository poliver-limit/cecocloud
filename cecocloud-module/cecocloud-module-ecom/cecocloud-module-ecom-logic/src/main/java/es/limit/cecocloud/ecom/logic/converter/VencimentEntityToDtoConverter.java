/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment;
import es.limit.cecocloud.ecom.persist.entity.VencimentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomVencimentEntityToDtoConverter")
public class VencimentEntityToDtoConverter extends AbstractEntityToDtoConverter<VencimentEntity, Venciment> {

}