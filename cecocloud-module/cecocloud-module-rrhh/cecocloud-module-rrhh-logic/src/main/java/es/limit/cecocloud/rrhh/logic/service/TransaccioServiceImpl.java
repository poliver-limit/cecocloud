/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
import es.limit.cecocloud.rrhh.logic.api.service.TransaccioService;
import es.limit.cecocloud.rrhh.persist.entity.TransaccioEntity;

/**
 * Implementació del servei de gestió de transaccions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TransaccioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Transaccio, TransaccioEntity, Integer> implements TransaccioService {

}
