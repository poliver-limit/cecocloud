/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte;
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte.EstudiProjectePk;
import es.limit.cecocloud.fact.logic.api.service.EstudiProjecteService;
import es.limit.cecocloud.fact.persist.entity.EstudiProjecteEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de EstudiProjecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEstudiProjecteServiceImpl")
public class EstudiProjecteServiceImpl extends AbstractGenericCompositePkServiceImpl<EstudiProjecte, EstudiProjecteEntity, EstudiProjectePk> implements EstudiProjecteService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected EstudiProjectePk getPkFromDto(EstudiProjecte dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new EstudiProjectePk(
				identificador.getEmbedded().getCodi(),
				empresa.getEmbedded().getCodi(),
				dto.getNumero(),
				dto.getProjecte().getPk().getCodi(),
				dto.getCodi());
	}

}
