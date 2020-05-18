/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda;
import es.limit.cecocloud.ecom.persist.entity.SerieVendaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomSerieVendaEntityToDtoConverter")
public class SerieVendaEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieVendaEntity, SerieVenda> {

}