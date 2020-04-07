/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor;
import es.limit.cecocloud.fact.logic.api.service.TarifaProveidorService;
import es.limit.cecocloud.fact.persist.entity.TarifaProveidorEntity;

/**
 * Implementació del servei de gestió de divises.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaProveidorServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TarifaProveidor, TarifaProveidorEntity, String> implements TarifaProveidorService {

}
