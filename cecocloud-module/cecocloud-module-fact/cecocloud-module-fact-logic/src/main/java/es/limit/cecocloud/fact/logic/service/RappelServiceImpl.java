/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Rappel;
import es.limit.cecocloud.fact.logic.api.service.RappelService;
import es.limit.cecocloud.fact.persist.entity.RappelEntity;

/**
 * Implementació del servei de gestió de rappels.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RappelServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Rappel, RappelEntity, String>
		implements RappelService {

}