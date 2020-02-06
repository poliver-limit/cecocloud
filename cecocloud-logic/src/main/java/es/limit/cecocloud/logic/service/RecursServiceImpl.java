/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Recurs;
import es.limit.cecocloud.logic.api.service.RecursService;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Implementació del servei encarregat de gestionar recursos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RecursServiceImpl extends AbstractGenericServiceImpl<Recurs, RecursEntity, Long> implements RecursService {

}
