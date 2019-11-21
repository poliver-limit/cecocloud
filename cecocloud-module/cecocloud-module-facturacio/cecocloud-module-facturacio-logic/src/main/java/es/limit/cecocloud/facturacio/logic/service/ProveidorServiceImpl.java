/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor;
import es.limit.cecocloud.facturacio.logic.api.dto.Proveidor.ProveidorPk;
import es.limit.cecocloud.facturacio.logic.api.service.ProveidorService;
import es.limit.cecocloud.facturacio.persist.entity.ProveidorEntity;

/**
 * Implementació del servei de gestió de proveidors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProveidorServiceImpl extends AbstractGenericCompositePkServiceImpl<Proveidor, ProveidorEntity, ProveidorPk> implements ProveidorService {

	@Override
	protected ProveidorPk getPkFromDto(Proveidor dto) {
		return new ProveidorPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
