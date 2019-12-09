/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim.RegimPk;
import es.limit.cecocloud.rrhh.logic.api.service.RegimService;
import es.limit.cecocloud.rrhh.persist.entity.RegimEntity;

/**
 * Implementació del servei de gestió de regims.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegimServiceImpl extends AbstractGenericCompositePkServiceImpl<Regim, RegimEntity, RegimPk> implements RegimService {

	@Override
	protected RegimPk getPkFromDto(Regim dto) {
		return new RegimPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
