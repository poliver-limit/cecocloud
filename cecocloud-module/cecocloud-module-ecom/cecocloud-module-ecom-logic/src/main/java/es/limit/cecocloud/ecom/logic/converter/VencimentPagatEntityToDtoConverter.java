/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat;
import es.limit.cecocloud.ecom.persist.entity.VencimentPagatEntity;

/**
 * Conversor cap a DTO de les entitats de tipus VencimentPagat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomVencimentPagatEntityToDtoConverter")
public class VencimentPagatEntityToDtoConverter extends AbstractEntityToDtoConverter<VencimentPagatEntity, VencimentPagat> {

}