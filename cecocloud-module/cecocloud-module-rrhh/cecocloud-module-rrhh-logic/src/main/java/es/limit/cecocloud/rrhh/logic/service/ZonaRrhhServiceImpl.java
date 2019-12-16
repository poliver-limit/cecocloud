/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.ZonaRrhh;
import es.limit.cecocloud.rrhh.logic.api.dto.ZonaRrhh.ZonaRrhhPk;
import es.limit.cecocloud.rrhh.logic.api.service.ZonaRrhhService;
import es.limit.cecocloud.rrhh.persist.entity.ZonaRrhhEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaRrhhService")
public class ZonaRrhhServiceImpl extends AbstractGenericCompositePkServiceImpl<ZonaRrhh, ZonaRrhhEntity, ZonaRrhhPk> implements ZonaRrhhService {

	@Override
	protected ZonaRrhhPk getPkFromDto(ZonaRrhh dto) {
		return new ZonaRrhhPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
