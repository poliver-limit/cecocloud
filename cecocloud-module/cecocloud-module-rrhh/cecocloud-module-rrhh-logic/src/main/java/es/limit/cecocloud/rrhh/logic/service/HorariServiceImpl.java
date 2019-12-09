/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari.HorariPk;
import es.limit.cecocloud.rrhh.logic.api.service.HorariService;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;

/**
 * Implementació del servei de gestió de horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class HorariServiceImpl extends AbstractGenericCompositePkServiceImpl<Horari, HorariEntity, HorariPk> implements HorariService {

	@Override
	protected HorariPk getPkFromDto(Horari dto) {
		return new HorariPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
