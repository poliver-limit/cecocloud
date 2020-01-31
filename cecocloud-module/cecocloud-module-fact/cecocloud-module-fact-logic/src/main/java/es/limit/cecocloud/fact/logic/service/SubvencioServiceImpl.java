/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Subvencio;
import es.limit.cecocloud.fact.logic.api.service.SubvencioService;
import es.limit.cecocloud.fact.persist.entity.SubvencioEntity;

/**
 * Implementació del servei de gestió de subvencions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubvencioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Subvencio, SubvencioEntity, String> implements SubvencioService {

}
