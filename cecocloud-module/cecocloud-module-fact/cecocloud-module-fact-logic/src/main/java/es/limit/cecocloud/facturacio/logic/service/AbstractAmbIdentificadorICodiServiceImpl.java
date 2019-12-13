/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableAmbIdentificadorICodi;

/**
 * Implementació del servei de gestió de articles familia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public abstract class AbstractAmbIdentificadorICodiServiceImpl<D extends IdentificableAmbIdentificadorICodi<ID>, E extends AbstractCompositePkEntity<D, AmbIdentificadorICodiPk<ID>>, ID extends Serializable> extends AbstractGenericCompositePkServiceImpl<D, E, AmbIdentificadorICodiPk<ID>> {

	@Override
	protected AmbIdentificadorICodiPk<ID> getPkFromDto(D dto) {
		return new AmbIdentificadorICodiPk<ID>(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}

}
