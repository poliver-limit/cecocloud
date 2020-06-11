/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment.CaixaMovimentPk;
import es.limit.cecocloud.ecom.logic.api.service.CaixaMovimentService;
import es.limit.cecocloud.ecom.persist.entity.CaixaMovimentEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de CaixaMoviment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomCaixaMovimentService")
public class CaixaMovimentServiceImpl extends AbstractGenericCompositePkServiceImpl<CaixaMoviment, CaixaMovimentEntity, CaixaMovimentPk> implements CaixaMovimentService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected CaixaMovimentPk getPkFromDto(CaixaMoviment dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new CaixaMovimentPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getCaixa().getPk().getCodi(),
				dto.getNumero()
		);
	}

}
