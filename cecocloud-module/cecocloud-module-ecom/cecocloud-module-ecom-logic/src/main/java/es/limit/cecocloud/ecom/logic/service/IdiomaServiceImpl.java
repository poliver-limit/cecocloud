/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.service.IdiomaService;
import es.limit.cecocloud.ecom.persist.entity.IdiomaEntity;

/**
 * Implementació del servei de gestió de idiomes
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomIdiomaService")
public class IdiomaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Idioma, IdiomaEntity, String> implements IdiomaService {

}
