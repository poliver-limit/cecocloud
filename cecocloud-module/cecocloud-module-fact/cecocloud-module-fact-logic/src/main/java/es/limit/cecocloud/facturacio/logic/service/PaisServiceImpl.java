/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Pais;
import es.limit.cecocloud.facturacio.logic.api.service.PaisService;
import es.limit.cecocloud.facturacio.persist.entity.PaisEntity;

/**
 * Implementació del servei de gestió de paisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PaisServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Pais, PaisEntity, String> implements PaisService {

}
