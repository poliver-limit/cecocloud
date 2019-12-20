/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Idioma;
import es.limit.cecocloud.facturacio.logic.api.service.IdiomaService;
import es.limit.cecocloud.facturacio.persist.entity.IdiomaEntity;

/**
 * Implementació del servei de gestió de idiomes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IdiomaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Idioma, IdiomaEntity, String> implements IdiomaService {

}
