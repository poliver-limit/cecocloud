/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusVenciment.TipusVencimentPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusVencimentService;
import es.limit.cecocloud.facturacio.persist.entity.TipusVencimentEntity;

/**
 * Implementació del servei de gestió de tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusVencimentServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusVenciment, TipusVencimentEntity, TipusVencimentPk> implements TipusVencimentService {

	@Override
	protected TipusVencimentPk getPkFromDto(TipusVenciment dto) {
		return new TipusVencimentPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
