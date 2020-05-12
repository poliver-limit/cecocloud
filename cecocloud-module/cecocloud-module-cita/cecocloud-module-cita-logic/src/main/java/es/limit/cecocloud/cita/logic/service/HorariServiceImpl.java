/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.service.HorariService;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;
import es.limit.cecocloud.fact.logic.service.AbstractAmbIdentificadorICodiServiceImpl;

/**
 * Implementació del servei de gestió d'horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("citaHorariServiceImpl")
public class HorariServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Horari, HorariEntity, String> implements HorariService {

}
