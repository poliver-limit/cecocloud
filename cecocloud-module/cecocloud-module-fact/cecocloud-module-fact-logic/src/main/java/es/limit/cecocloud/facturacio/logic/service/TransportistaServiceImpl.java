/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista;
import es.limit.cecocloud.facturacio.logic.api.dto.Transportista.TransportistaPk;
import es.limit.cecocloud.facturacio.logic.api.service.TransportistaService;
import es.limit.cecocloud.facturacio.persist.entity.TransportistaEntity;

/**
 * Implementació del servei de gestió de transportistes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TransportistaServiceImpl extends AbstractGenericCompositePkServiceImpl<Transportista, TransportistaEntity, TransportistaPk> implements TransportistaService {

	@Override
	protected TransportistaPk getPkFromDto(Transportista dto) {
		return new TransportistaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
