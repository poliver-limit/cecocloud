/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona.ZonaPk;
import es.limit.cecocloud.rrhh.logic.api.service.ZonaService;
import es.limit.cecocloud.rrhh.persist.entity.ZonaEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaRrhhService")
public class ZonaServiceImpl extends AbstractGenericCompositePkServiceImpl<Zona, ZonaEntity, ZonaPk> implements ZonaService {

	@Override
	protected ZonaPk getPkFromDto(Zona dto) {
		return new ZonaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
