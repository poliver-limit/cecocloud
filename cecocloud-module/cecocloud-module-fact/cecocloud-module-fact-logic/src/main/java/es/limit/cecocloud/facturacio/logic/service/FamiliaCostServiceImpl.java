/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.facturacio.logic.api.service.FamiliaCostService;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaCostEntity;

/**
 * Implementació del servei de gestió de families cost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaCostServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaCost, FamiliaCostEntity, String> implements FamiliaCostService {

}
