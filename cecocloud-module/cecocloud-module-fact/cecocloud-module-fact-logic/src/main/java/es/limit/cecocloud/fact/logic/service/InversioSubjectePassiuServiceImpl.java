/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.InversioSubjectePassiu;
import es.limit.cecocloud.fact.logic.api.dto.InversioSubjectePassiu.InversioSubjectePassiuPk;
import es.limit.cecocloud.fact.logic.api.service.InversioSubjectePassiuService;
import es.limit.cecocloud.fact.persist.entity.InversioSubjectePassiuEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class InversioSubjectePassiuServiceImpl extends AbstractGenericCompositePkServiceImpl<InversioSubjectePassiu, InversioSubjectePassiuEntity, InversioSubjectePassiuPk> implements InversioSubjectePassiuService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected InversioSubjectePassiuPk getPkFromDto(InversioSubjectePassiu dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());		
		return new InversioSubjectePassiuPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				"100", // TO DO: RECUPERAR EL PROJECTE
				dto.getProveidor().getPk().getCodi());
	}

}
