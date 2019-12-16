/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import es.limit.cecocloud.rrhh.logic.api.service.TipusTransaccioService;
import es.limit.cecocloud.rrhh.persist.entity.TipusTransaccioEntity;

/**
 * Implementació del servei de gestió de tipus transaccions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusTransaccioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusTransaccio, TipusTransaccioEntity, Integer> implements TipusTransaccioService {

}
