/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.RecursGrup.RecursGrupPk;
import es.limit.cecocloud.rrhh.logic.api.service.RecursGrupService;
import es.limit.cecocloud.rrhh.persist.entity.RecursGrupEntity;

/**
 * Implementació del servei de gestió de recursos grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RecursGrupServiceImpl extends AbstractGenericCompositePkServiceImpl<RecursGrup, RecursGrupEntity, RecursGrupPk> implements RecursGrupService {

	@Override
	protected RecursGrupPk getPkFromDto(RecursGrup dto) {
		return new RecursGrupPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
