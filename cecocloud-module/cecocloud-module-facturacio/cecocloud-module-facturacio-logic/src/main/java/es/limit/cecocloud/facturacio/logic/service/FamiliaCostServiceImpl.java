/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaCost.FamiliaCostPk;
import es.limit.cecocloud.facturacio.logic.api.service.FamiliaCostService;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaCostEntity;

/**
 * Implementació del servei de gestió de families cost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaCostServiceImpl extends AbstractGenericCompositePkServiceImpl<FamiliaCost, FamiliaCostEntity, FamiliaCostPk> implements FamiliaCostService {

	@Override
	protected FamiliaCostPk getPkFromDto(FamiliaCost dto) {
		return new FamiliaCostPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
