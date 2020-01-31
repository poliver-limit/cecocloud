/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.fact.logic.api.service.TipusVencimentService;
import es.limit.cecocloud.fact.persist.entity.TipusVencimentEntity;

/**
 * Implementació del servei de gestió de tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusVencimentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusVenciment, TipusVencimentEntity, String> implements TipusVencimentService {

}
