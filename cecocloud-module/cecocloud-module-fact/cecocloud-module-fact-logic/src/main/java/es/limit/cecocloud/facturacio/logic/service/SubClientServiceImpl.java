package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.SubClient;
import es.limit.cecocloud.facturacio.logic.api.dto.SubClient.SubClientPk;
import es.limit.cecocloud.facturacio.logic.api.service.SubClientService;
import es.limit.cecocloud.facturacio.persist.entity.SubClientEntity;

/**
 * Implementació del servei de gestió de SubClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubClientServiceImpl extends AbstractGenericCompositePkServiceImpl<SubClient, SubClientEntity, SubClientPk> implements SubClientService{

	@Override
	protected SubClientPk getPkFromDto(SubClient dto) {
		return new SubClientPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getClient().getId());
	}
}
