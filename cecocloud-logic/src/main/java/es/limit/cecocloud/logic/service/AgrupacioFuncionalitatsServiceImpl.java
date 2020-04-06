/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.AgrupacioFuncionalitat;
import es.limit.cecocloud.logic.api.service.AgrupacioFuncionalitatsService;
import es.limit.cecocloud.persist.entity.AgrupacioFuncionalitatEntity;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AgrupacioFuncionalitatsServiceImpl extends AbstractGenericServiceImpl<AgrupacioFuncionalitat, AgrupacioFuncionalitatEntity, Long> implements AgrupacioFuncionalitatsService {

}
