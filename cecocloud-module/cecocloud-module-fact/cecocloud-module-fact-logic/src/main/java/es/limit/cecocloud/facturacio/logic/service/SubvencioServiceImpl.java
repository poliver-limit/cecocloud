/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Subvencio;
import es.limit.cecocloud.facturacio.logic.api.service.SubvencioService;
import es.limit.cecocloud.facturacio.persist.entity.SubvencioEntity;

/**
 * Implementació del servei de gestió de subvencions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubvencioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Subvencio, SubvencioEntity, String> implements SubvencioService {

}
