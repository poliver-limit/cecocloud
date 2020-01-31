/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.ClasseRetencio;
import es.limit.cecocloud.fact.logic.api.service.ClasseRetencioService;
import es.limit.cecocloud.fact.persist.entity.ClasseRetencioEntity;

/**
 * Implementació del servei de gestió de ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ClasseRetencioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ClasseRetencio, ClasseRetencioEntity, String>
		implements ClasseRetencioService {

}
