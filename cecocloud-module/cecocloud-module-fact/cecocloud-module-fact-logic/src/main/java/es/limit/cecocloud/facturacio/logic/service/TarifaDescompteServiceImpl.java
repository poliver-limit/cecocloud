/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.TarifaDescompte;
import es.limit.cecocloud.facturacio.logic.api.service.TarifaDescompteService;
import es.limit.cecocloud.facturacio.persist.entity.TarifaDescompteEntity;

/**
 * Implementació del servei de gestió de tarifes descompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaDescompteServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TarifaDescompte, TarifaDescompteEntity, String> implements TarifaDescompteService {

}
