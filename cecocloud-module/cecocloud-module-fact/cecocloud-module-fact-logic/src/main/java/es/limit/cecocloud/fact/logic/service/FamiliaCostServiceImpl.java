/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.fact.logic.api.service.FamiliaCostService;
import es.limit.cecocloud.fact.persist.entity.FamiliaCostEntity;

/**
 * Implementació del servei de gestió de families cost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaCostServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaCost, FamiliaCostEntity, String> implements FamiliaCostService {

}
