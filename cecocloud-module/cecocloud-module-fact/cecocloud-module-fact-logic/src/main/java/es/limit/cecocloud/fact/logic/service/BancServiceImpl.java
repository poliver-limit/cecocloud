/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Banc;
import es.limit.cecocloud.fact.logic.api.service.BancService;
import es.limit.cecocloud.fact.persist.entity.BancEntity;

/**
 * Implementació del servei de gestió de Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class BancServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Banc, BancEntity, Integer> implements BancService {

}
