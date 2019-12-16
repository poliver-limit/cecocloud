/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.logic.api.service.RegimService;
import es.limit.cecocloud.rrhh.persist.entity.RegimEntity;

/**
 * Implementació del servei de gestió de regims.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegimServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Regim, RegimEntity, String> implements RegimService {

}
