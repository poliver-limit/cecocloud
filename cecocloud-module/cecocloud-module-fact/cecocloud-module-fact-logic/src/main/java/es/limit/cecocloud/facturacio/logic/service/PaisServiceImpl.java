/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Pais;
import es.limit.cecocloud.facturacio.logic.api.dto.Pais.PaisPk;
import es.limit.cecocloud.facturacio.logic.api.service.PaisService;
import es.limit.cecocloud.facturacio.persist.entity.PaisEntity;

/**
 * Implementació del servei de gestió de paisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PaisServiceImpl extends AbstractGenericCompositePkServiceImpl<Pais, PaisEntity, PaisPk> implements PaisService {

	@Override
	protected PaisPk getPkFromDto(Pais dto) {
		return new PaisPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}

}
