/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval.HorariIntervalPk;
import es.limit.cecocloud.cita.logic.api.service.HorariIntervalService;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;

/**
 * Implementació del servei de gestió d'intervals horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class HorariIntervalServiceImpl extends AbstractGenericCompositePkServiceImpl<HorariInterval, HorariIntervalEntity, HorariIntervalPk> implements HorariIntervalService {

	@Override
	protected HorariIntervalPk getPkFromDto(HorariInterval dto) {
		return new HorariIntervalPk(
				dto.getIdentificador().getId(),
				dto.getHorari().getPk().getCodi(),
				0);
	}

}
