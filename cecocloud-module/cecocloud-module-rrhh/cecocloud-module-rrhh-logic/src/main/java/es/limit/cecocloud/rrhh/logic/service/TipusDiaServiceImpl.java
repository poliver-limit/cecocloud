/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusDia.TipusDiaPk;
import es.limit.cecocloud.rrhh.logic.api.service.TipusDiaService;
import es.limit.cecocloud.rrhh.persist.entity.TipusDiaEntity;

/**
 * Implementació del servei de gestió de tipus dies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusDiaServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusDia, TipusDiaEntity, TipusDiaPk> implements TipusDiaService {

	@Override
	protected TipusDiaPk getPkFromDto(TipusDia dto) {
		return new TipusDiaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
