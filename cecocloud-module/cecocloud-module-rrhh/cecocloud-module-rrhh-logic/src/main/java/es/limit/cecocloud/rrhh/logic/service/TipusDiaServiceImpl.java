/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.rrhh.logic.api.service.TipusDiaService;
import es.limit.cecocloud.rrhh.persist.entity.TipusDiaEntity;

/**
 * Implementació del servei de gestió de tipus dies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusDiaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusDia, TipusDiaEntity, String> implements TipusDiaService {

}
