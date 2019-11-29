/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusProveidorClient;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusProveidorClient.TipusProveidorClientPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusProveidorClientService;
import es.limit.cecocloud.facturacio.persist.entity.TipusProveidorClientEntity;

/**
 * Implementació del servei de gestió de tipus proveidor client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusProveidorClientServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusProveidorClient, TipusProveidorClientEntity, TipusProveidorClientPk> implements TipusProveidorClientService {

	@Override
	protected TipusProveidorClientPk getPkFromDto(TipusProveidorClient dto) {
		return new TipusProveidorClientPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
