/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.MantenimentDeTipus;
import es.limit.cecocloud.rrhh.logic.api.service.MantenimentDeTipusService;
import es.limit.cecocloud.rrhh.persist.entity.MantenimentDeTipusEntity;

/**
 * Implementació del servei de gestió de mantenimentsDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MantenimentDeTipusServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<MantenimentDeTipus, MantenimentDeTipusEntity, String>
		implements MantenimentDeTipusService {

}
