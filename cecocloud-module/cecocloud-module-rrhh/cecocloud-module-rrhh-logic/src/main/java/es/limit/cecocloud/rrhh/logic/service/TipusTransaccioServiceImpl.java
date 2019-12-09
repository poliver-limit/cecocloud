/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio;
import es.limit.cecocloud.rrhh.logic.api.dto.TipusTransaccio.TipusTransaccioPk;
import es.limit.cecocloud.rrhh.logic.api.service.TipusTransaccioService;
import es.limit.cecocloud.rrhh.persist.entity.TipusTransaccioEntity;

/**
 * Implementació del servei de gestió de tipus transaccions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusTransaccioServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusTransaccio, TipusTransaccioEntity, TipusTransaccioPk> implements TipusTransaccioService {

	@Override
	protected TipusTransaccioPk getPkFromDto(TipusTransaccio dto) {
		return new TipusTransaccioPk(
				dto.getIdentificador().getId(),
				dto.getCodi().toString());
	}


}
