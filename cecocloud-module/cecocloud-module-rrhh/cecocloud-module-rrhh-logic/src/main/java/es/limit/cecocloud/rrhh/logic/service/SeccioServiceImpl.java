/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.rrhh.logic.api.service.SeccioService;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Implementació del servei de gestió de seccions grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioServiceImpl extends AbstractGenericCompositePkServiceImpl<Seccio, SeccioEntity, SeccioPk> implements SeccioService {

	@Override
	protected SeccioPk getPkFromDto(Seccio dto) {
		return new SeccioPk(
				dto.getIdentificador().getId(),
				dto.getCodi(),
				dto.getEmpresa().getId());
	}


}
