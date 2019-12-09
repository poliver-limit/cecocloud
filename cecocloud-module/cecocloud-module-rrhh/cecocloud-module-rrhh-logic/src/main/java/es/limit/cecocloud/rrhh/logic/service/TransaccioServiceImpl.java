/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio.TransaccioPk;
import es.limit.cecocloud.rrhh.logic.api.service.TransaccioService;
import es.limit.cecocloud.rrhh.persist.entity.TransaccioEntity;

/**
 * Implementació del servei de gestió de transaccions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TransaccioServiceImpl extends AbstractGenericCompositePkServiceImpl<Transaccio, TransaccioEntity, TransaccioPk> implements TransaccioService {

	@Override
	protected TransaccioPk getPkFromDto(Transaccio dto) {
		return new TransaccioPk(
				dto.getIdentificador().getId(),
				dto.getCodi().toString());
	}


}
