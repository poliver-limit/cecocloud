/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda;
import es.limit.cecocloud.ecom.persist.entity.PuntVendaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PuntVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomPuntVendaEntityToDtoConverter")
public class PuntVendaEntityToDtoConverter extends AbstractEntityToDtoConverter<PuntVendaEntity, PuntVenda> {

}