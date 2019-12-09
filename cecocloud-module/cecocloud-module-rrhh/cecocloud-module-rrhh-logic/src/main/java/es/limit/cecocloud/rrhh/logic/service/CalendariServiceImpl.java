/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import es.limit.cecocloud.rrhh.logic.api.service.CalendariService;
import es.limit.cecocloud.rrhh.persist.entity.CalendariEntity;

/**
 * Implementació del servei de gestió de calendaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CalendariServiceImpl extends AbstractGenericCompositePkServiceImpl<Calendari, CalendariEntity, CalendariPk> implements CalendariService {

	@Override
	protected CalendariPk getPkFromDto(Calendari dto) {
		return new CalendariPk(
				dto.getIdentificador().getId(),
				dto.getData().toString()
				);
	}


}
