/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.dto.Zona.ZonaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ZonaService;
import es.limit.cecocloud.facturacio.persist.entity.ZonaEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaFactService")
public class ZonaServiceImpl extends AbstractGenericCompositePkServiceImpl<Zona, ZonaEntity, ZonaPk> implements ZonaService {

	@Override
	protected ZonaPk getPkFromDto(Zona dto) {
		return new ZonaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
