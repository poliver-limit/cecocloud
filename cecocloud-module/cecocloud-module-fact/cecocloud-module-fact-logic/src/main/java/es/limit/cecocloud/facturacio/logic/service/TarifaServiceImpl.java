/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Tarifa;
import es.limit.cecocloud.facturacio.logic.api.service.TarifaService;
import es.limit.cecocloud.facturacio.persist.entity.TarifaEntity;

/**
 * Implementació del servei de gestió de tarifes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Tarifa, TarifaEntity, String> implements TarifaService {

}
