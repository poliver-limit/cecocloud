/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses.EmpresaGrupEmpresesPk;
import es.limit.cecocloud.fact.logic.api.service.EmpresaGrupEmpresesService;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEmpresesEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de empreses del grup de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaGrupEmpresesService")
public class EmpresaGrupEmpresesServiceImpl extends AbstractGenericCompositePkServiceImpl<EmpresaGrupEmpreses, EmpresaGrupEmpresesEntity, EmpresaGrupEmpresesPk> implements EmpresaGrupEmpresesService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected EmpresaGrupEmpresesPk getPkFromDto(EmpresaGrupEmpreses dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new EmpresaGrupEmpresesPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getGrupEmpreses().getPk().getCodi(),				
				dto.getEmpresa().getPk().getCodi());
	}

}
