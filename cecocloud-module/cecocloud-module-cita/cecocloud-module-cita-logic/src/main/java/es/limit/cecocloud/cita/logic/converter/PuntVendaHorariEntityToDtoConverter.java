/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.cita.persist.entity.PuntVendaHorariEntity;

/**
 * Conversor cap a DTO de les entitats que relacionen un punt de venda amb
 * un horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PuntVendaHorariEntityToDtoConverter extends AbstractEntityToDtoConverter<PuntVendaHorariEntity, PuntVendaHorari> {

}
