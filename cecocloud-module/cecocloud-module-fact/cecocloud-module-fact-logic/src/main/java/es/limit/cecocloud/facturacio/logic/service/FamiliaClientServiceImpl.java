package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.facturacio.logic.api.service.FamiliaClientService;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaClientEntity;

/**
 * Implementació del servei de gestió de families clients.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaClient, FamiliaClientEntity, String>
		implements FamiliaClientService {

}