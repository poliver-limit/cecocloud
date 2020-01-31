/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.facturacio.logic.api.service.ClientAdresaService;
import es.limit.cecocloud.facturacio.persist.entity.ClientAdresaEntity;

/**
 * Implementació del servei de gestió de ClientAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ClientAdresaServiceImpl extends AbstractGenericCompositePkServiceImpl<ClientAdresa, ClientAdresaEntity, ClientAdresaPk> implements ClientAdresaService{

	@Override
	protected ClientAdresaPk getPkFromDto(ClientAdresa dto) {
		return new ClientAdresaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi(),
				dto.getClient().getId());
	}
}
