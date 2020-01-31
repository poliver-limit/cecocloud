/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Proveidor;
import es.limit.cecocloud.fact.logic.api.service.ProveidorService;
import es.limit.cecocloud.fact.persist.entity.ProveidorEntity;

/**
 * Implementació del servei de gestió de proveidors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProveidorServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Proveidor, ProveidorEntity, String> implements ProveidorService {

}
