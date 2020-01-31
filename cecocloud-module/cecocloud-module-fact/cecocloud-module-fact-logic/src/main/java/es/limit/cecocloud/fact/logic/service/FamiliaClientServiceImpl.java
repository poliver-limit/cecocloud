/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.fact.logic.api.service.FamiliaClientService;
import es.limit.cecocloud.fact.persist.entity.FamiliaClientEntity;

/**
 * Implementació del servei de gestió de families clients.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaClient, FamiliaClientEntity, String>
		implements FamiliaClientService {

}