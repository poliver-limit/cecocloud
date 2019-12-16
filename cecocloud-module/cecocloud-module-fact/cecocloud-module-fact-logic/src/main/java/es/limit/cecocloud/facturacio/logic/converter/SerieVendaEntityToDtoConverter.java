/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.SerieVenda;
import es.limit.cecocloud.facturacio.persist.entity.SerieVendaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SerieVendaEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieVendaEntity, SerieVenda> {

}