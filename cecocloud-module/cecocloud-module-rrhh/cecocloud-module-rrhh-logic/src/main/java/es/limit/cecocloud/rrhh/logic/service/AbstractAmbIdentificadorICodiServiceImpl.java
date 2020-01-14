/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.base.boot.persist.entity.AbstractCompositePkEntity;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.logic.api.dto.IdentificableWithIdentificadorAndCodi;

/**
 * Entitat de base de dades abstracta amb identificador i codi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public abstract class AbstractAmbIdentificadorICodiServiceImpl<D extends IdentificableWithIdentificadorAndCodi<ID>, E extends AbstractCompositePkEntity<D, WithIdentificadorAndCodiPk<ID>>, ID extends Serializable> extends AbstractGenericCompositePkServiceImpl<D, E, WithIdentificadorAndCodiPk<ID>> {

	@Override
	protected WithIdentificadorAndCodiPk<ID> getPkFromDto(D dto) {
		return new WithIdentificadorAndCodiPk<ID>(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}

}
