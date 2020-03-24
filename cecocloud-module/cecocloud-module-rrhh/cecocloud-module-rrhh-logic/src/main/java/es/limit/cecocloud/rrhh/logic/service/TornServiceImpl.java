/*
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Torn;
import es.limit.cecocloud.rrhh.logic.api.service.TornService;
import es.limit.cecocloud.rrhh.persist.entity.TornEntity;

/**
 * Implementació del servei de gestió de torns.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TornServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Torn, TornEntity, String> implements TornService{

}
