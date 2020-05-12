/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.PuntVenda;
import es.limit.cecocloud.cita.persist.entity.PuntVendaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("citaPuntVendaEntityToDtoConverter")
public class PuntVendaEntityToDtoConverter extends AbstractEntityToDtoConverter<PuntVendaEntity, PuntVenda> {

}
