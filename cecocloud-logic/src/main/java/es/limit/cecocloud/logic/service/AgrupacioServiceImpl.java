/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Agrupacio;
import es.limit.cecocloud.logic.api.service.AgrupacioService;
import es.limit.cecocloud.persist.entity.AgrupacioEntity;

/**
 * Implementació del servei encarregat de gestionar agrupacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AgrupacioServiceImpl extends AbstractGenericServiceImpl<Agrupacio, AgrupacioEntity, Long> implements AgrupacioService {

}
