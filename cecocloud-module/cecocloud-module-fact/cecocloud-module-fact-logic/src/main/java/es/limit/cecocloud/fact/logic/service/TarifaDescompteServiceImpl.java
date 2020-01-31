/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TarifaDescompte;
import es.limit.cecocloud.fact.logic.api.service.TarifaDescompteService;
import es.limit.cecocloud.fact.persist.entity.TarifaDescompteEntity;

/**
 * Implementació del servei de gestió de tarifes descompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaDescompteServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TarifaDescompte, TarifaDescompteEntity, String> implements TarifaDescompteService {

}
