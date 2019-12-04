/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaProveidor.FamiliaProveidorPk;
import es.limit.cecocloud.facturacio.logic.api.service.FamiliaProveidorService;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaProveidorEntity;

/**
 * Implementació del servei de gestió de Families Proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FamiliaProveidorServiceImpl extends AbstractGenericCompositePkServiceImpl<FamiliaProveidor, FamiliaProveidorEntity, FamiliaProveidorPk> implements FamiliaProveidorService {

	@Override
	protected FamiliaProveidorPk getPkFromDto(FamiliaProveidor dto) {
		return new FamiliaProveidorPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
