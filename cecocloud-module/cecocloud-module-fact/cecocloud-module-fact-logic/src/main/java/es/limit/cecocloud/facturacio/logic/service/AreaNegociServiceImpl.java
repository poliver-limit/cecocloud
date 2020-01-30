/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci;
import es.limit.cecocloud.facturacio.logic.api.dto.AreaNegoci.AreaNegociPk;
import es.limit.cecocloud.facturacio.logic.api.service.AreaNegociService;
import es.limit.cecocloud.facturacio.persist.entity.AreaNegociEntity;

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
				dto.getCodi(),
				dto.getEmpresa().getId());
	}
}
