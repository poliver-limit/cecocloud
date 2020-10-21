/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci;
import es.limit.cecocloud.fact.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.fact.logic.api.service.AreaNegociService;
import es.limit.cecocloud.fact.persist.entity.AreaNegociEntity;

/**
 * Implementació del servei de gestió de AreaNegoci.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AreaNegociServiceImpl extends AbstractGenericCompositePkServiceImpl<AreaNegoci, AreaNegociEntity, AreaNegociPk> implements AreaNegociService{

	@Override
	protected AreaNegociPk getPkFromDto(AreaNegoci dto) {
		return new AreaNegociPk(
				dto.getIdentificador().getId(),				
				dto.getEmpresa().getPk().getCodi(),
				dto.getCodi()
				);
	}
}
