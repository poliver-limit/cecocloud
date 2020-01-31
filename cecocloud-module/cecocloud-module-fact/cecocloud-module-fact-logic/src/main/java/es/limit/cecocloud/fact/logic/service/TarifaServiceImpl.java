/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Tarifa;
import es.limit.cecocloud.fact.logic.api.service.TarifaService;
import es.limit.cecocloud.fact.persist.entity.TarifaEntity;

/**
 * Implementació del servei de gestió de tarifes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Tarifa, TarifaEntity, String> implements TarifaService {

}
