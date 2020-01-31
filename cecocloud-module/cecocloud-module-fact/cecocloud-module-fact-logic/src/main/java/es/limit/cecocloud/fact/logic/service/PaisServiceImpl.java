/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Pais;
import es.limit.cecocloud.fact.logic.api.service.PaisService;
import es.limit.cecocloud.fact.persist.entity.PaisEntity;

/**
 * Implementació del servei de gestió de paisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PaisServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Pais, PaisEntity, String> implements PaisService {

}
