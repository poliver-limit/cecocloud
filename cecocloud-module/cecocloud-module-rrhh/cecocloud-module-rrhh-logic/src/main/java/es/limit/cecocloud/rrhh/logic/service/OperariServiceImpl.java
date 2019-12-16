/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Operari;
import es.limit.cecocloud.rrhh.logic.api.service.OperariService;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;

/**
 * Implementació del servei de gestió de operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("OperariRrhhService")
public class OperariServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Operari, OperariEntity, String> implements OperariService {

}
