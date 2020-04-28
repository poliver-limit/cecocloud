/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Caixa;
import es.limit.cecocloud.fact.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.fact.logic.api.service.CaixaService;
import es.limit.cecocloud.fact.persist.entity.CaixaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de caixes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CaixaServiceImpl extends AbstractGenericCompositePkServiceImpl<Caixa, CaixaEntity, CaixaPk> implements CaixaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected CaixaPk getPkFromDto(Caixa dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new CaixaPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
