/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Vehicle;
import es.limit.cecocloud.ecom.logic.api.dto.Vehicle.VehiclePk;
import es.limit.cecocloud.ecom.logic.api.service.VehicleService;
import es.limit.cecocloud.ecom.persist.entity.VehicleEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;


/**
 * Implementació del servei de gestió de articles traduccio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomVehicleService")
public class VehicleServiceImpl extends AbstractGenericCompositePkServiceImpl<Vehicle, VehicleEntity, VehiclePk> implements VehicleService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected VehiclePk getPkFromDto(Vehicle dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new VehiclePk(
				identificador.getEmbedded().getCodi(),				
				dto.getTransportista().getPk().getCodi(),
				dto.getCodi());
	}

}
