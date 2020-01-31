/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Departament;
import es.limit.cecocloud.fact.logic.api.dto.Departament.DepartamentPk;
import es.limit.cecocloud.fact.logic.api.service.DepartamentService;
import es.limit.cecocloud.fact.persist.entity.DepartamentEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de departaments.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DepartamentServiceImpl extends AbstractGenericCompositePkServiceImpl<Departament, DepartamentEntity, DepartamentPk> implements DepartamentService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected DepartamentPk getPkFromDto(Departament dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new DepartamentPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
