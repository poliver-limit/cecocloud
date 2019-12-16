/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.service.HorariService;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;

/**
 * Implementació del servei de gestió de horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class HorariServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Horari, HorariEntity, String> implements HorariService {

}
