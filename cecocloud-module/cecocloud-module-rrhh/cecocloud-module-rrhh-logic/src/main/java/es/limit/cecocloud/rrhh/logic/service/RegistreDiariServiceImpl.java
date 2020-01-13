/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
//import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
//import es.limit.cecocloud.rrhh.logic.api.dto.Calendari.CalendariPk;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari.RegistreDiariPk;
import es.limit.cecocloud.rrhh.logic.api.service.RegistreDiariService;
import es.limit.cecocloud.rrhh.persist.entity.RegistreDiariEntity;

/**
 * Implementació del servei de gestió de registres diaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegistreDiariServiceImpl extends AbstractGenericCompositePkServiceImpl<RegistreDiari, RegistreDiariEntity, RegistreDiariPk> implements RegistreDiariService {

	@Override
	protected RegistreDiariPk getPkFromDto(RegistreDiari dto) {
//		CalendariPk pk = getPkFromSerializedId(
//				dto.getCalendari().getId(),
//				Calendari.class,
//				CalendariPk.class);
		return new RegistreDiariPk(
				dto.getIdentificador().getId(),
//				pk.getData(),
				dto.getCalendariData().getPk().getData()
//				dto.getOperari().getId()
				);
	}

}
