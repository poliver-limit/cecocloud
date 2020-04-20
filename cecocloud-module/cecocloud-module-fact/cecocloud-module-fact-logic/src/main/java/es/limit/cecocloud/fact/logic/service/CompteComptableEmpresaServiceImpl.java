/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.CompteComptableEmpresa.CompteComptableEmpresaPk;
import es.limit.cecocloud.fact.logic.api.service.CompteComptableEmpresaService;
import es.limit.cecocloud.fact.persist.entity.CompteComptableEmpresaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
//import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
//import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CompteComptableEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<CompteComptableEmpresa, CompteComptableEmpresaEntity, CompteComptableEmpresaPk> implements CompteComptableEmpresaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
//	@Autowired
//	private EmpresaRepository empresaRepository;

	@Override
	protected CompteComptableEmpresaPk getPkFromDto(CompteComptableEmpresa dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
//		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new CompteComptableEmpresaPk(
				identificador.getEmbedded().getCodi(),				
				dto.getClient().getPk().getCodi(),
//				empresa.getEmbedded().getCodi()
				dto.getEmpresa().getPk().getCodi()
				);
	}

}
