/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecurs;
import es.limit.cecocloud.logic.api.service.FuncionalitatRecursService;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;

/**
 * Implementació del servei encarregat de gestionar relacions funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FuncionalitatRecursServiceImpl extends AbstractGenericServiceImpl<FuncionalitatRecurs, FuncionalitatRecursEntity, Long> implements FuncionalitatRecursService {

}
