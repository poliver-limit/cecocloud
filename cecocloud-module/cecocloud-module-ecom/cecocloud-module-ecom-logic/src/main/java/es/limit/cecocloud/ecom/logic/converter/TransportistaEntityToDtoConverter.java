/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Transportista;
import es.limit.cecocloud.ecom.persist.entity.TransportistaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Transportista.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTransportistaEntityToDtoConverter")
public class TransportistaEntityToDtoConverter extends AbstractEntityToDtoConverter<TransportistaEntity, Transportista> {

}