/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup.EmpresaGrupPk;
import es.limit.cecocloud.fact.logic.api.service.EmpresaGrupService;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de empreses del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factEmpresaGrupService")
public class EmpresaGrupServiceImpl extends AbstractGenericCompositePkServiceImpl<EmpresaGrup, EmpresaGrupEntity, EmpresaGrupPk> implements EmpresaGrupService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected EmpresaGrupPk getPkFromDto(EmpresaGrup dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new EmpresaGrupPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getGrup().getPk().getCodi(),				
				dto.getEmpresa().getPk().getCodi());
	}

}
