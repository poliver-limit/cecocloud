package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.ClasseRetencio;
import es.limit.cecocloud.facturacio.logic.api.service.ClasseRetencioService;
import es.limit.cecocloud.facturacio.persist.entity.ClasseRetencioEntity;

/**
 * Implementació del servei de gestió de ClasseRetencio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ClasseRetencioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<ClasseRetencio, ClasseRetencioEntity, String>
		implements ClasseRetencioService {

}
