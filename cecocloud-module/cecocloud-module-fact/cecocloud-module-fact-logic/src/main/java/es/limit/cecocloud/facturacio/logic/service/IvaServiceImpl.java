/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Iva;
import es.limit.cecocloud.facturacio.logic.api.dto.Iva.IvaPk;
import es.limit.cecocloud.facturacio.logic.api.service.IvaService;
import es.limit.cecocloud.facturacio.persist.entity.IvaEntity;

/**
 * Implementació del servei de gestió de Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IvaServiceImpl extends AbstractGenericCompositePkServiceImpl<Iva, IvaEntity, IvaPk> implements IvaService {

	@Override
	protected IvaPk getPkFromDto(Iva dto) {
		return new IvaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
