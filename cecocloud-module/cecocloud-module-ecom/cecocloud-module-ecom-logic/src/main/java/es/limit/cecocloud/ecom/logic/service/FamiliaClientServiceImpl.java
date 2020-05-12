/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.FamiliaClient;
import es.limit.cecocloud.ecom.logic.api.service.FamiliaClientService;
import es.limit.cecocloud.ecom.persist.entity.FamiliaClientEntity;

/**
 * Implementació del servei de gestió de FamiliaClient
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomFamiliaClientService")
public class FamiliaClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaClient, FamiliaClientEntity, String> implements FamiliaClientService {

}
