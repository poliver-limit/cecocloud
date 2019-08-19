/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.logic.api.dto.Operari;
import es.limit.cecocloud.logic.api.service.OperariService;
import es.limit.cecocloud.persist.entity.OperariEntity;

/**
 * Implementació del servei encarregat de gestionar operaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class OperariServiceImpl extends AbstractGenericServiceImpl<Operari, OperariEntity, Long> implements OperariService {

}
