/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioComercial;
import es.limit.cecocloud.facturacio.logic.api.dto.SituacioComercial.SituacioComercialPk;
import es.limit.cecocloud.facturacio.logic.api.service.SituacioComercialService;
import es.limit.cecocloud.facturacio.persist.entity.SituacioComercialEntity;

/**
 * Implementació del servei de gestió de situacions comercials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SituacioComercialServiceImpl extends AbstractGenericCompositePkServiceImpl<SituacioComercial, SituacioComercialEntity, SituacioComercialPk> implements SituacioComercialService {

	@Override
	protected SituacioComercialPk getPkFromDto(SituacioComercial dto) {
		return new SituacioComercialPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
