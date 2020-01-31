/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Magatzem;
import es.limit.cecocloud.fact.logic.api.service.MagatzemService;
import es.limit.cecocloud.fact.persist.entity.MagatzemEntity;

/**
 * Implementació del servei de gestió de magatzems.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class MagatzemServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Magatzem, MagatzemEntity, String> implements MagatzemService {

}
