/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Divisa;
import es.limit.cecocloud.facturacio.logic.api.service.DivisaService;
import es.limit.cecocloud.facturacio.persist.entity.DivisaEntity;

/**
 * Implementació del servei de gestió de divises.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DivisaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Divisa, DivisaEntity, String> implements DivisaService {

}
