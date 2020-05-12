/**
 * 
 */
package es.limit.cecocloud.cita.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.logic.api.dto.Cita.CitaPk;
import es.limit.cecocloud.cita.logic.api.service.CitaService;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de cites.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CitaServiceImpl extends AbstractGenericCompositePkServiceImpl<Cita, CitaEntity, CitaPk> implements CitaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected CitaPk getPkFromDto(Cita dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new CitaPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getPuntVenda().getPk().getCodi(),
				0);
	}

}
