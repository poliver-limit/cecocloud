/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial.RegistreComercialPk;
import es.limit.cecocloud.fact.logic.api.service.RegistreComercialService;
import es.limit.cecocloud.fact.persist.entity.RegistreComercialEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de registres comercials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegistreComercialServiceImpl extends AbstractGenericCompositePkServiceImpl<RegistreComercial, RegistreComercialEntity, RegistreComercialPk> implements RegistreComercialService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected RegistreComercialPk getPkFromDto(RegistreComercial dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new RegistreComercialPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getSequencia());
	}

}
