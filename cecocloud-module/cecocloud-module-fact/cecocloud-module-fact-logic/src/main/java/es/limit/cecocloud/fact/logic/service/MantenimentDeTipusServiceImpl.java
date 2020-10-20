/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.MantenimentDeTipus;
import es.limit.cecocloud.fact.logic.api.service.MantenimentDeTipusService;
import es.limit.cecocloud.fact.persist.entity.MantenimentDeTipusEntity;

/**
 * Implementació del servei de gestió de MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factMantenimentDeTipusServiceImpl")
public class MantenimentDeTipusServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<MantenimentDeTipus, MantenimentDeTipusEntity, String> implements MantenimentDeTipusService {

}
